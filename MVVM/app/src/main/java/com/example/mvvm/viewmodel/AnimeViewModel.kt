package com.example.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.AnimeModel
import com.example.mvvm.model.AnimeProvider

class AnimeViewModel: ViewModel() {

    //agregando  un LiveData

    val animeModel = MutableLiveData<AnimeModel>()//este valor va ir mutando

    val test = MutableLiveData<String>()

    fun updateAnime(){
        val currentAnime = AnimeProvider.getAnime()

//aquí el activity lo recibe con el observador
        animeModel.postValue(currentAnime)
    }
}