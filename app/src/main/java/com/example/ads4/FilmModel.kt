package com.example.ads4

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmModel (
    var id: String ?="",
    var judul : String ?="",
    var desc : String ?="",
    var genre : String ?="",
    var poster : Int ?=0,
    var trailer : Int ?=0,
    var rating : Float
) : Parcelable