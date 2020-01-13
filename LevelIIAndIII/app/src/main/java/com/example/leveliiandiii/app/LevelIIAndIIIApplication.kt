package com.example.leveliiandiii.app

import android.app.Activity
import android.app.Application
import android.app.Service
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.leveliiandiii.app.dagger.AppComponent
import com.example.leveliiandiii.app.dagger.DaggerAppComponent
import com.example.leveliiandiii.app.dagger.module.AppModule
import com.example.leveliiandiii.app.dagger.module.ContextModule
import com.example.leveliiandiii.app.utils.AppDatabase

/**
 * Clase de configuracion de la apliacion esta es la primera clase que se ejecuta y tiene toda la configuracion incial
 */
class LevelIIAndIIIApplication : Application() {
    private var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .contextModule(ContextModule(this)) // must be injected by dagger look in future.
            .appModule(AppModule(this))
            .build()
        initDataBase()
    }

    private fun initDataBase() {
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database"
        ).build()
    }

    fun component(): AppComponent? {
        return component
    }

    companion object {
        var database: AppDatabase? = null
        operator fun get(activity: Activity): LevelIIAndIIIApplication {
            return activity.application as LevelIIAndIIIApplication
        }

        operator fun get(fragment: Fragment): LevelIIAndIIIApplication {
            return fragment.activity?.application as LevelIIAndIIIApplication
        }

        operator fun get(service: Service): LevelIIAndIIIApplication {
            return service.application as LevelIIAndIIIApplication
        }
    }
}