package theshoestore.ca.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import theshoestore.ca.databinding.FragmentDetailBinding
import theshoestore.ca.viewmodel.DetailViewModel
import theshoestore.ca.viewmodel.LoginViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.detailViewModel = viewModel

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = DetailFragmentArgs.fromBundle(requireArguments())

        viewModel.setShoes(args.shoe)

        binding.ivPicture.setImageDrawable(
            args.shoe.picture?.let { ResourcesCompat.getDrawable(resources, it, null) }
        )
    }
}