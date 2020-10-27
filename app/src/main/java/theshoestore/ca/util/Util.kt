package theshoestore.ca.util

import android.content.res.Resources
import theshoestore.ca.R
import theshoestore.ca.model.Shoes
import kotlin.random.Random

object Util {
    fun getListOfShoes(): MutableList<Shoes> {
        return mutableListOf(
            Shoes(
                1,
                "New Balance 696v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$49.00",
                R.drawable.shoe01
            ),
            Shoes(
                2,
                "New Balance 697v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$79.00",
                R.drawable.shoe02
            ),
            Shoes(
                3,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$69.00",
                R.drawable.shoe03
            ),
            Shoes(
                4,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$59.00",
                R.drawable.shoe04
            ),
            Shoes(
                5,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$89.00",
                R.drawable.shoe05
            ),
            Shoes(
                6,
                "New Balance 696v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$49.00",
                R.drawable.shoe01
            ),
            Shoes(
                7,
                "New Balance 697v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$79.00",
                R.drawable.shoe02
            ),
            Shoes(
                8,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$69.00",
                R.drawable.shoe03
            ),
            Shoes(
                9,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$59.00",
                R.drawable.shoe04
            ),
            Shoes(
                10,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$89.00",
                R.drawable.shoe05
            ),
            Shoes(
                11,
                "New Balance 696v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$49.00",
                R.drawable.shoe01
            ),
            Shoes(
                12,
                "New Balance 697v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$79.00",
                R.drawable.shoe02
            ),
            Shoes(
                13,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$69.00",
                R.drawable.shoe03
            ),
            Shoes(
                14,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$59.00",
                R.drawable.shoe04
            ),
            Shoes(
                15,
                "New Balance 698v4",
                "Hit the court in style in the latest update of the 696 -- the New Balance 696v4 Standard D Width in White/Blue. New Balance's newly updated 696v4 tennis shoe offers a grippy herringbone outsole pattern that helps you step your game up on hard courts. This shoe features a synthetic/mesh upper that also features perforations in the forefoot for superior breathability supported by a lightweight midsole.",
                "$89.00",
                R.drawable.shoe05
            )
        )
    }

    fun getImage(): Int{
        return when ((1..5).random()) {
            1 -> R.drawable.shoe01
            2 -> R.drawable.shoe02
            3 -> R.drawable.shoe03
            4 -> R.drawable.shoe04
            else -> R.drawable.shoe05
        }
    }
}