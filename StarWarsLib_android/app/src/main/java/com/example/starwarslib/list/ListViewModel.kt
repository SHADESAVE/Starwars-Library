package com.example.starwarslib.list

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import androidx.lifecycle.*
import com.example.starwarslib.database.StarWarsItem
import com.example.starwarslib.database.getDatabase
import com.example.starwarslib.network.*
import com.example.starwarslib.repository.EntitiesRepository
import kotlinx.coroutines.*


enum class StarWarsApiStatus {LOADING, ERROR, DONE}

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val _status = MutableLiveData<StarWarsApiStatus>()
    val status: LiveData<StarWarsApiStatus>
        get() = _status

    private val _navigateToSelectedEntity = MutableLiveData<StarWarsItem>()
    val navigateToSelectedStarWarsEntity: LiveData<StarWarsItem>
        get() = _navigateToSelectedEntity

    fun displayEntityDetails(starWarsEntityProperties: StarWarsItem) {
        _navigateToSelectedEntity.value = starWarsEntityProperties
    }

    fun displayEntityComplete() {
        _navigateToSelectedEntity.value = null
    }

    fun updateFilter(filter: StarWarsApiFilter) {
        getEntityProperties(filter.value, getApplication())
    }


    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private val database = getDatabase(application)
    private val entitiesRepository = EntitiesRepository(database)

    init {
        getEntityProperties("people", application)
    }

    private fun getEntityProperties(filterValue: String, application: Application) {
        val cm = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnected == true
        viewModelScope.launch {
            if (isConnected) {
                try {
                    _status.value = StarWarsApiStatus.LOADING
                    entitiesRepository.refreshData(filterValue)
                    _status.value = StarWarsApiStatus.DONE
                } catch (t: Throwable) {
                    Toast.makeText(getApplication(), "Error connection to server", Toast.LENGTH_SHORT).show()
                    _status.value = StarWarsApiStatus.ERROR
                } finally {
                    setProperties(filterValue)
                }
            } else {
                Toast.makeText(getApplication(), "Offline version", Toast.LENGTH_SHORT).show()
                setProperties(filterValue)
            }
        }
    }

    private val filterInput = MutableLiveData<String>()
    val properties: LiveData<List<StarWarsItem>> = Transformations.switchMap(filterInput) {
            filterValue -> entitiesRepository.getEntitiesList(filterValue) }
    private fun setProperties(filterValue: String) {
        filterInput.postValue(filterValue)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ListViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}

