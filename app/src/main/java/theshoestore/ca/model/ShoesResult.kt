package theshoestore.ca.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ShoesResult(
    val items: List<ShoesDto>
): Parcelable