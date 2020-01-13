package com.example.leveliiandiii.fragments.artists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import com.example.leveliiandiii.fragments.artists.dagger.DaggerFragmentArtistsComponent
import com.example.leveliiandiii.fragments.artists.dagger.FragmentArtistsModule
import com.example.leveliiandiii.fragments.artists.mvp.FragmentArtistsPresenter
import com.example.leveliiandiii.fragments.artists.mvp.FragmentArtistsView
import javax.inject.Inject

class FragmentArtists : Fragment() {

    @Inject
    lateinit var artistsView: FragmentArtistsView
    @Inject
    lateinit var artistsPresenter: FragmentArtistsPresenter

    companion object {
        fun newInstance() =
            FragmentArtists()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerFragmentArtistsComponent
            .builder()
            .fragmentArtistsModule(FragmentArtistsModule(activity!!))
            .appComponent(LevelIIAndIIIApplication[activity!!].component())
            .build().inject(this)
        artistsPresenter.onCreate()
        return artistsView
    }

    override fun onDestroy() {
        artistsPresenter.onDestroy()
        super.onDestroy()
    }
}