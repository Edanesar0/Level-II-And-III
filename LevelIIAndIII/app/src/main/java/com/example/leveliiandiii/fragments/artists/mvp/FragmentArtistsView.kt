package com.example.leveliiandiii.fragments.artists.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leveliiandiii.R
import com.example.leveliiandiii.adapters.artist.ArtistAdapter
import com.example.leveliiandiii.entities.ArtistX
import com.example.leveliiandiii.entities.ArtistXDB
import com.example.leveliiandiii.entities.TrackX
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.main_fragment.view.*
import kotlinx.android.synthetic.main.main_fragment_artist.view.*

@SuppressLint("ViewConstructor")
class FragmentArtistsView(private val activity: Activity) : FrameLayout(activity) {
    init {
        View.inflate(context, R.layout.main_fragment_artist, this)
    }

    fun cargarDatosRecicler(lista: List<ArtistXDB>) {
        val linear = LinearLayoutManager(activity)
        rootView.reciclerArtist.layoutManager = linear
        rootView.reciclerArtist.adapter = ArtistAdapter(activity, lista)
    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }
}