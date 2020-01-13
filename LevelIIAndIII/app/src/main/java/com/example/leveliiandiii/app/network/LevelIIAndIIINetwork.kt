package com.example.leveliiandiii.app.network

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * interface que contiene las peticiones hacia el
 * servidor el cual retorna
 * el datos puro o una clase POJO GSON
 */
interface LevelIIAndIIINetwork {

    @GET("2.0/")
    fun sendTopTracks(
        @Query("api_key") api_key: String,
        @Query("page ") page: String = "1",
        @Query("format") format: String = "json",
        @Query("country") country: String = "spain",
        @Query("method") method: String = "geo.gettoptracks"
    ): Observable<JsonObject>

    @GET("2.0/")
    fun sendTopArtists(
        @Query("api_key") api_key: String,
        @Query("page ") page: String = "1",
        @Query("format") format: String = "json",
        @Query("country") country: String = "spain",
        @Query("method") method: String = "geo.gettopartists"
    ): Observable<JsonObject>

}












