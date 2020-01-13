package com.example.leveliiandiii.activities.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.leveliiandiii.activities.detail.dagger.DaggerDetailActivityComponent
import com.example.leveliiandiii.activities.detail.dagger.DetailActivityModule
import com.example.leveliiandiii.activities.detail.mvp.DetailPresenter
import com.example.leveliiandiii.activities.detail.mvp.DetailView
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var detailView: DetailView
    @Inject
    lateinit var detailPresenter: DetailPresenter
    var id: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerDetailActivityComponent
            .builder()
            .appComponent(LevelIIAndIIIApplication[this].component())
            .detailActivityModule(DetailActivityModule(this))
            .build().inject(this)
        setContentView(detailView)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        detailPresenter.onCreate()

    }

    fun getIds(): String? {
        if (intent.extras != null)
            id = intent.getStringExtra("ID")
        return id
    }


    override fun onDestroy() {
        detailPresenter.onDestroy()
        super.onDestroy()
    }
}
