package theshoestore.ca.util

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import theshoestore.ca.model.Shoes

@BindingAdapter("shoesImage")
fun ImageView.setShoesImage(shoes: Shoes?) {
    shoes?.let {
        Glide
            .with(this.context)
            .load("${Constants.URL_IMAGES}/${shoes.picture}")
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
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
