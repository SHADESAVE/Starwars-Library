package com.example.starwarslib

import com.example.starwarslib.database.entities.*
import com.example.starwarslib.network.StarWarsEntity
import com.example.starwarslib.database.StarWarsItem

fun mapToCharactersList(networkList: List<StarWarsEntity>): List<Characters> {
    return networkList.map {
        Characters(
            id = it.id,
            url = it.url,
            entityName = it.entityName,
            imgSrcUrl = it.imgSrcUrl,
            height = "Height:\n ${it.height}",
            mass = "Mass:\n ${it.mass}",
            hair_color = "Hair color:\n ${it.hair_color}",
            eye_color = "Eye color:\n ${it.eye_color}",
            skin_color = "Skin color:\n ${it.skin_color}",
            gender = "Gender:\n ${it.gender}",
            birth_year = "Birth year:\n ${it.birth_year}"
        )
    }
}
fun mapToPlanetsList(networkList: List<StarWarsEntity>): List<Planets> {
    return networkList.map {
        Planets(
            id = it.id,
            url = it.url,
            entityName = it.entityName,
            imgSrcUrl = it.imgSrcUrl,
            rotation_period = "Rotation period:\n ${it.rotation_period}",
            orbital_period = "Orbital period:\n ${it.orbital_period}",
            diameter = "Diameter:\n ${it.diameter}",
            climate = "Climate:\n ${it.climate}",
            gravity = "Gravity:\n ${it.gravity}",
            terrain = "Terrain:\n ${it.terrain}",
            surface_water = "Surface water:\n ${it.surface_water}",
            population = "Population:\n ${it.population}"
        )
    }
}
fun mapToStarshipsList(networkList: List<StarWarsEntity>): List<Starships> {
    return networkList.map {
        Starships(
            id = it.id,
            url = it.url,
            imgSrcUrl = it.imgSrcUrl,
            entityName = it.entityName,
            model = "Model:\n ${it.model}",
            starship_class = "Starship class:\n ${it.starship_class}",
            manufacturer = "Manufacturer:\n ${it.manufacturer}",
            cost_in_credits = "Cost in credits:\n ${it.cost_in_credits}",
            length = "Length:\n ${it.length}",
            max_atmosphering_speed = "Max atmosphering speed:\n ${it.max_atmosphering_speed}",
            hyperdrive_rating = "Hyperdrive rating:\n ${it.hyperdrive_rating}",
            crew = "Crew:\n ${it.crew}",
            passengers = "Passengers:\n ${it.passengers}",
            cargo_capacity = "Cargo capacity:\n ${it.cargo_capacity}"
        )
    }
}
fun mapToVehiclesList(networkList: List<StarWarsEntity>): List<Vehicles> {
    return networkList.map {
        Vehicles(
            id = it.id,
            url = it.url,
            imgSrcUrl = it.imgSrcUrl,
            entityName = it.entityName,
            model = "Model:\n ${it.model}",
            vehicle_class = "Vehicle class:\n ${it.vehicle_class}",
            manufacturer = "Manufacturer:\n ${it.manufacturer}",
            cost_in_credits = "Cost in credits:\n ${it.cost_in_credits}",
            length = "Length: ${it.length}",
            max_atmosphering_speed = "Max atmosphering speed:\n ${it.max_atmosphering_speed}",
            crew = "Crew:\n ${it.crew}",
            passengers = "Passengers:\n ${it.passengers}",
            cargo_capacity = "Cargo capacity:\n ${it.cargo_capacity}"

        )
    }
}
fun mapToSpeciesList(networkList: List<StarWarsEntity>): List<Species> {
    return networkList.map {
        Species(
            id = it.id,
            url = it.url,
            imgSrcUrl = it.imgSrcUrl,
            entityName = it.entityName,
            classification = "Classification:\n ${it.classification}",
            designation = "Designation:\n ${it.designation}",
            average_height = "Average height:\n ${it.average_height}",
            hair_color = "Hair color:\n ${it.hair_color}",
            eye_color = "Eye color:\n ${it.eye_color}",
            skin_color = "Skin color:\n ${it.skin_color}",
            average_lifespan = "Average lifespan:\n ${it.average_lifespan}",
            language = "Language:\n ${it.language}"
        )
    }
}
fun mapToFilmsList(networkList: List<StarWarsEntity>): List<Films> {
    return networkList.map {
        Films(
            id = it.id,
            url = it.url,
            imgSrcUrl = it.imgSrcUrl,
            entityName = it.entityName,
            opening_crawl = "Opening crawl:\n ${it.opening_crawl}",
            director = "Director:\n ${it.director}",
            producer = "Producer:\n ${it.producer}",
            release_date = "Release date:\n ${it.release_date}"
        )
    }
}

