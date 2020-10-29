package theshoestore.ca.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import theshoestore.ca.R
import theshoestore.ca.databinding.FragmentListBinding
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository
import theshoestore.ca.viewmodel.ListViewModel
import theshoestore.ca.viewmodel.ListViewModelFactory
import theshoestore.ca.viewmodel.LoginViewModel
import theshoestore.ca.viewmodel.LoginViewModelFactory


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    //private lateinit var viewModel: LoginViewModel
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

        val application = requireNotNull(this.activity).application

        listViewModelFactory = ListViewModelFactory(ShoesRepository(requireContext()), application)
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

        listViewModel.allShoes.observe(viewLifecycleOwner, { list ->
            setView(list)
            //setItemsToRecyclerView(list)
        })

        listViewModel.isPopulated.observe(viewLifecycleOwner, { isPopulated ->
            if (!isPopulated) {
                listViewModel.insertListShoes()
                listViewModel.setPopulated()
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

    private fun setView(list: List<Shoes>) {
        val inflater : LayoutInflater = LayoutInflater.from(requireContext())
        list.forEach { shoes ->
            val view: View = inflater.inflate(R.layout.item_shoes, binding.recyclerShoes, false)
            val picture: ImageView = view.findViewById(R.id.ivPicture)
            val title: TextView = view.findViewById(R.id.tvName)
            val description: TextView = view.findViewById(R.id.tvDescription)
            val price: TextView = view.findViewById(R.id.tvPrice)

            picture.setImageDrawable(
                    ResourcesCompat.getDrawable(
                            resources,
                            shoes.picture, null
                    )
            )

            title.text = shoes.title
            description.text = shoes.description
            price.text = shoes.price

            view.setOnClickListener{
                openDetail(shoes)
            }
            binding.recyclerShoes.addView(view)
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