package theshoestore.ca.util

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import theshoestore.ca.model.Shoes

@BindingAdapter("shoesImage")
fun ImageView.setShoesImage(shoes: Shoes?) {
    shoes?.let {
        setImageDrawable(
            ResourcesCompat.getDrawable(
                resources,
                shoes.picture, null
            )
        )
    }
}

@BindingAdapter("shoesName")
fun TextView.setShoesName(shoes: Shoes?) {
    shoes?.let {
        text = shoes.title
    }
}

@BindingAdapter("shoesPrice")
fun TextView.setShoesPrice(shoes: Shoes?) {
    shoes?.let {
        text = shoes.price
    }
}

@BindingAdapter("shoesDescription")
fun TextView.setShoesDescription(shoes: Shoes?) {
    shoes?.let {
        text = shoes.description
    }
}
