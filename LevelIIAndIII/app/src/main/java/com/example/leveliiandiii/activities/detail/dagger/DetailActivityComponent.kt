package com.example.leveliiandiii.activities.detail.dagger


import com.example.leveliiandiii.activities.detail.DetailActivity
import com.example.leveliiandiii.app.dagger.AppComponent
import dagger.Component

@DetailActivityScope
@Component(modules = arrayOf(DetailActivityModule::class), dependencies = [(AppComponent::class)])
interface DetailActivityComponent {
    fun inject(detailActivity: DetailActivity)

}
