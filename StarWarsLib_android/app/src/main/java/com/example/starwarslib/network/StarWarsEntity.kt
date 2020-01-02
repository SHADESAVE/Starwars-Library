package com.example.starwarslib.network

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StarWarsEntity(

    val url: String,
    val name: String?,

    //Planets
    val rotation_period: String?,
    val orbital_period: String?,
    val diameter: String?,
    val climate: String?,
    val gravity: String?,
    val terrain: String?,
    val surface_water: String?,
    val population: String?,

    //Peoples
    val height: String?,
    val mass: String?,
    val hair_color: String?,
    val skin_color: String?,
    val eye_color: String?,
    val birth_year: String?,
    val gender: String?,
    //Species
    val classification: String?,
    val designation: String?,
    val average_lifespan: String?,
    val average_height: String?,
    val language: String?,

    //Starships
    val model: String?,
    val cost_in_credits: String?,
    val manufacturer: String?,
    val length: String?,
    val max_atmosphering_speed: String?,
    val crew: String?,
    val passengers: String?,
    val cargo_capacity: String?,
    val starship_class: String?,
    val hyperdrive_rating: String?,
    //Vehicles
    val vehicle_class: String?,

    //films
    val title: String?,
    val opening_crawl: String?,
    val director: String?,
    val producer: String?,
    val release_date: String?,

    val entityName: String? = name ?: title,
    val textContainer1: String? = height ?: rotation_period ?: classification ?: model ?: opening_crawl,
    val textContainer2: String? = mass ?: orbital_period ?: designation ?: manufacturer ?: director,
    val textContainer3: String? = hair_color ?: diameter ?: starship_class ?: vehicle_class ?: producer,
    val textContainer4: String? = eye_color ?: climate ?: cost_in_credits ?: release_date,
    val textContainer5: String? = skin_color ?: gravity ?: length,
    val textContainer6: String? = gender ?: average_height ?: terrain ?: max_atmosphering_speed,
    val textContainer7: String? = birth_year ?: average_lifespan ?: surface_water ?: crew,
    val textContainer8: String? = population ?: language ?: passengers,
    val textContainer9: String? = cargo_capacity,
    val textContainer10: String? = hyperdrive_rating,

    //Get id from url
    val id: Int? = Regex("/([0-9]*)/$").find(url)?.groupValues?.get(1)?.toInt(),

    //Get group from url for imgSrcUrl
    val type: String? = Regex("/([a-z]+)/[0-9]*/").find(url)?.groupValues?.get(1).toString(),

    val imgSrcUrl: String =
        if (type == "people")
            "https://starwars-visualguide.com/assets/img/characters/$id.jpg"
        else
            "https://starwars-visualguide.com/assets/img/$type/$id.jpg"
): Parcelable {
}

