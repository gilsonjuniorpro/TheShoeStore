package theshoestore.ca.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jarvis.ca.Mark
import theshoestore.ca.R
import theshoestore.ca.databinding.FragmentDetailBinding
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository
import theshoestore.ca.util.Util
import theshoestore.ca.viewmodel.DetailViewModel
import theshoestore.ca.viewmodel.DetailViewModelFactory

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var detailViewModelFactory: DetailViewModelFactory
    private var fakeImage: Int = 0

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        detailViewModelFactory = DetailViewModelFactory(ShoesRepository(requireContext()))
        detailViewModel = ViewModelProvider(this, detailViewModelFactory)
                .get(DetailViewModel::class.java)

        binding.detailViewModel = detailViewModel

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = DetailFragmentArgs.fromBundle(requireArguments())

        args.shoe?.let { detailViewModel.setShoes(it) }

        if (args.shoe != null) {
            binding.ivPicture.setImageDrawable(
                    args.shoe?.picture?.let { ResourcesCompat.getDrawable(resources, it, null) }
            )
        } else {
            binding.ivPicture.setImageDrawable(
                    ResourcesCompat.getDrawable(resources, R.drawable.shoes_sample, null)
            )
        }

        binding.btRegister.setOnClickListener{
            saveShoes()
        }

        binding.ivAddPicture.setOnClickListener{
            addFakeShoes()
        }
    }

    private fun addFakeShoes() {
        fakeImage = Util.getImage()

        binding.ivPicture.setImageDrawable(
                ResourcesCompat.getDrawable(
                        resources,
                        fakeImage, null
                )
        )

        Mark.showAlertSuccess(requireActivity(), getString(R.string.msg_fake_image_added))
    }

    private fun validateFields() : Boolean{
        return when {
            fakeImage == 0 -> {
                Mark.showAlertError(requireActivity(), getString(R.string.msg_fill_image))
                false
            }
            binding.tietPrice.text.isNullOrEmpty() -> {
                Mark.showAlertError(requireActivity(), getString(R.string.msg_fill_price))
                binding.tietPrice.requestFocus()
                false
            }
            binding.tietName.text.isNullOrEmpty() -> {
                Mark.showAlertError(requireActivity(), getString(R.string.msg_fill_name))
                binding.tietName.requestFocus()
                false
            }
            binding.tietDescription.text.isNullOrEmpty() -> {
                Mark.showAlertError(requireActivity(), getString(R.string.msg_fill_description))
                binding.tietDescription.requestFocus()
                false
            }
            else -> {
                true
            }
        }
    }

    private fun saveShoes(){
        if(validateFields()){
            val shoesName: String = binding.tietName.text.toString()
            val shoesPrice: String = binding.tietPrice.text.toString()
            val shoesDescription: String = binding.tietDescription.text.toString()

            val shoes = Shoes(
                    0,
                    shoesName,
                    shoesDescription,
                    shoesPrice,
                    fakeImage
            )

            detailViewModel.saveShoes(shoes)
            navigateToList()
        }
    }

    private fun navigateToList() {
        Mark.showAlertSuccess(requireActivity(), getString(R.string.msg_shoes_added_success))
        Handler().postDelayed({
            binding.progressBar.visibility = View.GONE
            findNavController().navigate(
                    DetailFragmentDirections.actionDetailFragmentToListFragment())
        }, 2000L)
    }
}