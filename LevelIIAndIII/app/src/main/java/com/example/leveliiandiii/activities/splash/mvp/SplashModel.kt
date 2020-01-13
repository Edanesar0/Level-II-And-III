package com.example.leveliiandiii.activities.splash.mvp

import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import com.google.gson.JsonObject
import io.reactivex.Observable


class SplashModel(private val network: LevelIIAndIIINetwork) {


    fun loadTopTracks(api_key: String, page: String): Observable<JsonObject> {
        return network.sendTopTracks(api_key, page)
    }

    fun loadTopArtists(api_key: String, page: String): Observable<JsonObject> {
        return network.sendTopArtists(api_key, page)
    }


}