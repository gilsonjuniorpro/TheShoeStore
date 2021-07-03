package theshoestore.ca.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Shoes(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = -1,
    val title: String? = null,
    val description: String? = null,
    val price: String? = null,
    val picture: String? = null,
    val pictureUri: String? = null
) : Parcelable {

}