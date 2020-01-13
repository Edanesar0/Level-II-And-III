package com.example.leveliiandiii.activities.splash.dagger

import com.example.leveliiandiii.activities.splash.SplashActivity
import com.example.leveliiandiii.app.dagger.AppComponent
import dagger.Component

@SplashActivityScope
@Component(modules = arrayOf(SplashActivityModule::class), dependencies = [(AppComponent::class)])
interface SplashActivityComponent {
    fun inject(splashActivity: SplashActivity)

}
