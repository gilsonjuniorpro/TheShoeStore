package theshoestore.ca.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Shoes(
    val title: String,
    val description: String,
    val price: String,
    val picture: Int
) : Parcelable {
}