package com.example.starwarslib.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.starwarslib.database.StarWarsItem

class DetailViewModelFactory(
    private val starWarsEntityProperty: StarWarsItem,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java )) {
            return DetailViewModel(starWarsEntityProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModelClass")
    }

}