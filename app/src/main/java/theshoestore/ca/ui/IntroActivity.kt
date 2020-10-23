package theshoestore.ca.ui

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import theshoestore.ca.R
import theshoestore.ca.databinding.ActivityIntroBinding
import theshoestore.ca.model.Starter
import theshoestore.ca.util.PrefManager

class IntroActivity : AppCompatActivity() {

    private lateinit var mPrefManager: PrefManager
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_intro
        )

        changeStatusBarColor()

        mPrefManager = PrefManager(this)
        if (!mPrefManager.isFirstTimeLaunch()) {
            gotToLogin()
        }

        binding.viewPager.adapter = StarterPagerAdapter(Starter.starters, this)
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.btnSkip.setOnClickListener { v: View ->
            gotToLogin()
        }

        binding.btnNext.setOnClickListener { v: View ->
            val current: Int = getItem(+1)
            if (current < Starter.starters.size) {
                binding.viewPager.currentItem = current
            } else {
                gotToLogin()
            }
        }
    }

    private fun getItem(i: Int): Int {
        return binding.viewPager.currentItem + i
    }

    private fun gotToLogin(){
        mPrefManager.setFirstTimeLaunch(false)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //val window: Window = window
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    class StarterPagerAdapter(private val starters: Array<Starter.Item>, var context: Context) : RecyclerView.Adapter<StarterViewHolder>() {
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
                context.resources.getDrawable(starters[position].image),
            )
            holder.container.setBackgroundColor(
                context.resources.getColor(starters[position].color)
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