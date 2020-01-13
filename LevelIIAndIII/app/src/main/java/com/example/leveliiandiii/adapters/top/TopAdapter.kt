package com.example.leveliiandiii.adapters.top

import android.annotation.SuppressLint
import android.app.Activity
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.leveliiandiii.R
import com.example.leveliiandiii.adapters.top.dagger.DaggerTopAdapterComponent
import com.example.leveliiandiii.adapters.top.dagger.TopAdapterModule
import com.example.leveliiandiii.adapters.top.mvp.TopAdapterPresenter
import com.example.leveliiandiii.adapters.top.mvp.TopViewHolder
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import com.example.leveliiandiii.entities.TrackX
import com.example.leveliiandiii.entities.TrackXDB
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_tracks.view.*
import javax.inject.Inject

class TopAdapter(val activity: Activity, val items: List<TrackXDB>) :
    RecyclerView.Adapter<TopViewHolder>() {

    @Inject
    lateinit var presenter: TopAdapterPresenter
    @Inject
    lateinit var view: TopViewHolder


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
        DaggerTopAdapterComponent.builder()
            .appComponent(LevelIIAndIIIApplication[activity].component())
            .topAdapterModule(TopAdapterModule(activity, parent, items))
            .build()
            .inject(this)
        presenter.onCreate()
        return view
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
        holder.itemView.txtNombre.text = items[position].name
        holder.itemView.txtPosition.text =
            "${activity.getString(R.string.numeral)} ${items[position].attr?.rank?.toInt()?.plus(1)}"
        holder.itemView.txtArtista.text = items[position].artist?.name
        val text = items[position].image?.first { dat -> dat.size == "medium" }?.text
        cargarImagen(holder.itemView.imgLogo, text)
    }

    private fun cargarImagen(imageView: ImageView, url: String?) {
        Picasso.get().load(url)
            .into(imageView)

    }

    override fun getItemCount(): Int {
        return items.size
    }

}