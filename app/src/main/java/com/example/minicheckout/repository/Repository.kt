package com.example.minicheckout.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.minicheckout.repository.network.api.TestAPI
import com.example.minicheckout.repository.network.data.BoxResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

// TODO cache network response locally in a room database
class Repository {
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
        TestAPI.apiService.currentFix()

    private fun onSuccess(boxResponse: BoxResponse) {
        boxResponseDataSet.value = boxResponse
        Log.d("success", "network call success")
    }

    private fun onError(e: Throwable) {
        Log.d("error", "error in  network call")
        Log.d("Error", e.message.toString())
    }

    companion object {
        fun newInstance() = Repository()
    }

    fun clearDisposable() {
        if (!mCompositeDisposable.isDisposed)
            mCompositeDisposable.dispose()
    }
}
