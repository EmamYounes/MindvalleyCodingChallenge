package com.example.mindvalleycodingchallenge.ui.main.pojofile

import com.google.gson.annotations.SerializedName

data class ChannelsResponse(

    @field:SerializedName("data")
    val data: DataChannelsResponse? = null
)

data class ChannelsItem(

    @field:SerializedName("series")
    val series: List<Any?>? = null,

    @field:SerializedName("mediaCount")
    val mediaCount: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("coverAsset")
    val coverAsset: CoverAsset? = null,

    @field:SerializedName("slug")
    val slug: String? = null,

    @field:SerializedName("latestMedia")
    val latestMedia: List<LatestMediaItem?>? = null,

    @field:SerializedName("iconAsset")
    val iconAsset: IconAsset? = null,

    @field:SerializedName("id")
    val id: String? = null
)

data class IconAsset(

    @field:SerializedName("thumbnailUrl")
    val thumbnailUrl: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class DataChannelsResponse(

    @field:SerializedName("channels")
    val channels: List<ChannelsItem?>? = null
)

data class CoverAssetChannelsResponse(

    @field:SerializedName("url")
    val url: String? = null
)

data class LatestMediaItem(

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("coverAsset")
    val coverAsset: CoverAssetChannelsResponse? = null
)

data class SeriesItem(

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("coverAsset")
    val coverAsset: CoverAsset? = null,

    @field:SerializedName("id")
    val id: String? = null
)
