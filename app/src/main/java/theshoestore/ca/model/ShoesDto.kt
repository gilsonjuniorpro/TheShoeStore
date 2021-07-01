package theshoestore.ca.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ShoesDto(
    val id: Int? = -1,
    val title: String? = null,
    val description: String? = null,
    val price: String? = null,
    val picture: String? = null
): Parcelable