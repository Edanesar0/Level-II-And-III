package com.example.leveliiandiii.activities.detailartist.dagger

import android.app.Activity
import com.example.leveliiandiii.activities.detailartist.mvp.DetailArtistModel
import com.example.leveliiandiii.activities.detailartist.mvp.DetailArtistPresenter
import com.example.leveliiandiii.activities.detailartist.mvp.DetailArtistView
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import dagger.Module
import dagger.Provides

@Module
class DetailArtistActivityModule(private val activity: Activity) {
    @Provides
    @DetailArtistActivityScope
    fun view(): DetailArtistView {
        return DetailArtistView(activity)
    }

    @Provides
    @DetailArtistActivityScope
    fun model(network: LevelIIAndIIINetwork): DetailArtistModel {
        return DetailArtistModel(network)
    }

    @Provides
    @DetailArtistActivityScope
    fun presenter(view: DetailArtistView, model: DetailArtistModel): DetailArtistPresenter {
        return DetailArtistPresenter(view, model)
    }
}