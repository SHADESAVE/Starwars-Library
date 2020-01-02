package com.example.starwarslib.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films_table")
data class Films(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = 0,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "img_src_url")
    var imgSrcUrl: String,

    @ColumnInfo(name = "entity_name")
    var entityName: String?,

    @ColumnInfo(name = "opening_crawl")
    var opening_crawl: String?,

    @ColumnInfo(name = "director")
    var director: String?,

    @ColumnInfo(name = "producer")
    var producer: String?,

    @ColumnInfo(name = "release_date")
    var release_date: String?
)