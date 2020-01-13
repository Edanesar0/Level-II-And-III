package com.example.leveliiandiii.activities.detailartist.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class DetailArtistPresenter(
    private val view: DetailArtistView, private val model: DetailArtistModel
) {
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
            .map { model.loadTrack(view.getIdentificador(), view.context) }
            .subscribe { view.loadData(it) }
    }

}
