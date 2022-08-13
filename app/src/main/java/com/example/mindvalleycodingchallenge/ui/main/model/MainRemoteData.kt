package com.example.mindvalleycodingchallenge.ui.main.model

import com.example.mindvalleycodingchallenge.comon.network.MyApi
import com.example.mindvalleycodingchallenge.ui.main.pojofile.CategoriesResponse
import com.example.mindvalleycodingchallenge.ui.main.pojofile.ChannelsResponse
import com.example.mindvalleycodingchallenge.ui.main.pojofile.NewEpisodesResponse
import io.reactivex.rxjava3.core.Single

class MainRemoteData(private val service: MyApi) :
    MainDataContract.Remote {


    override fun getCategoriesApi(): Single<CategoriesResponse> {
        return service.getCategoriesApi("")
    }

    override fun getChannelsApi(): Single<ChannelsResponse> {
        return service.getChannelsApi("")
    }

    override fun getNewEpisodesApi(): Single<NewEpisodesResponse> {
        return service.getNewEpisodesApi("")
    }
}