package theshoestore.ca.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jarvis.ca.Mark
import theshoestore.ca.R
import theshoestore.ca.databinding.FragmentDetailBinding
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository
import theshoestore.ca.util.Constants
import theshoestore.ca.util.Util
import theshoestore.ca.viewmodel.DetailViewModel
import theshoestore.ca.viewmodel.DetailViewModelFactory

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var detailViewModelFactory: DetailViewModelFactory
    private var fakeImage: Int = 0
    private lateinit var messageSuccess: String
    private var isInEditionMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bar = (activity as AppCompatActivity).supportActionBar
        bar?.hide()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? { //requireActivity()
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
            detailViewModel.setShoes(args.shoe as Shoes)
            Glide
                .with(requireContext())
                .load("${Constants.URL_IMAGES}/${args.shoe?.picture}")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivPicture)

            /*args.shoe?.picture?.let { image ->
                setFakeImageForEdit(image)
            }*/
            detailViewModel.setActionUpdate()
        } else {
            detailViewModel.setActionCreate()
        }

        detailViewModel.isEditing.observe(viewLifecycleOwner, { isEditing ->
            if (isEditing) {
                changeIconSaveOrEdit()
                changeVisibility()
            }
        })

        detailViewModel.action.observe(viewLifecycleOwner, { isCreating ->
            if (isCreating == DetailViewModel.Action.CREATE) {
                isInEditionMode = true
                detailViewModel.setInsertingEnabled()
                changeIconShoesToSample()
                changeVisibility()
                setMessageSuccess(
                    getString(R.string.msg_shoes_added_success)
                )
            }else{
                setMessageSuccess(
                    getString(R.string.msg_shoes_updated_success)
                )
            }
        })

        detailViewModel.isInserting.observe(viewLifecycleOwner, { isInserting ->
            changeIconSaveOrEdit()
            changeVisibility()
        })

        binding.btRegister.setOnClickListener{
            saveShoes()
        }

        binding.ivAddPicture.setOnClickListener{
            addFakeShoes()
        }

        binding.ivSave.setOnClickListener{
            if(isInEditionMode) {
                saveShoes()
            }else{
                isInEditionMode = true
                detailViewModel.setEditEnabled()
            }
        }

        binding.ivBack.setOnClickListener{
            Util.cancelInsertOrEdition(requireContext(), findNavController(requireView()))
        }
    }

    private fun setMessageSuccess(message: String) {
        this.messageSuccess = message
    }

    private fun changeIconSaveOrEdit(){
        binding.ivSave.setImageDrawable(
            ResourcesCompat.getDrawable(resources, R.drawable.ic_done, null)
        )
    }

    private fun changeIconShoesToSample(){
        binding.ivPicture.setImageDrawable(
            ResourcesCompat.getDrawable(resources, R.drawable.shoes_sample, null)
        )
    }

    private fun changeVisibility(){
        binding.ivAddPicture.visibility = View.VISIBLE
        binding.viewAdd.visibility = View.VISIBLE
    }

    private fun addFakeShoes() {
        fakeImage = Util.getImage()

        binding.ivPicture.setImageDrawable(
            ResourcesCompat.getDrawable(resources, fakeImage, null)
        )

        Mark.showAlertSuccess(requireActivity(), getString(R.string.msg_fake_image_added))
    }

    private fun setFakeImageForEdit(image: Int){
        fakeImage = image
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
            isInEditionMode = false
            val shoesName: String = binding.tietName.text.toString()
            val shoesPrice: String = binding.tietPrice.text.toString()
            val shoesDescription: String = binding.tietDescription.text.toString()

            detailViewModel.saveShoes(shoesName, shoesPrice, shoesDescription, fakeImage)
            navigateToList()
        }
    }

    private fun navigateToList() {
        Mark.showAlertSuccess(requireActivity(), getMessageSuccess())
        Handler().postDelayed({
            binding.progressBar.visibility = View.GONE
            findNavController(requireView()).navigate(
                    DetailFragmentDirections.actionDetailFragmentToListFragment())
        }, 2000L)
    }

    private fun getMessageSuccess(): String {
        return this.messageSuccess
    }
}

fun String.toName(): String {
    return this.toUpperCase()
}
