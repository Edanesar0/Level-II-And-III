package com.example.leveliiandiii.activities.splash.dagger

import android.app.Activity
import com.example.leveliiandiii.activities.splash.mvp.SplashModel
import com.example.leveliiandiii.activities.splash.mvp.SplashPresenter
import com.example.leveliiandiii.activities.splash.mvp.SplashView
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule(private val activity: Activity) {
    @Provides
    @SplashActivityScope
    fun view(): SplashView {
        return SplashView(activity)
    }

    @Provides
    @SplashActivityScope
    fun model(network: LevelIIAndIIINetwork): SplashModel {
        return SplashModel(network)
    }

    @Provides
    @SplashActivityScope
    fun presenter(view: SplashView, model: SplashModel): SplashPresenter {
        return SplashPresenter(view, model)
    }
}