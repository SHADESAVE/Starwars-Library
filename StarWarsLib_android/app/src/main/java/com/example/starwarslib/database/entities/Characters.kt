package com.example.starwarslib.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters_table")
data class Characters(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int?,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "img_src_url")
    var imgSrcUrl: String,

    @ColumnInfo(name = "entity_name")
    var entityName: String?,

    @ColumnInfo(name = "height")
    val height: String?,

    @ColumnInfo(name = "mass")
    val mass: String?,

    @ColumnInfo(name = "hair_color")
    val hair_color: String?,

    @ColumnInfo(name = "eye_color")
    val eye_color: String?,

    @ColumnInfo(name = "skin_color")
    val skin_color: String?,

    @ColumnInfo(name = "gender")
    val gender: String?,

    @ColumnInfo(name = "birth_year")
    val birth_year: String?
)