package com.example.mindvalleycodingchallenge.ui.main.pojofile

import com.google.gson.annotations.SerializedName

data class NewEpisodesResponse(

	@field:SerializedName("data")
	val data: Data? = null
)

data class MediaItem(

	@field:SerializedName("channel")
	val channel: Channel? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("coverAsset")
	val coverAsset: CoverAsset? = null
)

data class Data(

	@field:SerializedName("media")
	val media: List<MediaItem?>? = null
)

data class Channel(

	@field:SerializedName("title")
	val title: String? = null
)

data class CoverAsset(

	@field:SerializedName("url")
	val url: String? = null
)
