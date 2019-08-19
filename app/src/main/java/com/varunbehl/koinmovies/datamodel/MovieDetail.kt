package  com.varunbehl.koinmovies.datamodel


import com.squareup.moshi.Json

data class ResultsItem(
    @Json(name = "overview")
    val overview: String = "",
    @Json(name = "original_language")
    val originalLanguage: String = "",
    @Json(name = "original_title")
    val originalTitle: String = "",
    @Json(name = "video")
    val video: Boolean = false,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "genre_ids")
    val genreIds: List<Long>?,
    @Json(name = "poster_path")
    val posterPath: String = "",
    @Json(name = "backdrop_path")
    val backdropPath: String = "",
    @Json(name = "release_date")
    val releaseDate: String = "",
    @Json(name = "popularity")
    val popularity: Double = 0.0,
    @Json(name = "vote_average")
    val voteAverage: Double = 0.0,
    @Json(name = "id")
    val id: String,
    @Json(name = "adult")
    val adult: Boolean = false,
    @Json(name = "vote_count")
    val voteCount: Long = 0
)


data class ProductionCountriesItem(
    @Json(name = "iso_3166_1")
    val iso: String = "",
    @Json(name = "name")
    val name: String = ""
)


data class Images(
    @Json(name = "backdrops")
    val backdrops: List<BackdropsItem>?,
    @Json(name = "posters")
    val posters: List<PostersItem>?
)


data class Similar(
    @Json(name = "page")
    val page: Long = 0,
    @Json(name = "total_pages")
    val totalPages: Long = 0,
    @Json(name = "results")
    val results: List<ResultsItem>?,
    @Json(name = "total_results")
    val totalResults: Long = 0
)


data class CrewItem(
    @Json(name = "gender")
    val gender: Long = 0,
    @Json(name = "credit_id")
    val creditId: String = "",
    @Json(name = "name")
    val name: String = "",
    @Json(name = "profile_path")
    val profilePath: String = "",
    @Json(name = "id")
    val id: Long = 0,
    @Json(name = "department")
    val department: String = "",
    @Json(name = "job")
    val job: String = ""
)


data class ProductionCompaniesItem(
    @Json(name = "logo_path")
    val logoPath: String = "",
    @Json(name = "name")
    val name: String = "",
    @Json(name = "id")
    val id: Long = 0,
    @Json(name = "origin_country")
    val originCountry: String = ""
)


data class MovieDetail(
    @Json(name = "original_language")
    val originalLanguage: String = "",
    @Json(name = "imdb_id")
    val imdbId: String = "",
    @Json(name = "videos")
    val videos: Videos,
    @Json(name = "video")
    val video: Boolean = false,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "recommendations")
    val recommendations: Recommendations,
    @Json(name = "backdrop_path")
    val backdropPath: String = "",
    @Json(name = "revenue")
    val revenue: Long = 0,
    @Json(name = "credits")
    val credits: Credits,
    @Json(name = "genres")
    val genres: List<GenresItem>?,
    @Json(name = "popularity")
    val popularity: Double = 0.0,
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountriesItem>?,
    @Json(name = "id")
    val id: Long = 0,
    @Json(name = "vote_count")
    val voteCount: Long = 0,
    @Json(name = "budget")
    val budget: Long = 0,
    @Json(name = "overview")
    val overview: String = "",
    @Json(name = "similar")
    val similar: Similar,
    @Json(name = "images")
    val images: Images,
    @Json(name = "original_title")
    val originalTitle: String = "",
    @Json(name = "runtime")
    val runtime: Long = 0,
    @Json(name = "poster_path")
    val posterPath: String = "",
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguagesItem>?,
    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompaniesItem>?,
    @Json(name = "release_date")
    val releaseDate: String = "",
    @Json(name = "vote_average")
    val voteAverage: Double = 0.0,
    @Json(name = "belongs_to_collection")
    val belongsToCollection: BelongsToCollection,
    @Json(name = "tagline")
    val tagline: String = "",
    @Json(name = "adult")
    val adult: Boolean = false,
    @Json(name = "homepage")
    val homepage: String = "",
    @Json(name = "status")
    val status: String = ""
)


data class Videos(
    @Json(name = "results")
    val results: List<VideoItem>?
)


data class Recommendations(
    @Json(name = "page")
    val page: Long = 0,
    @Json(name = "total_pages")
    val totalPages: Long = 0,
    @Json(name = "results")
    val results: List<ResultsItem>?,
    @Json(name = "total_results")
    val totalResults: Long = 0
)


data class Credits(
    @Json(name = "cast")
    val cast: List<CastItem>?,
    @Json(name = "crew")
    val crew: List<CrewItem>?
)


data class PostersItem(
    @Json(name = "aspect_ratio")
    val aspectRatio: Double = 0.0,
    @Json(name = "file_path")
    val filePath: String = "",
    @Json(name = "vote_average")
    val voteAverage: Double = 0.0,
    @Json(name = "width")
    val width: Long = 0,
    @Json(name = "iso_639_1")
    val iso: String = "",
    @Json(name = "vote_count")
    val voteCount: Long = 0,
    @Json(name = "height")
    val height: Long = 0
)


data class BelongsToCollection(
    @Json(name = "backdrop_path")
    val backdropPath: String = "",
    @Json(name = "name")
    val name: String = "",
    @Json(name = "id")
    val id: Long = 0,
    @Json(name = "poster_path")
    val posterPath: String = ""
)


data class SpokenLanguagesItem(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "iso_639_1")
    val iso: String = ""
)


data class GenresItem(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "id")
    val id: Long = 0
)


data class BackdropsItem(
    @Json(name = "aspect_ratio")
    val aspectRatio: Double = 0.0,
    @Json(name = "file_path")
    val filePath: String = "",
    @Json(name = "vote_average")
    val voteAverage: Double = 0.0,
    @Json(name = "width")
    val width: Long = 0,
    @Json(name = "vote_count")
    val voteCount: Long = 0,
    @Json(name = "height")
    val height: Long = 0
)


data class CastItem(
    @Json(name = "cast_id")
    val castId: Long = 0,
    @Json(name = "character")
    val character: String = "",
    @Json(name = "gender")
    val gender: Long = 0,
    @Json(name = "credit_id")
    val creditId: String = "",
    @Json(name = "name")
    val name: String = "",
    @Json(name = "profile_path")
    val profilePath: String? = null,
    @Json(name = "id")
    val id: Long = 0,
    @Json(name = "order")
    val order: Long = 0
)


data class VideoItem(
    val site: String = "",
    val size: Long = 0,
    val name: String = "",
    val id: String = "",
    val type: String = "",
    val iso: String = "",
    val key: String = ""
)