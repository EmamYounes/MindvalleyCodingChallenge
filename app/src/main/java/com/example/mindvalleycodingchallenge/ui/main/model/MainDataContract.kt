package com.example.mindvalleycodingchallenge.ui.main.model

import com.example.mindvalleycodingchallenge.ui.main.pojofile.CategoriesResponse
import com.example.mindvalleycodingchallenge.ui.main.pojofile.ChannelsResponse
import com.example.mindvalleycodingchallenge.ui.main.pojofile.NewEpisodesResponse
import io.reactivex.rxjava3.core.Single

interface MainDataContract {

    interface Repository {
        fun getCategoriesApi(): Single<CategoriesResponse>
        fun getChannelsApi(): Single<ChannelsResponse>
        fun getNewEpisodesApi(): Single<NewEpisodesResponse>
    }

    interface Remote {
        fun getCategoriesApi(): Single<CategoriesResponse>
        fun getChannelsApi(): Single<ChannelsResponse>
        fun getNewEpisodesApi(): Single<NewEpisodesResponse>
    }
}