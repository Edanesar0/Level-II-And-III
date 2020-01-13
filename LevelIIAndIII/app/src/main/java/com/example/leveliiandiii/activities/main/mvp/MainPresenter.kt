package com.example.leveliiandiii.activities.main.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MainPresenter(private val view: MainView, private val model: MainModel) {
    private val disposable = CompositeDisposable()

    fun onCreate() {
        disposable.add(loadData())
    }

    fun onDestroy() {
        disposable.clear()
    }

    fun loadData(): Disposable {
        return view.onEnterView()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { }
    }


}
