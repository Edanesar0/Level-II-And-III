package com.example.leveliiandiii.fragments.top.mvp

import android.content.Context
import android.os.AsyncTask
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import com.example.leveliiandiii.entities.TrackXDB


class FragmentTopModel(private val network: LevelIIAndIIINetwork) {

    fun loadData(context: Context): List<TrackXDB> {
        return TrackAsyncTask().execute().get()
    }
}

class TrackAsyncTask : AsyncTask<Void?, Void?, List<TrackXDB>>() {
    override fun doInBackground(vararg params: Void?): List<TrackXDB>? {
        return LevelIIAndIIIApplication.database?.trackXDao()?.getAll()
    }
}