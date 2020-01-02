package com.example.starwarslib.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.starwarslib.database.entities.*

@Database(entities = [Characters::class, Planets::class, Starships::class, Vehicles::class, Species::class, Films::class], version = 7, exportSchema = false)
abstract class EntityDatabase : RoomDatabase() {
    abstract val charactersDao: CharactersDao
    abstract val planetsDao: PlanetsDao
    abstract val starshipsDao: StarshipsDao
    abstract val vehiclesDao: VehiclesDao
    abstract val speciesDao: SpeciesDao
    abstract val filmsDao: FilmsDao
}
private lateinit var INSTANSE: EntityDatabase

fun getDatabase(context: Context): EntityDatabase {
    if (!::INSTANSE.isInitialized) {
        INSTANSE = Room.databaseBuilder(context.applicationContext, EntityDatabase::class.java, "entities")
            .fallbackToDestructiveMigration()
            .build()
    }
    return INSTANSE
}