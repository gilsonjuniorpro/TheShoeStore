package theshoestore.ca.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import theshoestore.ca.R
import theshoestore.ca.databinding.FragmentListBinding
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository
import theshoestore.ca.ui.adapter.ShoesAdapter
import theshoestore.ca.ui.adapter.ShoesListener
import theshoestore.ca.viewmodel.ListViewModel
import theshoestore.ca.viewmodel.ListViewModelFactory
import theshoestore.ca.viewmodel.LoginViewModel
import theshoestore.ca.viewmodel.LoginViewModelFactory


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var listViewModelFactory: ListViewModelFactory
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginViewModelFactory: LoginViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val bar = (activity as AppCompatActivity).supportActionBar
        bar?.show()

        binding = FragmentListBinding.inflate(inflater, container, false)

        Handler().postDelayed({
            binding.progressBar.visibility = View.GONE
        }, 2000L)

        listViewModelFactory = ListViewModelFactory(ShoesRepository(requireContext()))
        listViewModel = ViewModelProvider(this, listViewModelFactory)
            .get(ListViewModel::class.java)

        loginViewModelFactory = LoginViewModelFactory(requireContext())
        loginViewModel = ViewModelProvider(this, loginViewModelFactory)
            .get(LoginViewModel::class.java)

        binding.listViewModel = listViewModel

        binding.lifecycleOwner = this

        loginViewModel.isUserLoggedIn.observe(viewLifecycleOwner, { isLoggedIn ->
            if (!isLoggedIn) {
                findNavController().navigate(
                        ListFragmentDirections.actionListFragmentToLoginFragment()
                )
            }
        })

        binding.recyclerShoes.layoutManager = LinearLayoutManager(requireContext())
        val adapter = ShoesAdapter(ShoesListener { shoes ->
            openDetail(shoes)
        })
        binding.recyclerShoes.adapter = adapter

        listViewModel.allShoes.observe(viewLifecycleOwner, { list ->
            adapter.submitList(list)
            binding.recyclerShoes.scrollToPosition(0)
        })

        listViewModel.isPopulated.observe(viewLifecycleOwner, { isPopulated ->
            if (!isPopulated) {
                listViewModel.insertListShoes()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivAdd.setOnClickListener{
            openAddShoes()
        }
    }

    private fun openDetail(shoe: Shoes){
        findNavController().navigate(
                ListFragmentDirections.actionListFragmentToDetailFragment(shoe))
    }

    private fun openAddShoes(){
        findNavController().navigate(
                ListFragmentDirections.actionListFragmentToDetailFragment(null))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> loginViewModel.setUserNotLoggedIn()
        }
        return super.onOptionsItemSelected(item)
    }
}
