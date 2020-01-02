package com.example.starwarslib.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.starwarslib.database.entities.*

@Dao
interface CharactersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<Characters>)

    @Query("SELECT * FROM characters_table")
    fun getEntities(): LiveData<List<Characters>>
}
@Dao
interface PlanetsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<Planets>)

    @Query("SELECT * FROM planets_table")
    fun getEntities(): LiveData<List<Planets>>
}
@Dao
interface StarshipsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<Starships>)

    @Query("SELECT * FROM starships_table")
    fun getEntities(): LiveData<List<Starships>>
}
@Dao
interface VehiclesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<Vehicles>)

    @Query("SELECT * FROM vehicles_table")
    fun getEntities(): LiveData<List<Vehicles>>
}
@Dao
interface SpeciesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<Species>)

    @Query("SELECT * FROM species_table")
    fun getEntities(): LiveData<List<Species>>
}
@Dao
interface FilmsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<Films>)

    @Query("SELECT * FROM films_table")
    fun getEntities(): LiveData<List<Films>>
}