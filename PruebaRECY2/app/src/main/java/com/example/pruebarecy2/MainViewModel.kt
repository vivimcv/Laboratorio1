package com.example.pruebarecy2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<Restaurante>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<Restaurante>> {
            override fun onResponse(call: Call<List<Restaurante>>, response: Response<List<Restaurante>>) {
                movieList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Restaurante>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}