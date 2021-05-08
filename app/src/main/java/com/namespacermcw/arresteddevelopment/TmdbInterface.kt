package com.namespacermcw.arresteddevelopment

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbInterface {

    @GET("/3/movie/popular")
    fun getMovies(@Query("api_key") key: String): Call<PopularMovies>

}