package com.example.leveliiandiii.adapters.artist.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class ArtistAdapterPresenter(val view: ArtistViewHolder, val model: ArtistAdapterModel) {
    private val disposable = CompositeDisposable()


    fun onCreate() {
        disposable.add(clickDetalles())
    }

    fun clickDetalles(): Disposable {
        return view.clickDetalle().subscribe { view.changeActivity() }
    }

    fun onDestroy() {
        disposable.clear()
    }
}