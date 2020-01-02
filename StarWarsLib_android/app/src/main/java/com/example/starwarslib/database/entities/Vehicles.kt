package com.example.starwarslib.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles_table")
data class Vehicles(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = 0,

    @ColumnInfo(name = "img_src_url")
    var imgSrcUrl: String,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "entity_name")
    var entityName: String?,

    @ColumnInfo(name = "model")
    var model: String?,

    @ColumnInfo(name = "vehicle_class")
    var vehicle_class: String?,

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
    var passengers: String?,

    @ColumnInfo(name = "cargo_capacity")
    var cargo_capacity: String?
)