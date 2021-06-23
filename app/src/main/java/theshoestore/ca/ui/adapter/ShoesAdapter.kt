package theshoestore.ca.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import theshoestore.ca.databinding.ItemShoesBinding
import theshoestore.ca.model.Shoes

class ShoesAdapter(private val clickListener: ShoesListener) : ListAdapter<Shoes,
        ShoesAdapter.ShoesHolder>(ShoesCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesHolder {
        return ShoesHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ShoesHolder, position: Int) {
        val shoes = getItem(position)
        holder.bind(clickListener, shoes)
    }

    class ShoesHolder private constructor(private val binding: ItemShoesBinding):
            RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: ShoesListener, shoes: Shoes) {
            binding.shoes = shoes
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ShoesHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemShoesBinding.inflate(layoutInflater, parent, false)
                return ShoesHolder(binding)
            }
        }
    }
}

class ShoesCallBack : DiffUtil.ItemCallback<Shoes>() {
    override fun areItemsTheSame(oldItem: Shoes, newItem: Shoes): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Shoes, newItem: Shoes): Boolean {
        return oldItem == newItem
    }
}

class ShoesListener(val clickListener: (shoes: Shoes) -> Unit) {
    fun onClick(shoes: Shoes) = clickListener(shoes)
}
