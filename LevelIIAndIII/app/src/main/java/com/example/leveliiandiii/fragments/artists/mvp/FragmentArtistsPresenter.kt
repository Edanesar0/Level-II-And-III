package com.example.leveliiandiii.fragments.artists.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class FragmentArtistsPresenter(val view: FragmentArtistsView, val model: FragmentArtistsModel) {
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
            .map { model.loadData(view.context) }
            .subscribe { view.cargarDatosRecicler(it) }

    }

}