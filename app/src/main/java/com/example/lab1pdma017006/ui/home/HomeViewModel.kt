package com.example.lab1pdma017006.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Laboratorio 1 PDM 115 2022"
    }
    val text: LiveData<String> = _text
}