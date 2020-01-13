package com.example.leveliiandiii.adapters.artist.dagger

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leveliiandiii.R
import com.example.leveliiandiii.adapters.artist.mvp.ArtistAdapterModel
import com.example.leveliiandiii.adapters.artist.mvp.ArtistAdapterPresenter
import com.example.leveliiandiii.adapters.artist.mvp.ArtistViewHolder
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import com.example.leveliiandiii.entities.ArtistX
import com.example.leveliiandiii.entities.ArtistXDB
import dagger.Module
import dagger.Provides

@Module
class ArtistAdapterModule(
    val activity: Activity,
    val recyclerView: ViewGroup,
    val items: List<ArtistXDB>
) {

    @Provides
    @ArtistAdapterScope
    fun view(): View {
        return LayoutInflater.from(activity).inflate(R.layout.card_artist, recyclerView, false)

    }

    @Provides
    @ArtistAdapterScope
    fun artistHolder(view: View): ArtistViewHolder {
        return ArtistViewHolder(view, items, activity)
    }

    @Provides
    @ArtistAdapterScope
    fun model(network: LevelIIAndIIINetwork): ArtistAdapterModel {
        return ArtistAdapterModel(network)
    }

    @Provides
    @ArtistAdapterScope
    fun presenter(view: ArtistViewHolder, model: ArtistAdapterModel): ArtistAdapterPresenter {
        return ArtistAdapterPresenter(view, model)
    }
}