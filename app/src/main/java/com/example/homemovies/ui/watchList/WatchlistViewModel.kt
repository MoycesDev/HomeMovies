package com.example.homemovies.ui.watchList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WatchlistViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Watch List Fragment"
    }
    val text: LiveData<String> = _text
}