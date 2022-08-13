package com.example.mindvalleycodingchallenge.comon.network

import com.example.mindvalleycodingchallenge.ui.main.pojofile.CategoriesResponse
import com.example.mindvalleycodingchallenge.ui.main.pojofile.ChannelsResponse
import com.example.mindvalleycodingchallenge.ui.main.pojofile.NewEpisodesResponse
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface MyApi {


    @GET
    fun getCategoriesApi(
        @Url url: String
    ): Single<CategoriesResponse>


    @GET
    fun getChannelsApi(
        @Url url: String
    ): Single<ChannelsResponse>


    @GET
    fun getNewEpisodesApi(
        @Url url: String
    ): Single<NewEpisodesResponse>


    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): MyApi {

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }

}

