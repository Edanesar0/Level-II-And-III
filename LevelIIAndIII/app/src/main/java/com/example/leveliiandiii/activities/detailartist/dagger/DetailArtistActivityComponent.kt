package com.example.leveliiandiii.activities.detailartist.dagger


import com.example.leveliiandiii.activities.detailartist.DetailArtistActivity
import com.example.leveliiandiii.app.dagger.AppComponent
import dagger.Component

@DetailArtistActivityScope
@Component(modules = [DetailArtistActivityModule::class], dependencies = [(AppComponent::class)])
interface DetailArtistActivityComponent {
    fun inject(detailArtistActivity: DetailArtistActivity)

}
