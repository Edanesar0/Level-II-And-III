package com.example.leveliiandiii.activities.main.dagger

import android.app.Activity
import com.example.leveliiandiii.activities.main.mvp.MainModel
import com.example.leveliiandiii.activities.main.mvp.MainPresenter
import com.example.leveliiandiii.activities.main.mvp.MainView
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val activity: Activity) {
    @Provides
    @MainActivityScope
    fun view(): MainView {
        return MainView(activity)
    }

    @Provides
    @MainActivityScope
    fun model(network: LevelIIAndIIINetwork): MainModel {
        return MainModel(network)
    }

    @Provides
    @MainActivityScope
    fun presenter(view: MainView, model: MainModel): MainPresenter {
        return MainPresenter(view, model)
    }
}