package com.example.mindvalleycodingchallenge.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mindvalleycodingchallenge.ui.main.model.MainRepository
import com.example.mindvalleycodingchallenge.ui.main.pojofile.CategoriesResponse
import com.example.mindvalleycodingchallenge.ui.main.pojofile.ChannelsResponse
import com.example.mindvalleycodingchallenge.ui.main.pojofile.NewEpisodesResponse
import com.jakewharton.rxrelay3.BehaviorRelay

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    var errorGetCategoriesApi = BehaviorRelay.create<String>()
    var successGetCategoriesApi = BehaviorRelay.create<CategoriesResponse>()


    var errorGetChannelsApi = BehaviorRelay.create<String>()
    var successGetChannelsApi = BehaviorRelay.create<ChannelsResponse>()

    var errorGetNewEpisodesApi = BehaviorRelay.create<String>()
    var successGetNewEpisodesApi = BehaviorRelay.create<NewEpisodesResponse>()


    fun getCoffeeItApi() {
        mainRepository.getCategoriesApi()
            .doOnError { errorGetCategoriesApi.accept(it.message!!.toString()) }
            .subscribe({
                it.let { response ->
                    successGetCategoriesApi.accept(response)
                }
            }, { throwable ->
                errorGetCategoriesApi.accept(throwable.message!!.toString())
            })
    }

    fun getChannelsApi() {
        mainRepository.getChannelsApi()
            .doOnError { errorGetChannelsApi.accept(it.message!!.toString()) }
            .subscribe({
                it.let { response ->
                    successGetChannelsApi.accept(response)
                }
            }, { throwable ->
                errorGetChannelsApi.accept(throwable.message!!.toString())
            })
    }

    fun getNewEpisodesApi() {
        mainRepository.getNewEpisodesApi()
            .doOnError { errorGetNewEpisodesApi.accept(it.message!!.toString()) }
            .subscribe({
                it.let { response ->
                    successGetNewEpisodesApi.accept(response)
                }
            }, { throwable ->
                errorGetNewEpisodesApi.accept(throwable.message!!.toString())
            })
    }
}