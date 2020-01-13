package com.example.leveliiandiii.activities.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.leveliiandiii.activities.splash.dagger.DaggerSplashActivityComponent
import com.example.leveliiandiii.activities.splash.dagger.SplashActivityModule
import com.example.leveliiandiii.activities.splash.mvp.SplashPresenter
import com.example.leveliiandiii.activities.splash.mvp.SplashView
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var splashView: SplashView
    @Inject
    lateinit var splashPresenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSplashActivityComponent
            .builder()
            .appComponent(LevelIIAndIIIApplication[this].component())
            .splashActivityModule(SplashActivityModule(this))
            .build().inject(this)
        setContentView(splashView)
        splashPresenter.onCreate()

    }

    override fun onDestroy() {
        super.onDestroy()
        splashPresenter.onDestroy()
    }
}
