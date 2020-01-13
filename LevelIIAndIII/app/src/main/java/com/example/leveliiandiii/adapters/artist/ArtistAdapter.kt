package com.example.leveliiandiii.adapters.artist

import android.annotation.SuppressLint
import android.app.Activity
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.leveliiandiii.adapters.artist.dagger.ArtistAdapterModule
import com.example.leveliiandiii.adapters.artist.dagger.DaggerArtistAdapterComponent
import com.example.leveliiandiii.adapters.artist.mvp.ArtistAdapterPresenter
import com.example.leveliiandiii.adapters.artist.mvp.ArtistViewHolder
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import com.example.leveliiandiii.entities.ArtistXDB
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_tracks.view.*
import javax.inject.Inject

class ArtistAdapter(val activity: Activity, val items: List<ArtistXDB>) :
    RecyclerView.Adapter<ArtistViewHolder>() {

    @Inject
    lateinit var presenter: ArtistAdapterPresenter
    @Inject
    lateinit var view: ArtistViewHolder


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        DaggerArtistAdapterComponent.builder()
            .appComponent(LevelIIAndIIIApplication[activity].component())
            .artistAdapterModule(ArtistAdapterModule(activity, parent, items))
            .build()
            .inject(this)
        presenter.onCreate()
        return view
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.itemView.txtNombre.text = items[position].name
        val text = items[position].image.first { dat -> dat.size == "medium" }.text
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