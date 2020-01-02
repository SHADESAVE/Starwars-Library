package com.example.starwarslib.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

enum class StarWarsApiFilter(val value: String) {
    SHOW_PEOPLES("people"),
    SHOW_PLANETS("planets"),
    SHOW_STARSHIPS("starships"),
    SHOW_VEHICLES("vehicles"),
    SHOW_SPECIES("species"),
    SHOW_FILMS("films")
}
private const val BASE_URL = "https://swapi.co/api/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface StarWarsApiService {

    @GET("people")
    fun getAllPeoples(@Query("page") page: Int): Deferred<EntitiesList>

    @GET("planets")
    fun getAllPlanets(@Query("page") page: Int): Deferred<EntitiesList>

    @GET("starships")
    fun getAllStarships(@Query("page") page: Int): Deferred<EntitiesList>

    @GET("vehicles")
    fun getAllVehicles(@Query("page") page: Int): Deferred<EntitiesList>

    @GET("species")
    fun getAllSpecies(@Query("page") page: Int): Deferred<EntitiesList>

    @GET("films")
    fun getAllFilms(@Query("page") page: Int): Deferred<EntitiesList>
}

object StarWarsApi {
    val retrofitService: StarWarsApiService by lazy {
        retrofit.create(StarWarsApiService::class.java)
    }
}
