package theshoestore.ca.util

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import theshoestore.ca.model.Shoes

class CustomAdapter(
    private val items: List<Shoes>,
    private val onItemClick: (Shoes) -> Unit
) : BaseAdapter() {
    override fun getCount(): Int {
        return 0
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(i: Int, view: View, viewGroup: ViewGroup): View? {
        return null
    }
}