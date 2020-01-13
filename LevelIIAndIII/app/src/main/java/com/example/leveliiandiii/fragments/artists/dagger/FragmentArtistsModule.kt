package com.example.leveliiandiii.fragments.artists.dagger

import android.app.Activity
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import com.example.leveliiandiii.fragments.artists.mvp.FragmentArtistsModel
import com.example.leveliiandiii.fragments.artists.mvp.FragmentArtistsPresenter
import com.example.leveliiandiii.fragments.artists.mvp.FragmentArtistsView
import dagger.Module
import dagger.Provides

@Module
class FragmentArtistsModule(private val activity: Activity) {


    @Provides
    @FragmentArtistsScope
    fun view(): FragmentArtistsView {
        return FragmentArtistsView(activity)
    }

    @Provides
    @FragmentArtistsScope
    fun model(network: LevelIIAndIIINetwork): FragmentArtistsModel {
        return FragmentArtistsModel(network)
    }

    @Provides
    @FragmentArtistsScope
    fun presenter(
        view: FragmentArtistsView,
        model: FragmentArtistsModel
    ): FragmentArtistsPresenter {
        return FragmentArtistsPresenter(view, model)
    }

}
