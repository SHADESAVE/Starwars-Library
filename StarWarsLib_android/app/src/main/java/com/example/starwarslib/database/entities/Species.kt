package com.example.starwarslib.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "species_table")
data class Species(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = 0,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "img_src_url")
    var imgSrcUrl: String,

    @ColumnInfo(name = "entity_name")
    var entityName: String?,

    @ColumnInfo(name = "classification")
    var classification: String?,

    @ColumnInfo(name = "designation")
    var designation: String?,

    @ColumnInfo(name = "average_height")
    var average_height: String?,

    @ColumnInfo(name = "hair_color")
    val hair_color: String?,

    @ColumnInfo(name = "eye_color")
    val eye_color: String?,

    @ColumnInfo(name = "skin_color")
    val skin_color: String?,

    @ColumnInfo(name = "average_lifespan")
    var average_lifespan: String?,

    @ColumnInfo(name = "language")
    var language: String?
)