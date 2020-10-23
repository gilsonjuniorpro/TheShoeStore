package theshoestore.ca.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_shoes.view.*
import theshoestore.ca.R
import theshoestore.ca.model.Shoes

class ShoesAdapter(
    private val items: List<Shoes>,
    private val onItemClick: (Shoes) -> Unit
): RecyclerView.Adapter<ShoesAdapter.ShoeHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoeHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shoes, parent, false)

        context = parent.context

        return ShoeHolder(layout)
    }

    override fun onBindViewHolder(holder: ShoeHolder, position: Int) {
        val shoe = items[position]

        holder.tvName.text = shoe.title
        holder.tvDescription.text = shoe.description
        holder.tvPrice.text = shoe.price
        holder.ivPicture.setImageDrawable(
            ResourcesCompat.getDrawable(context!!.resources, shoe.picture, null)
        )

        holder.itemView.setOnClickListener{ onItemClick(shoe) }
    }

    override fun getItemCount(): Int = items.size

    class ShoeHolder(rootView: View) : RecyclerView.ViewHolder(rootView){
        val tvName: TextView = rootView.tvName
        val tvDescription: TextView = rootView.tvDescription
        val tvPrice: TextView = rootView.tvPrice
        val ivPicture: ImageView = rootView.ivPicture
    }
}