package com.example.leveliiandiii.app.dagger.module

import android.content.Context
import com.example.leveliiandiii.app.dagger.AppScope
import com.example.leveliiandiii.app.dagger.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides

/**
 * Modulo encargado de devolver el contexto de la aplicacion
 */
@Module
class ContextModule(context: Context) {

    private val appContext: Context = context.applicationContext

    @Provides
    @AppScope
    @ApplicationContext
    fun context(): Context {
        return appContext
    }

}
