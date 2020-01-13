package com.example.leveliiandiii.activities.detail.mvp

import android.content.Context
import android.os.AsyncTask
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import com.example.leveliiandiii.entities.TrackXDB


class DetailModel(private val network: LevelIIAndIIINetwork) {
    fun loadTrack(id: String?, context: Context): TrackXDB? {
        return TrackAsyncTask(id).execute().get()
    }
}

class TrackAsyncTask(val id: String?) : AsyncTask<Void?, Void?, TrackXDB>() {
    override fun doInBackground(vararg params: Void?): TrackXDB? {
        return LevelIIAndIIIApplication.database?.trackXDao()?.findByName(id)?.first()
    }
}