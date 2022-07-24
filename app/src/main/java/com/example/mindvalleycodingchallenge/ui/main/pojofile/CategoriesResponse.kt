package com.example.mindvalleycodingchallenge.ui.main.pojofile

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(

    @field:SerializedName("data")
    val data: DataCategoriesResponse? = null
)

data class CategoriesItem(

    @field:SerializedName("name")
    val name: String? = null
)

data class DataCategoriesResponse(

    @field:SerializedName("categories")
    val categories: List<CategoriesItem?>? = null
)
