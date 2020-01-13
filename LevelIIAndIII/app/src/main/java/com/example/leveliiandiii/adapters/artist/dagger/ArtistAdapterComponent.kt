package com.example.leveliiandiii.adapters.artist.dagger

import com.example.leveliiandiii.adapters.artist.ArtistAdapter
import com.example.leveliiandiii.app.dagger.AppComponent
import dagger.Component

@ArtistAdapterScope
@Component(modules = [ArtistAdapterModule::class], dependencies = [(AppComponent::class)])
interface ArtistAdapterComponent {
    fun inject(artistAdapter: ArtistAdapter)
}