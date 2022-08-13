package com.example.mindvalleycodingchallenge.ui.main.model

import com.example.mindvalleycodingchallenge.ui.main.pojofile.CategoriesResponse
import com.example.mindvalleycodingchallenge.ui.main.pojofile.ChannelsResponse
import com.example.mindvalleycodingchallenge.ui.main.pojofile.NewEpisodesResponse
import io.reactivex.rxjava3.core.Single

class MainRepository(
    private val remote: MainDataContract.Remote
) : MainDataContract.Repository {
    override fun getCategoriesApi(): Single<CategoriesResponse> {
        return remote.getCategoriesApi()
    }

    override fun getChannelsApi(): Single<ChannelsResponse> {
        return remote.getChannelsApi()
    }

    override fun getNewEpisodesApi(): Single<NewEpisodesResponse> {
        return remote.getNewEpisodesApi()
    }

}