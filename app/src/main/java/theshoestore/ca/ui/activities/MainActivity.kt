package theshoestore.ca.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_on_boarding.*
import theshoestore.ca.R
import theshoestore.ca.ui.fragment.DetailFragment
import theshoestore.ca.ui.fragment.DetailFragmentDirections
import theshoestore.ca.ui.fragment.ListFragmentDirections
import theshoestore.ca.util.Util

class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.navHost) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        val current = navController.currentDestination?.id
        if (current == R.id.detailFragment) {
            Util.cancelInsertOrEdition(this, navController)
        }else{
            super.onBackPressed()
        }
    }
}
