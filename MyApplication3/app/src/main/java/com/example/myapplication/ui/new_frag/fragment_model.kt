package com.example.myapplication.ui.new_frag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class fragment_model: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Contacto:"
    }
    val text: LiveData<String> = _text
}