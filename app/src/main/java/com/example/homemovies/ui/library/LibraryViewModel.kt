package com.example.homemovies.ui.library

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LibraryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is my Library Fragment"
    }
    val text: LiveData<String> = _text
}