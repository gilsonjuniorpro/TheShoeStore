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
        return ShoeHolder.from(this, parent)
    }

    override fun onBindViewHolder(holder: ShoeHolder, position: Int) {
        val shoe = items[position]

        holder.bind(shoe, context, onItemClick(shoe))
    }

    override fun getItemCount(): Int = items.size

    class ShoeHolder private constructor(rootView: View) : RecyclerView.ViewHolder(rootView){
        private val tvName: TextView = rootView.tvName
        private val tvDescription: TextView = rootView.tvDescription
        private val tvPrice: TextView = rootView.tvPrice
        private val ivPicture: ImageView = rootView.ivPicture

        fun bind(shoe: Shoes, context: Context?, onItemClick: Unit) {
            tvName.text = shoe.title
            tvDescription.text = shoe.description
            tvPrice.text = shoe.price
            ivPicture.setImageDrawable(
                    ResourcesCompat.getDrawable(context!!.resources, shoe.picture!!, null)
            )
            itemView.setOnClickListener { onItemClick }
        }

        companion object {
            fun from(shoesAdapter: ShoesAdapter, parent: ViewGroup): ShoeHolder {
                val layout = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_shoes, parent, false)

                shoesAdapter.context = parent.context

                return ShoeHolder(layout)
            }
        }
    }


}