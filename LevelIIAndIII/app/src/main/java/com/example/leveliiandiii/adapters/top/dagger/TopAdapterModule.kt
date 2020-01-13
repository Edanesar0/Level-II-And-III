package com.example.leveliiandiii.adapters.top.dagger

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leveliiandiii.R
import com.example.leveliiandiii.adapters.top.mvp.TopAdapterModel
import com.example.leveliiandiii.adapters.top.mvp.TopAdapterPresenter
import com.example.leveliiandiii.adapters.top.mvp.TopViewHolder
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import com.example.leveliiandiii.entities.TrackX
import com.example.leveliiandiii.entities.TrackXDB
import dagger.Module
import dagger.Provides

@Module
class TopAdapterModule(
    val activity: Activity,
    val recyclerView: ViewGroup,
    val items: List<TrackXDB>
) {

    @Provides
    @TopAdapterScope
    fun view(): View {
        return LayoutInflater.from(activity).inflate(R.layout.card_tracks, recyclerView, false)

    }

    @Provides
    @TopAdapterScope
    fun topHolder(view: View): TopViewHolder {
        return TopViewHolder(view, items, activity)
    }

    @Provides
    @TopAdapterScope
    fun model(network: LevelIIAndIIINetwork): TopAdapterModel {
        return TopAdapterModel(network)
    }

    @Provides
    @TopAdapterScope
    fun presenter(view: TopViewHolder, model: TopAdapterModel): TopAdapterPresenter {
        return TopAdapterPresenter(view, model)
    }
}