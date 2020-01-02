package com.example.starwarslib.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.starwarslib.database.StarWarsItem

class DetailViewModel(starWarsItem: StarWarsItem, app: Application): AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<StarWarsItem>()
    val selectedProperty: LiveData<StarWarsItem>
        get() = _selectedProperty
    init {
        _selectedProperty.value = starWarsItem
    }
}