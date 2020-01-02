package com.example.starwarslib.network

data class EntitiesList(
    val count: Int,
//    val next: String?,
//    val previous: String?,
    val results: List<StarWarsEntity>
)