package theshoestore.ca.ui.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jarvis.ca.Mark
import theshoestore.ca.R
import theshoestore.ca.databinding.FragmentAddShoesBinding
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository
import theshoestore.ca.util.Util
import theshoestore.ca.viewmodel.AddShoesViewModel
import theshoestore.ca.viewmodel.AddShoesViewModelFactory

class AddShoesFragment : Fragment() {

    private lateinit var binding: FragmentAddShoesBinding
    private lateinit var addShoesViewModel: AddShoesViewModel
    private lateinit var addShoesViewModelFactory: AddShoesViewModelFactory
    private var fakeImage: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddShoesBinding.inflate(inflater, container, false)

        addShoesViewModelFactory = AddShoesViewModelFactory(
            ShoesRepository(requireContext()), requireContext())
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

        binding.ivAddPicture.setOnClickListener{
            addFakeShoes()
        }
    }

    private fun addFakeShoes() {
        fakeImage = Util.getImage()

        binding.ivSample.setImageDrawable(
            ResourcesCompat.getDrawable(
                resources,
                fakeImage, null
            )
        )

        Mark.showAlertSuccess(requireActivity(), getString(R.string.msg_fake_image_added))
    }

    private fun validateFields() : Boolean{
        return when {
            binding.etTitle.text.isNullOrEmpty() -> {
                Mark.showAlertError(requireActivity(), getString(R.string.msg_fill_name))
                false
            }
            binding.etPrice.text.isNullOrEmpty() -> {
                Mark.showAlertError(requireActivity(), getString(R.string.msg_fill_price))
                false
            }
            binding.etDescription.text.isNullOrEmpty() -> {
                Mark.showAlertError(requireActivity(), getString(R.string.msg_fill_description))
                false
            }
            else -> {
                true
            }
        }
    }

    private fun saveShoes(){
        if(validateFields()){
            var shoesName: String = binding.etTitle.text.toString()
            var shoesPrice: String = binding.etPrice.text.toString()
            var shoesDescription: String = binding.etDescription.text.toString()

            val shoes = Shoes(
                0,
                shoesName,
                shoesDescription,
                shoesPrice,
                fakeImage
            )

            addShoesViewModel.saveShoes(shoes)
            navigateToList()
        }
    }

    private fun navigateToList() {
        Mark.showAlertSuccess(requireActivity(), getString(R.string.msg_shoes_added_success))
        Handler().postDelayed({
            binding.progressBar.visibility = View.GONE
            findNavController().navigate(
                AddShoesFragmentDirections.actionAddShoesFragmentToListFragment())
        }, 2000L)
    }
}