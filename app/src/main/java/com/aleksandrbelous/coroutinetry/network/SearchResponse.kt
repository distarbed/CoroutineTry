package com.aleksandrbelous.coroutinetry.network

import com.google.gson.annotations.SerializedName

/**
 * @author Aleksandr Belous
 * @since 7/10/20.
 */
data class SearchResponse(

    @SerializedName("Search")
    val list:List<MovieItem>
)

data class MovieItem (
    @SerializedName("Title")
    val title:String
)