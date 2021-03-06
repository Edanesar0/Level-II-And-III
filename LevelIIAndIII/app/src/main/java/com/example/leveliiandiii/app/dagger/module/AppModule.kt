package com.example.leveliiandiii.app.dagger.module

import android.app.Application
import android.content.Context
import com.example.leveliiandiii.app.LevelIIAndIIIApplication
import com.example.leveliiandiii.app.dagger.AppScope

import dagger.Module
import dagger.Provides

/***
 * Clase encargada de proveer informacion
 * El cual contiene informacion o datos puros que
 * se desee inyectar
 */
@Module
class AppModule(private val application: LevelIIAndIIIApplication) {
    private val context: Context = application.applicationContext

    @Provides
    @AppScope
    fun application(): Application {
        return application
    }

    @AppScope
    @Provides
    fun context(): Context {
        return context
    }

}
