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
import theshoestore.ca.R
import theshoestore.ca.ui.fragment.DetailFragment
import theshoestore.ca.ui.fragment.DetailFragmentDirections
import theshoestore.ca.ui.fragment.ListFragmentDirections

class MainActivity : AppCompatActivity() {

    val navController by lazy { findNavController(R.id.navHost) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        var current = navController.currentDestination?.id
        if (current == R.id.detailFragment) {
            cancelInsertOrEdition()
        }else{
            super.onBackPressed()
        }
    }

    fun cancelInsertOrEdition() {
        val builder = AlertDialog.Builder(this, R.style.AlertDialogTheme)

        builder.setMessage(getString(R.string.msg_cancel_operation))
        .setTitle(getString(R.string.app_name))
        .setCancelable(false)
        .setPositiveButton(getString(R.string.dialog_positive)) { _, _ ->
            navController.navigate(R.id.listFragment)
            /*navController.navigate(   //bug here
                DetailFragmentDirections.actionDetailFragmentToListFragment())*/
        }
        .setNegativeButton(getString(R.string.dialog_negative)) { _, _ -> }

        val dialog = builder.create()
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val layParams = dialog.window!!.attributes
        layParams.gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL
        dialog.window!!.attributes = layParams
        dialog.show()
    }
}

