package com.example.leveliiandiii.activities.detailartist.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import com.example.leveliiandiii.R
import com.example.leveliiandiii.activities.detailartist.DetailArtistActivity
import com.example.leveliiandiii.entities.ArtistX
import com.example.leveliiandiii.entities.ArtistXDB
import com.jakewharton.rxbinding2.view.RxView
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_detail_artist.view.*
import kotlinx.android.synthetic.main.content_detail_artista.view.*


@SuppressLint("ViewConstructor")
class DetailArtistView(val activity: Activity) : FrameLayout(activity) {
    init {
        View.inflate(context, R.layout.activity_detail_artist, this)

    }

    fun getIdentificador(): String? {
        return (activity as DetailArtistActivity).getIds()
    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }

    @SuppressLint("SetTextI18n")
    fun loadData(data: ArtistXDB?) {
        toolbar_layout.title = data?.name
        txtArtista.text = data?.name
        txtListeners.text = data?.listeners

        val mitextoU = SpannableString(data?.url)
        mitextoU.setSpan(UnderlineSpan(), 0, mitextoU.length, 0)
        txtUrl.text = mitextoU

        txtUrl.setOnClickListener { redirectToUrl(data?.url) }
        val text = data?.image?.first { dat -> dat.size == "extralarge" }?.text
        loadImage(imgBanner, text)
    }

    @Throws(Exception::class)
    fun loadImage(view: ImageView, url: String?) {
        Picasso.get().load(url)
            .into(view)
    }

    private fun redirectToUrl(url: String?) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(url)
        startActivity(context, openURL, null)
    }
}
