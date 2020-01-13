package com.example.leveliiandiii.activities.splash.mvp

import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import com.example.leveliiandiii.R
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import com.example.leveliiandiii.entities.*
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class SplashPresenter(private val view: SplashView, private val model: SplashModel) {
    private val disposable = CompositeDisposable()

    fun onCreate() {
        disposable.add(loadData())
    }

    fun onDestroy() {
        disposable.clear()
    }

    private fun loadData(): Disposable {
        return view.onEnterView()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { getTopTracks() }
    }

    private fun getTopTracks(): Disposable {
        return model.loadTopTracks("829751643419a7128b7ada50de590067", "1")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ top ->
                if (top != null) {
                    TrackAsyncTask(top).execute()
                    disposable.add(getTopArtists())
                } else {
                    Toast.makeText(
                        view.context,
                        view.context.getString(R.string.error_load_top),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }, { throwable ->
                Log.e("observer", throwable.toString())
                disposable.add(getTopArtists())
            }
            )
    }

    private fun getTopArtists(): Disposable {
        return model.loadTopArtists("829751643419a7128b7ada50de590067", "1")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ top ->
                if (top != null) {
                    ArtistAsyncTask(top).execute()
                    view.changeActivity()
                } else {
                    Toast.makeText(
                        view.context,
                        view.context.getString(R.string.error_load_top),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }, { throwable ->
                Log.e("observer", throwable.toString())
                Toast.makeText(view.context, R.string.offline, Toast.LENGTH_LONG).show()
                view.changeActivity()
            }
            )
    }


}

class TrackAsyncTask(var data: JsonObject) : AsyncTask<Void?, Void?, Void>() {
    override fun doInBackground(vararg params: Void?): Void? {
        val json = Gson().fromJson<Track>(data, Track::class.java)
        json.tracks.track.forEach { data ->
            val trackX = Gson().toJson(data, TrackX::class.java)
            LevelIIAndIIIApplication.database?.trackXDao()?.insertAll(
                Gson().fromJson<TrackXDB>(trackX.toString(), TrackXDB::class.java)
            )
        }
        return null
    }
}

class ArtistAsyncTask(var data: JsonObject) : AsyncTask<Void?, Void?, Void>() {
    override fun doInBackground(vararg params: Void?): Void? {
        val json = Gson().fromJson<TopArtists>(data, TopArtists::class.java)
        json.topartists.artist.forEach { data ->
            val artistX = Gson().toJson(data, ArtistX::class.java)
            LevelIIAndIIIApplication.database?.artistXDao()?.insertAll(
                Gson().fromJson<ArtistXDB>(artistX.toString(), ArtistXDB::class.java)
            )
        }
        return null
    }
}

