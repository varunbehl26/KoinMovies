package com.varunbehl.koinmovies.network


import com.varunbehl.koinmovies.datamodel.Movie
import com.varunbehl.koinmovies.datamodel.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkApiSource {

    @GET("3/movie/{id}")
    fun getMovieDetails(@Path("id") id: Int, @Query("api_key") apiKey: String, @Query("append_to_response") credits: String): rx.Observable<MovieDetail>


    @GET("3/movie/{categories}")
    fun getMovies(
        @Path("categories") categories: String, @Query("page") page: Int, @Query(
            "api_key"
        ) apiKey: String
    ): rx.Observable<Movie>

}
