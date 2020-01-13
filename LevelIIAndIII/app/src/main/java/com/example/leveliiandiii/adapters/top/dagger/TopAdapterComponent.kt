package com.example.leveliiandiii.adapters.top.dagger

import com.example.leveliiandiii.adapters.top.TopAdapter
import com.example.leveliiandiii.app.dagger.AppComponent
import dagger.Component

@TopAdapterScope
@Component(modules = arrayOf(TopAdapterModule::class), dependencies = [(AppComponent::class)])
interface TopAdapterComponent {
    fun inject(topAdapter: TopAdapter)
}