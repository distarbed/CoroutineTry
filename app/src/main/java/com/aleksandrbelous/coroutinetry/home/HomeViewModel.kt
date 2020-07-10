package com.aleksandrbelous.coroutinetry.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleksandrbelous.coroutinetry.network.MovieItem
import com.aleksandrbelous.coroutinetry.network.getNetworkService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * @author Aleksandr Belous
 * @since 7/10/20.
 */
class HomeViewModel : ViewModel() {

    companion object {
        private final val API_KEY = "37371dd3"
    }

    private val _result = MutableLiveData<List<MovieItem>>()

    val result: LiveData<List<MovieItem>>
        get() = _result

    fun loadList() {
        viewModelScope.launch {
            try {
                val items = getNetworkService().search(API_KEY, "first")
                _result.value = items.list
            } catch (error: Exception) {
                Log.e("#############     ", error.message)
                _result.value = emptyList()
            }
        }
    }
}