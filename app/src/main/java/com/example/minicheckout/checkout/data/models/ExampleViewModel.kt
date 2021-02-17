package com.example.minicheckout.checkout.data.models

import androidx.hilt.lifecycle.HiltViewModelFactory
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.minicheckout.repository.Repository
import com.example.minicheckout.repository.network.data.BoxResponse
import javax.inject.Inject

class ExampleViewModel @ViewModelInject constructor() : ViewModel() {

    @Inject
    lateinit var repository: Repository

    private var boxResponseLiveData = MutableLiveData<BoxResponse>()

    fun getBoxResponse(): LiveData<BoxResponse> {
        boxResponseLiveData = repository.getBoxResponse() as MutableLiveData<BoxResponse>
        return boxResponseLiveData
    }

    override fun onCleared() {
        super.onCleared()
        repository.clearDisposable()
    }
}