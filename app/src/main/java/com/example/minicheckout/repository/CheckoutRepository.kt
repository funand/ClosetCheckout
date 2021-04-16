package com.example.minicheckout.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.minicheckout.repository.network.api.APIService
import com.example.minicheckout.repository.network.data.BoxResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CheckoutRepository @Inject constructor(
    private val apiService: APIService
) : Repository {
    private val mCompositeDisposable = CompositeDisposable()
    private val boxResponseDataSet = MutableLiveData<BoxResponse>()

    fun getBoxResponse(): LiveData<BoxResponse> {
        getBoxResponseFromNetwork()
        return boxResponseDataSet
    }

    private fun getBoxResponseFromNetwork() {
        Log.d("make call", "make call")

        mCompositeDisposable.add(
            boxResponseObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError)
        )
    }

    private fun boxResponseObservable(): Single<BoxResponse> =
        apiService.getCurrentFix()

    private fun onSuccess(boxResponse: BoxResponse) {
        boxResponseDataSet.value = boxResponse
        Log.d("success", "network call success")
    }

    private fun onError(e: Throwable) {
        Log.d("error", "error in  network call")
        Log.d("Error", e.message.toString())
    }

    fun clearDisposable() {
        if (!mCompositeDisposable.isDisposed)
            mCompositeDisposable.dispose()
    }
}
