package com.example.leveliiandiii.activities.main


import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.leveliiandiii.R
import com.example.leveliiandiii.activities.main.dagger.DaggerMainActivityComponent
import com.example.leveliiandiii.activities.main.dagger.MainActivityModule
import com.example.leveliiandiii.activities.main.mvp.MainPresenter
import com.example.leveliiandiii.activities.main.mvp.MainView
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var mainView: MainView
    @Inject
    lateinit var mainPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainActivityComponent
            .builder()
            .appComponent(LevelIIAndIIIApplication[this].component())
            .mainActivityModule(MainActivityModule(this))
            .build().inject(this)
        setContentView(mainView)
        setSupportActionBar(toolbar)
        mainPresenter.onCreate()


    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return true
    }
}
