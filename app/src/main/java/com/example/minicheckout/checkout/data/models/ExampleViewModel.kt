package com.example.minicheckout.checkout.data.models

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.minicheckout.repository.CheckoutRepository
import com.example.minicheckout.repository.network.data.BoxResponse

class ExampleViewModel @ViewModelInject constructor(
    private val repository: CheckoutRepository) :
    ViewModel() {

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