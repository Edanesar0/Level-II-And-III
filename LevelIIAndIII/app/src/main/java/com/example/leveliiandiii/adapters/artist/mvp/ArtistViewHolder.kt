package com.example.leveliiandiii.adapters.artist.mvp

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.leveliiandiii.activities.detailartist.DetailArtistActivity
import com.example.leveliiandiii.entities.ArtistX
import com.example.leveliiandiii.entities.ArtistXDB
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.card_artist.view.*


class ArtistViewHolder(itemView: View, items: List<ArtistXDB>, val activity: Activity) :
    RecyclerView.ViewHolder(itemView) {

    fun clickDetalle(): Observable<Any> {
        return RxView.clicks(itemView.rootView.cardArtist)

    }

    fun getId(): String {
        return itemView.txtNombre?.text.toString()
    }

    fun changeActivity() {
        val intent = Intent(activity, DetailArtistActivity::class.java)
        intent.putExtra("ID", getId())
        activity.startActivity(intent)
    }

}