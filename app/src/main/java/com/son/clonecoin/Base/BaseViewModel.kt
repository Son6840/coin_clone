package com.son.clonecoin.Base

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel(): ViewModel(){
    abstract val TAG: String

    val compositeDisposable by lazy { CompositeDisposable() }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
        Log.e(TAG,"good")
    }

}