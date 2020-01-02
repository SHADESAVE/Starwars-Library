package com.example.starwarslib.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planets_table")
data class Planets(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = 0,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "img_src_url")
    var imgSrcUrl: String = "",

    @ColumnInfo(name = "entity_name")
    var entityName: String?,

    @ColumnInfo(name = "rotation_period")
    var rotation_period: String?,

    @ColumnInfo(name = "orbital_period")
    var orbital_period: String?,

    @ColumnInfo(name = "diameter")
    var diameter: String?,

    @ColumnInfo(name = "climate")
    var climate: String?,

    @ColumnInfo(name = "gravity")
    var gravity: String?,

    @ColumnInfo(name = "terrain")
    var terrain: String?,

    @ColumnInfo(name = "surface_water")
    var surface_water: String?,

    @ColumnInfo(name = "population")
    var population: String?
)