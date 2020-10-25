package theshoestore.ca.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import theshoestore.ca.R
import theshoestore.ca.databinding.FragmentAddShoesBinding
import theshoestore.ca.databinding.FragmentDetailBinding

class AddShoesFragment : Fragment() {

    private lateinit var binding: FragmentAddShoesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddShoesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.tvName.text = args.shoe.title
        binding.tvDescription.text = args.shoe.description
        binding.tvPrice.text = args.shoe.price
        binding.ivPicture.setImageDrawable(
            ResourcesCompat.getDrawable(resources, args.shoe.picture, null)
        )*/
    }
}