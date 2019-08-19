package com.varunbehl.koinmovies.datamodel

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(
    @Json(name = "page")
    var page: Int? = 0,
    @Json(name = "total_pages")
    var totalPages: Int? = 0,
    @Json(name = "results")
    var results: List<MovieItem>?,
    @Json(name = "total_results")
    var totalResults: Int? = 0
)

@JsonClass(generateAdapter = true)
data class MovieItem(
    @Json(name = "overview")
    var overview: String? = "",
    @Json(name = "original_language")
    var originalLanguage: String? = "",
    @Json(name = "original_title")
    var originalTitle: String? = "",
    @Json(name = "video")
    var video: Boolean? = false,
    @Json(name = "title")
    var title: String? = "",
    @Json(name = "genre_ids")
    var genreIds: List<Int>?,
    @Json(name = "poster_path")
    var posterPath: String? = "",
    @Json(name = "backdrop_path")
    var backdropPath: String? = "",
    @Json(name = "release_date")
    var releaseDate: String? = "",
    @Json(name = "vote_average")
    var voteAverage: Double? = 0.0,
    @Json(name = "popularity")
    var popularity: Double? = 0.0,
    @Json(name = "id")
    var id: Int? = 0,
    @Json(name = "adult")
    var adult: Boolean? = false,
    @Json(name = "vote_count")
    var voteCount: Int? = 0
)


