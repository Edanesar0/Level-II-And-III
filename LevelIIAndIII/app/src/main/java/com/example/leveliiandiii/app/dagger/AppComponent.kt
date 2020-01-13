package com.example.leveliiandiii.app.dagger

import android.content.Context
import com.example.leveliiandiii.app.dagger.module.AppModule
import com.example.leveliiandiii.app.dagger.module.ContextModule
import com.example.leveliiandiii.app.dagger.module.GsonModule
import com.example.leveliiandiii.app.dagger.module.NetworkModule
import com.example.leveliiandiii.app.network.LevelIIAndIIINetwork
import dagger.Component

/**
 * interface que contiene las dependencia que se van a inyectar en la apicacclion
 * igual que lo metodos que se van a inyectar
 */
@AppScope
@Component(
    modules = [AppModule::class, ContextModule::class, NetworkModule::class, GsonModule::class]
)
interface AppComponent {
    fun context(): Context
    fun network(): LevelIIAndIIINetwork
}
