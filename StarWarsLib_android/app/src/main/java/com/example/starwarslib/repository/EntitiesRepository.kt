package com.example.starwarslib.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.starwarslib.*
import com.example.starwarslib.database.*
import com.example.starwarslib.network.*
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EntitiesRepository (private val database: EntityDatabase) {

    fun getEntitiesList(filterValue: String): LiveData<List<StarWarsItem>> {
        return when (filterValue) {
            "planets" -> Transformations.map(database.planetsDao.getEntities()) { it.asStarWarsItemPlanets() }
            "starships" -> Transformations.map(database.starshipsDao.getEntities()) { it.asStarWarsItemStarships() }
            "vehicles" -> Transformations.map(database.vehiclesDao.getEntities()) { it.asStarWarsItemVehicles() }
            "species" -> Transformations.map(database.speciesDao.getEntities()) { it.asStarWarsItemSpecies() }
            "films" -> Transformations.map(database.filmsDao.getEntities()) { it.asStarWarsItemFilms() }
            else -> Transformations.map(database.charactersDao.getEntities()) { it.asStarWarsItemCharacters() }
        }
    }

    suspend fun refreshData(filterValue: String) {
        withContext(Dispatchers.IO) {
            val listResult = getRequest(filterValue, 1).await()
            val entitiesList =
                getFromAllPages(listResult.results as MutableList, filterValue, listResult.count / 10)
            when (filterValue) {
                "planets" -> database.planetsDao.insertAll(mapToPlanetsList(entitiesList))
                "starships" -> database.starshipsDao.insertAll(mapToStarshipsList(entitiesList))
                "vehicles" -> database.vehiclesDao.insertAll(mapToVehiclesList(entitiesList))
                "species" -> database.speciesDao.insertAll(mapToSpeciesList(entitiesList))
                "films" -> database.filmsDao.insertAll(mapToFilmsList(entitiesList))
                else -> database.charactersDao.insertAll(mapToCharactersList(entitiesList))
            }
        }
    }

    private fun getRequest(filterValue: String, page: Int) : Deferred<EntitiesList> {
        return when (filterValue) {
            "planets" -> StarWarsApi.retrofitService.getAllPlanets(page)
            "starships" -> StarWarsApi.retrofitService.getAllStarships(page)
            "vehicles" -> StarWarsApi.retrofitService.getAllVehicles(page)
            "species" -> StarWarsApi.retrofitService.getAllSpecies(page)
            "films" -> StarWarsApi.retrofitService.getAllFilms(page)
            else -> StarWarsApi.retrofitService.getAllPeoples(page)
        }
    }

    private suspend fun getFromAllPages(entitiesList: MutableList<StarWarsEntity>, filterValue: String, k: Int = 0): MutableList<StarWarsEntity> {
        if (entitiesList.isNotEmpty()) {
            if (k > 1) {
                for (i in 2..k) {
                    val result = getRequest(filterValue, i).await()
                    entitiesList.addAll(result.results)
                }
            }
        }
        return entitiesList
    }
}