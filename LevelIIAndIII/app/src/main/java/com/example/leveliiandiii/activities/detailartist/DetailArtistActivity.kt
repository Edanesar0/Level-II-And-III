package com.example.leveliiandiii.activities.detailartist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.leveliiandiii.activities.detailartist.dagger.DaggerDetailArtistActivityComponent
import com.example.leveliiandiii.activities.detailartist.dagger.DetailArtistActivityModule
import com.example.leveliiandiii.activities.detailartist.mvp.DetailArtistPresenter
import com.example.leveliiandiii.activities.detailartist.mvp.DetailArtistView
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var detailView: DetailArtistView
    @Inject
    lateinit var detailPresenter: DetailArtistPresenter
    var id: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerDetailArtistActivityComponent
            .builder()
            .appComponent(LevelIIAndIIIApplication[this].component())
            .detailArtistActivityModule(DetailArtistActivityModule(this))
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
