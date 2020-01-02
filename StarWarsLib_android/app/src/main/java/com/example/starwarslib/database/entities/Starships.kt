package com.example.starwarslib.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "starships_table")
data class Starships(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = 0,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "img_src_url")
    var imgSrcUrl: String,

    @ColumnInfo(name = "entity_name")
    var entityName: String?,
    @ColumnInfo(name = "model")
    var model: String?,

    @ColumnInfo(name = "starship_class")
    var starship_class: String?,

    @ColumnInfo(name = "manufacturer")
    var manufacturer: String?,

    @ColumnInfo(name = "cost_in_credits")
    var cost_in_credits: String?,

    @ColumnInfo(name = "length")
    var length: String?,

    @ColumnInfo(name = "max_atmosphering_speed")
    var max_atmosphering_speed: String?,

    @ColumnInfo(name = "crew")
    var crew: String?,

    @ColumnInfo(name = "passengers")
    val passengers: String?,

    @ColumnInfo(name = "cargo_capacity")
    val cargo_capacity: String?,

    @ColumnInfo(name = "hyperdrive_rating")
    val hyperdrive_rating: String?
)