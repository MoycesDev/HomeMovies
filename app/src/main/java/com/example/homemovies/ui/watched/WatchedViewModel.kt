package com.example.homemovies.ui.watched

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WatchedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Watched Fragment"
    }
    val text: LiveData<String> = _text
}