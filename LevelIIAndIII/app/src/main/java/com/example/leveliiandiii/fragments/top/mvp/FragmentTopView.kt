package com.example.leveliiandiii.fragments.top.mvp

//import com.example.leveliiandiii.adapters.top.TopAdapter
import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leveliiandiii.R
import com.example.leveliiandiii.adapters.top.TopAdapter
import com.example.leveliiandiii.entities.TrackX
import com.example.leveliiandiii.entities.TrackXDB
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.main_fragment.view.*

@SuppressLint("ViewConstructor")
class FragmentTopView(private val activity: Activity) : FrameLayout(activity) {
    init {
        View.inflate(context, R.layout.main_fragment, this)
    }

    fun cargarDatosRecicler(lista: List<TrackXDB>) {
        val linear = LinearLayoutManager(activity)
        rootView.recicler.layoutManager = linear
        rootView.recicler.adapter = TopAdapter(activity, lista)
    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }
}