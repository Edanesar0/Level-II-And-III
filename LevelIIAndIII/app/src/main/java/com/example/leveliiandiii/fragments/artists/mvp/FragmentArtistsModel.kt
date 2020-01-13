package com.example.leveliiandiii.fragments.artists.mvp

import android.content.Context
import android.os.AsyncTask
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import com.example.leveliiandiii.entities.ArtistXDB


class FragmentArtistsModel(private val network: LevelIIAndIIINetwork) {

    fun loadData(context: Context): List<ArtistXDB> {
        return ArtistAsyncTask().execute().get()
    }
}

class ArtistAsyncTask : AsyncTask<Void?, Void?, List<ArtistXDB>>() {
    override fun doInBackground(vararg params: Void?): List<ArtistXDB>? {
        return LevelIIAndIIIApplication.database?.artistXDao()?.getAll()
    }
}

