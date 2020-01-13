package com.example.leveliiandiii.fragments.artists.dagger

import com.example.leveliiandiii.app.dagger.AppComponent
import com.example.leveliiandiii.fragments.artists.FragmentArtists
import dagger.Component

@FragmentArtistsScope
@Component(modules = arrayOf(FragmentArtistsModule::class), dependencies = [(AppComponent::class)])
interface FragmentArtistsComponent {
    fun inject(fragmentArtists: FragmentArtists)
}
