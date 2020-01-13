package com.example.leveliiandiii.activities.detailartist.mvp

import android.content.Context
import android.os.AsyncTask
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import com.example.leveliiandiii.entities.ArtistXDB


class DetailArtistModel(private val network: LevelIIAndIIINetwork) {
    fun loadTrack(id: String?, context: Context): ArtistXDB? {
        return ArtistAsyncTask(id).execute().get()
    }
}

class ArtistAsyncTask(val id: String?) : AsyncTask<Void?, Void?, ArtistXDB>() {
    override fun doInBackground(vararg params: Void?): ArtistXDB? {
        return LevelIIAndIIIApplication.database?.artistXDao()?.findByName(id)?.first()
    }
}
