package theshoestore.ca.model

import theshoestore.ca.R

object Starter {
    val starters = arrayOf(
        Item(
            "THE HISTORY AND EVOLUTION OF SHOES",
            "It’s hard to imagine what life was like when shoes weren’t discovered yet. Everything started because of a real and practical need to protect the feet from outside effects.",
            R.drawable.intro001,
            R.color.colorScreen1
        ),
        Item(
            "WHEN DID THE FIRST SHOES APPEAR?",
            "1991 is an important date in the history of footwear because this is the year when, at the border of Austria and Italy",
            R.drawable.intro002,
            R.color.colorScreen2
        ),
        Item(
            "THE HISTORY OF FOOTWEAR",
            "The first sandals emerged in ancient Egypt. They were made from palm leaves, papyrus fiber and raw leather. ",
            R.drawable.intro003,
            R.color.colorScreen3
        ),
        Item(
            "THE MIDDLE AGES(476–1453)",
            "Although the Middle Ages are considered the dark ages, it was during this time that a lot of new footwear trends and fashion appeared.",
            R.drawable.intro004,
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