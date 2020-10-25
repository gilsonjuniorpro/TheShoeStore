package theshoestore.ca.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import theshoestore.ca.databinding.FragmentListBinding
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository
import theshoestore.ca.ui.adapter.ShoesAdapter
import theshoestore.ca.viewmodel.ListViewModel
import theshoestore.ca.viewmodel.ListViewModelFactory
import theshoestore.ca.viewmodel.LoginViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var listViewModel: ListViewModel
    private lateinit var listViewModelFactory: ListViewModelFactory

    private var items: List<Shoes> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        listViewModelFactory = ListViewModelFactory(ShoesRepository(requireContext()), requireContext())
        listViewModel = ViewModelProvider(this, listViewModelFactory)
            .get(ListViewModel::class.java)

        binding.listViewModel = listViewModel

        binding.lifecycleOwner = this

        viewModel.isUserLoggedIn.observe(viewLifecycleOwner, { isLoggedIn ->
            if (!isLoggedIn) {
                findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToLoginFragment()
                )
            }
        })

        listViewModel.allShoes.observe(viewLifecycleOwner, { list ->
            items = list
            val adapter = ShoesAdapter(items, this::openDetail)
            binding.recyclerShoes.adapter = adapter
        })

        listViewModel.isPopulated.observe(viewLifecycleOwner, { isPopulated ->
            if(!isPopulated){
                listViewModel.insertListShoes()
                listViewModel.setPopulated()
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()

        binding.ivAdd.setOnClickListener{
            openAddShoes()
        }

        binding.tvLogout.setOnClickListener{
            viewModel.setUserNotLoggedIn()
        }
    }

    private fun setRecyclerView() {
        binding.recyclerShoes.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun openDetail(shoe: Shoes){
        findNavController().navigate(
            ListFragmentDirections.actionListFragmentToDetailFragment(shoe))
    }

    private fun openAddShoes(){
        findNavController().navigate(
            ListFragmentDirections.actionListFragmentToAddShoesFragment())
    }
}