package com.example.mindvalleycodingchallenge.comon.application

import android.app.Application
import com.example.mindvalleycodingchallenge.comon.network.MyApi
import com.example.mindvalleycodingchallenge.comon.network.NetworkConnectionInterceptor
import com.example.mindvalleycodingchallenge.ui.main.model.MainRemoteData
import com.example.mindvalleycodingchallenge.ui.main.model.MainRepository
import com.example.mindvalleycodingchallenge.ui.main.viewmodel.MainViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MainApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MainApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { MainRemoteData(instance()) }
        bind() from singleton { MainRepository(instance()) }
        bind() from singleton { MainViewModel(instance()) }
    }
}