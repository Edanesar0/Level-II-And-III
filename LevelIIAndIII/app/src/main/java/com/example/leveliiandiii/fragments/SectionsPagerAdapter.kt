package com.example.leveliiandiii.fragments


import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.leveliiandiii.fragments.artists.FragmentArtists
import com.example.leveliiandiii.fragments.top.FragmentTop


class SectionsPagerAdapter(fm: FragmentManager, val activity: Activity) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return FragmentArtists().apply {
                    arguments = Bundle().apply {
                    }
                }
            }
            1 -> {
                return FragmentTop().apply {
                    arguments = Bundle().apply {
                    }
                }
            }

        }
        return Fragment()
    }

    override fun getCount(): Int {
        return 2
    }
}