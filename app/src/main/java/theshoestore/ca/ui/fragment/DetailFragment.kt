package theshoestore.ca.ui.fragment

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
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
import theshoestore.ca.util.Util
import theshoestore.ca.viewmodel.DetailViewModel
import theshoestore.ca.viewmodel.DetailViewModelFactory
import java.io.File
import java.util.*
import kotlin.random.Random


class DetailFragment : Fragment() {

    private val TAG = DetailFragment::class.java.simpleName
    private lateinit var binding: FragmentDetailBinding
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var detailViewModelFactory: DetailViewModelFactory
    private lateinit var messageSuccess: String
    private var isInEditionMode = false
    private var imagePath: String? = ""
    private lateinit var shoesOriginal: DetailFragmentArgs

    private lateinit var uri: Uri

    private val takePicture =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSaved ->
            if (isSaved) {
                imagePath = uri.toString()
                Glide
                    .with(requireActivity())
                    .load(uri)
                    .placeholder(R.drawable.shoes_sample)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.ivPicture)
            }
        }

    private val askMultiplePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->
            for (entry in map.entries) {
                Toast.makeText(
                    requireActivity(),
                    "${entry.key} = ${entry.value}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    private val pickImages =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                imagePath = uri.toString()
                val bitmap = Util.getBitmap(it)
                binding.ivPicture.setImageBitmap(bitmap)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bar = (activity as AppCompatActivity).supportActionBar
        bar?.hide()
    }

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

        shoesOriginal = DetailFragmentArgs.fromBundle(requireArguments())

        shoesOriginal.shoe?.let { detailViewModel.setShoes(it) }

        if (shoesOriginal.shoe != null) {
            //detailViewModel.setShoes(shoesOriginal.shoe as Shoes)
            imagePath = detailViewModel.pictureUri
            Util.loadImage(shoesOriginal.shoe!!, requireContext(), binding.ivPicture)
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
            } else {
                setMessageSuccess(
                    getString(R.string.msg_shoes_updated_success)
                )
            }
        })

        detailViewModel.isInserting.observe(viewLifecycleOwner, { isInserting ->
            changeIconSaveOrEdit()
            changeVisibility()
        })

        binding.btRegister.setOnClickListener {
            saveShoes()
        }

        binding.ivAddPicture.setOnClickListener {
            if ((ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED) &&
                (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED)
            ) {
                showPictureDialog()
            } else {
                makeRequest()
            }
        }

        binding.ivSave.setOnClickListener {
            if (isInEditionMode) {
                saveShoes()
            } else {
                isInEditionMode = true
                detailViewModel.setEditEnabled()
            }
        }

        binding.ivBack.setOnClickListener {
            Util.cancelInsertOrEdition(requireContext(), findNavController(requireView()))
        }
    }

    private fun showPictureDialog() {
        val items = arrayOf(getString(R.string.select_photo_from_gallery), getString(R.string.capture_photo_from_camera))

        val pictureDialog = AlertDialog.Builder(requireContext())

        pictureDialog.setTitle(getString(R.string.select_action))

        pictureDialog.setItems(items) { _, which ->
            if (which == 0) {
                choosePhotoFromGallery()
            } else {
                takePhotoFromCamera()
            }
        }
        val dialog = pictureDialog.create()
        dialog.show()
    }

    private fun choosePhotoFromGallery() {
        pickImages.launch("image/*")
    }

    private fun takePhotoFromCamera() {
        val photoFile = File.createTempFile(
            "shoes_app_${Calendar.getInstance().timeInMillis}",
            ".jpg",
            requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        )

        uri = FileProvider.getUriForFile(
            requireContext(),
            "${requireContext().packageName}.provider",
            photoFile
        )

        takePicture.launch(uri)
    }

    private fun makeRequest() {
        askMultiplePermissions.launch(
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        )
    }

    private fun setMessageSuccess(message: String) {
        this.messageSuccess = message
    }

    private fun changeIconSaveOrEdit() {
        binding.ivSave.setImageDrawable(
            ResourcesCompat.getDrawable(resources, R.drawable.ic_done, null)
        )
    }

    private fun changeIconShoesToSample() {
        binding.ivPicture.setImageDrawable(
            ResourcesCompat.getDrawable(resources, R.drawable.shoes_sample, null)
        )
    }

    private fun changeVisibility() {
        binding.ivAddPicture.visibility = View.VISIBLE
        binding.viewAdd.visibility = View.VISIBLE
    }

    private fun validateFields(): Boolean {
        return when {
            imagePath == null -> {
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

    private fun saveShoes() {
        if (validateFields()) {
            isInEditionMode = false
            val shoesName: String? =
                if (binding.tietName.text.isNullOrBlank()) shoesOriginal.shoe?.title
                else binding.tietName.text.toString()
            val shoesPrice: String? =
                if (binding.tietPrice.text.isNullOrBlank()) shoesOriginal.shoe?.price
                else binding.tietPrice.text.toString()
            val shoesDescription: String? =
                if (binding.tietDescription.text.isNullOrBlank()) shoesOriginal.shoe?.description
                else binding.tietDescription.text.toString()
            val picture = shoesOriginal.shoe?.picture ?: ""
            detailViewModel.saveShoes(shoesName, shoesPrice, shoesDescription, picture, imagePath)
            navigateToList()
        }
    }

    private fun navigateToList() {
        Mark.showAlertSuccess(requireActivity(), getMessageSuccess())
        Handler().postDelayed({
            binding.progressBar.visibility = View.GONE
            findNavController(requireView()).navigate(
                DetailFragmentDirections.actionDetailFragmentToListFragment()
            )
        }, 2000L)
    }

    private fun getMessageSuccess(): String {
        return this.messageSuccess
    }
}
