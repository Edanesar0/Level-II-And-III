package com.example.leveliiandiii.fragments.top.dagger

import com.example.leveliiandiii.app.dagger.AppComponent
import com.example.leveliiandiii.fragments.top.FragmentTop
import dagger.Component

@FragmentTopScope
@Component(modules = arrayOf(FragmentTopModule::class), dependencies = [(AppComponent::class)])
interface FragmentTopComponent {
    fun inject(fragmentTop: FragmentTop)
}
