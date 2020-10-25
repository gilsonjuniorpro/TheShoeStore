package theshoestore.ca.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import theshoestore.ca.databinding.FragmentAddShoesBinding
import theshoestore.ca.model.Shoes
import theshoestore.ca.util.Util
import theshoestore.ca.viewmodel.AddShoesViewModel
import theshoestore.ca.viewmodel.AddShoesViewModelFactory

class AddShoesFragment : Fragment() {

    private lateinit var binding: FragmentAddShoesBinding
    private lateinit var addShoesViewModel: AddShoesViewModel
    private lateinit var addShoesViewModelFactory: AddShoesViewModelFactory
    private lateinit var items: MutableList<Shoes>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddShoesBinding.inflate(inflater, container, false)

        addShoesViewModelFactory = AddShoesViewModelFactory(items)
        addShoesViewModel = ViewModelProvider(this, addShoesViewModelFactory)
            .get(AddShoesViewModel::class.java)

        binding.addShoesViewModel = addShoesViewModel

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btRegister.setOnClickListener{
            saveShoes()
        }
    }

    private fun saveShoes(){
        val shoes = Shoes(
            "test",
            "test",
            "$109.00",
            Util.getImage()
        )

        addShoesViewModel.saveShoes(shoes)
    }
}