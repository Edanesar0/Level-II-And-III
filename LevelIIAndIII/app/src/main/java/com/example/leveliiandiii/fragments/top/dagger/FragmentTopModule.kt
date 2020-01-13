package com.example.leveliiandiii.fragments.top.dagger

import android.app.Activity
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import com.example.leveliiandiii.fragments.top.mvp.FragmentTopModel
import com.example.leveliiandiii.fragments.top.mvp.FragmentTopPresenter
import com.example.leveliiandiii.fragments.top.mvp.FragmentTopView
import dagger.Module
import dagger.Provides

@Module
class FragmentTopModule(private val activity: Activity) {


    @Provides
    @FragmentTopScope
    fun view(): FragmentTopView {
        return FragmentTopView(activity)
    }

    @Provides
    @FragmentTopScope
    fun model(network: LevelIIAndIIINetwork): FragmentTopModel {
        return FragmentTopModel(network)
    }

    @Provides
    @FragmentTopScope
    fun presenter(view: FragmentTopView, model: FragmentTopModel): FragmentTopPresenter {
        return FragmentTopPresenter(view, model)
    }

}
