package com.varunbehl.koinmovies

import com.varunbehl.koinmovies.datamodel.Movie
import com.varunbehl.koinmovies.datamodel.MovieDetail
import com.varunbehl.koinmovies.network.NetworkApiSource
import rx.Observable

/**
 * Class used by viewmodel to get data
 * @param dataInterface is injected via KOIN
 */
class DataRepository(private var dataInterface: NetworkApiSource) {
    private val API_KEY = ""

    fun fetchPopularDataFromServer(page: Int): Observable<Movie>? {
        return dataInterface.getMovies("popular", page, API_KEY)
    }

    fun fetchMovieDetailFromServer(id: Int): Observable<MovieDetail>? {
        return dataInterface.getMovieDetails(
            id,
            API_KEY,
            "credits,videos,images,similar,recommendations"
        )
    }

}
