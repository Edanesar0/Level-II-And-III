package com.example.leveliiandiii.activities.detail.dagger

import android.app.Activity
import com.example.leveliiandiii.activities.detail.mvp.DetailModel
import com.example.leveliiandiii.activities.detail.mvp.DetailPresenter
import com.example.leveliiandiii.activities.detail.mvp.DetailView

import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule(private val activity: Activity) {
    @Provides
    @DetailActivityScope
    fun view(): DetailView {
        return DetailView(activity)
    }

    @Provides
    @DetailActivityScope
    fun model(network: LevelIIAndIIINetwork): DetailModel {
        return DetailModel(network)
    }

    @Provides
    @DetailActivityScope
    fun presenter(view: DetailView, model: DetailModel): DetailPresenter {
        return DetailPresenter(view, model)
    }
}