fun List<Characters>.asStarWarsItemCharacters(): List<StarWarsItem> {
    return map {
        StarWarsItem(
            id = it.id,
            imgSrcUrl = it.imgSrcUrl,
            entityName = it.entityName,
            textContainer1 = it.height,
            textContainer2 = it.mass,
            textContainer3 = it.hair_color,
            textContainer4 = it.eye_color,
            textContainer5 = it.skin_color,
            textContainer6 = it.gender,
            textContainer7 = it.birth_year,
            textContainer8 = "",
            textContainer9 = "",
            textContainer10 = ""
        )
    }
}
fun List<Planets>.asStarWarsItemPlanets(): List<StarWarsItem> {
    return map {
        StarWarsItem(
            id = it.id,
            entityName = it.entityName,
            imgSrcUrl = it.imgSrcUrl,
            textContainer1 = it.orbital_period,
            textContainer2 = it.rotation_period,
            textContainer3 = it.diameter,
            textContainer4 = it.climate,
            textContainer5 = it.gravity,
            textContainer6 = it.surface_water,
            textContainer7 = it.population,
            textContainer8 = "",
            textContainer9 = "",
            textContainer10 = ""
        )
    }
}
fun List<Starships>.asStarWarsItemStarships(): List<StarWarsItem> {
    return map {
        StarWarsItem(
            id = it.id,
            entityName = it.entityName,
            imgSrcUrl = it.imgSrcUrl,
            textContainer1 = it.model,
            textContainer2 = it.starship_class,
            textContainer3 = it.manufacturer,
            textContainer4 = it.cost_in_credits,
            textContainer5 = it.length,
            textContainer6 = it.max_atmosphering_speed,
            textContainer7 = it.hyperdrive_rating,
            textContainer8 = it.crew,
            textContainer9 = it.passengers,
            textContainer10 = it.cargo_capacity
        )
    }
}
fun List<Vehicles>.asStarWarsItemVehicles(): List<StarWarsItem> {
    return map {
        StarWarsItem(
            id = it.id,
            entityName = it.entityName,
            imgSrcUrl = it.imgSrcUrl,
            textContainer1 = it.model,
            textContainer2 = it.vehicle_class,
            textContainer3 = it.manufacturer,
            textContainer4 = it.cost_in_credits,
            textContainer5 = it.length,
            textContainer6 = it.max_atmosphering_speed,
            textContainer7 = it.crew,
            textContainer8 = it.passengers,
            textContainer9 = it.cargo_capacity,
            textContainer10 = ""
        )
    }
}
fun List<Species>.asStarWarsItemSpecies(): List<StarWarsItem> {
    return map {
        StarWarsItem(
            id = it.id,
            entityName = it.entityName,
            imgSrcUrl = it.imgSrcUrl,
            textContainer1 = it.classification,
            textContainer2 = it.designation,
            textContainer3 = it.average_height,
            textContainer4 = it.hair_color,
            textContainer5 = it.eye_color,
            textContainer6 = it.skin_color,
            textContainer7 = it.average_lifespan,
            textContainer8 = it.language,
            textContainer9 = "",
            textContainer10 = ""
        )
    }
}
fun List<Films>.asStarWarsItemFilms(): List<StarWarsItem> {
    return map {
        StarWarsItem(
            id = it.id,
            entityName = it.entityName,
            imgSrcUrl = it.imgSrcUrl,
            textContainer1 = it.opening_crawl,
            textContainer2 = it.director,
            textContainer3 = it.producer,
            textContainer4 = it.release_date,
            textContainer5 = "",
            textContainer6 = "",
            textContainer7 = "",
            textContainer8 = "",
            textContainer9 = "",
            textContainer10 = ""
        )
    }
}