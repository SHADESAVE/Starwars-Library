package com.example.starwarslib.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StarWarsItem(

    val id: Int?,
    val entityName: String?,
    val imgSrcUrl: String?,
    val textContainer1: String?,
    val textContainer2: String?,
    val textContainer3: String?,
    val textContainer4: String?,
    val textContainer5: String?,
    val textContainer6: String?,
    val textContainer7: String?,
    val textContainer8: String?,
    val textContainer9: String?,
    val textContainer10: String?
) : Parcelable
