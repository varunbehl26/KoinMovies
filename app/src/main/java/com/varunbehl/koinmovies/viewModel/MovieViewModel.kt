package com.varunbehl.koinmovies.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.varunbehl.koinmovies.DataRepository
import com.varunbehl.koinmovies.datamodel.MovieItem
import org.koin.core.KoinComponent
import org.koin.core.inject

class MovieViewModel(application: Application) : AndroidViewModel(application), KoinComponent {

    lateinit var moviesLiveData: LiveData<PagedList<MovieItem>>

    private val dataRepository: DataRepository by inject()

    fun getMovieData() {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(20)
            .build()


        val movieDataSourceFactory = MovieDataSourceFactory(dataRepository)

        moviesLiveData = LivePagedListBuilder(movieDataSourceFactory, pagedListConfig)
            .build()

    }
}
