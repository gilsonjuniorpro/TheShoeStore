package theshoestore.ca.ui.fragment

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import theshoestore.ca.R
import theshoestore.ca.databinding.FragmentListBinding
import theshoestore.ca.databinding.FragmentOnBoardingBinding
import theshoestore.ca.model.Starter
import theshoestore.ca.ui.activities.IntroActivity
import theshoestore.ca.ui.activities.MainActivity
import theshoestore.ca.util.PrefManager
import theshoestore.ca.viewmodel.LoginViewModel
import theshoestore.ca.viewmodel.OnBoardingViewModel

class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var viewModel: OnBoardingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(OnBoardingViewModel::class.java)

        binding.onBoardingViewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.isFirstTime.observe(viewLifecycleOwner, { firstTime ->
            if (!firstTime) {
                goToList()
            }
        })

        viewModel.isItTheFirstTime()

        changeStatusBarColor()

        binding.viewPager.adapter = StarterPagerAdapter(Starter.starters, requireContext())
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.btnSkip.setOnClickListener { v: View ->
            viewModel.setNotFirstTime()
        }

        binding.btnNext.setOnClickListener { v: View ->
            val current: Int = getItem(+1)
            if (current < Starter.starters.size) {
                binding.viewPager.currentItem = current
            } else {
                viewModel.setNotFirstTime()
            }
        }

        return binding.root
    }

    private fun getItem(i: Int): Int {
        return binding.viewPager.currentItem + i
    }

    private fun goToList(){
        findNavController().navigate(
            OnBoardingFragmentDirections.actionOnBoardingFragmentToListFragment()
        )
    }

    private fun changeStatusBarColor() {
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }*/
    }

    class StarterPagerAdapter(private val starters: Array<Starter.Item>, var context: Context) :
        RecyclerView.Adapter<StarterViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, position: Int): StarterViewHolder {
            return StarterViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.starter_list_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: StarterViewHolder, position: Int) {
            holder.tvStarter.text = starters[position].body
            holder.tvStarterTitle.text = starters[position].title
            holder.ivImage.setImageDrawable(
                ResourcesCompat.getDrawable(
                    context.resources,
                    starters[position].image, null
                )
            )
            holder.container.setBackgroundColor(
                ContextCompat.getColor(context, starters[position].color)
            )
        }

        override fun getItemCount() = starters.size
    }

    class StarterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvStarter: TextView = view.findViewById(R.id.tvStarter)
        val tvStarterTitle: TextView = view.findViewById(R.id.tvStarterTitle)
        val ivImage: ImageView = view.findViewById(R.id.ivImage)
        val container: ConstraintLayout = view.findViewById(R.id.containerStarter)
    }
}