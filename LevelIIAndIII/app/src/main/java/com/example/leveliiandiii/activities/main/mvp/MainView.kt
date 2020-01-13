package com.example.leveliiandiii.activities.main.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.FrameLayout
import com.example.leveliiandiii.R
import com.example.leveliiandiii.activities.main.MainActivity
import com.example.leveliiandiii.fragments.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.main_activity.view.*


@SuppressLint("ViewConstructor")
class MainView(activity: Activity) : FrameLayout(activity) {

    init {
        View.inflate(context, R.layout.main_activity, this)
        container.adapter =
            SectionsPagerAdapter((activity as MainActivity).supportFragmentManager, activity)
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }

}
