package theshoestore.ca.model

import theshoestore.ca.R

object Starter {
    val starters = arrayOf(
        Item(
            "Shoe 1",
            "body 1",
            R.drawable.ic_make,
            R.color.colorScreen1
        ),
        Item(
            "Shoe 2",
            "body 2",
            R.drawable.ic_map,
            R.color.colorScreen2
        ),
        Item(
            "Shoe 3",
            "body 3",
            R.drawable.ic_paving,
            R.color.colorScreen3
        ),
        Item(
            "Shoe 4",
            "body 4",
            R.drawable.ic_sign,
            R.color.colorScreen4
        )
    )

    class Item(
        var title: String,
        var body: String,
        var image: Int,
        var color: Int
    )
}