package com.example.leveliiandiii.activities.main.dagger

import com.example.leveliiandiii.activities.main.MainActivity
import com.example.leveliiandiii.app.dagger.AppComponent
import dagger.Component

@MainActivityScope
@Component(modules = arrayOf(MainActivityModule::class), dependencies = [(AppComponent::class)])
interface MainActivityComponent {
    fun inject(splashActivity: MainActivity)

}
