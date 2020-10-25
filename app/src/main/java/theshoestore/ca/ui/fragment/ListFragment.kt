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
import theshoestore.ca.ui.adapter.ShoesAdapter
import theshoestore.ca.util.Util
import theshoestore.ca.viewmodel.LoginViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginViewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.isUserLoggedIn.observe(viewLifecycleOwner, { isLoggedIn ->
            if (!isLoggedIn) {
                findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToLoginFragment()
                )
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
        val items: List<Shoes> = Util.getListOfShoes()
        binding.recyclerShoes.layoutManager = LinearLayoutManager(requireContext())
        val adapter = ShoesAdapter(items, this::openDetail)
        binding.recyclerShoes.adapter = adapter
    }

    fun openDetail(shoe: Shoes){
        findNavController().navigate(
            ListFragmentDirections.actionListFragmentToDetailFragment(shoe))
    }

    fun openAddShoes(){
        findNavController().navigate(
            ListFragmentDirections.actionListFragmentToAddShoesFragment())
    }
}