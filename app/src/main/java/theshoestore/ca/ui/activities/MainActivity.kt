package theshoestore.ca.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import theshoestore.ca.R
import theshoestore.ca.core.ShoesApplication
import theshoestore.ca.util.Util

class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.navHost) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ShoesApplication.setContentResolver(this.contentResolver)
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
