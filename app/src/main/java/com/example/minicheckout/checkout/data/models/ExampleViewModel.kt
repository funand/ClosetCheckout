package com.example.minicheckout.checkout.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.minicheckout.repository.Repository
import com.example.minicheckout.repository.network.data.BoxResponse

class ExampleViewModel : ViewModel() {

    private var boxResponseLiveData = MutableLiveData<BoxResponse>()
    private val repository = Repository.newInstance()

    fun getBoxResponse(): LiveData<BoxResponse> {
        boxResponseLiveData = repository.getBoxResponse() as MutableLiveData<BoxResponse>
        return boxResponseLiveData
    }

    override fun onCleared() {
        super.onCleared()
        repository.clearDisposable()
    }
}