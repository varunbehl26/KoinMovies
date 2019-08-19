package com.varunbehl.koinmovies.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.varunbehl.koinmovies.DataRepository
import com.varunbehl.koinmovies.datamodel.MovieItem
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MovieDataSourceFactory(private var dataRepository: DataRepository) :
    DataSource.Factory<Long, MovieItem>() {

    private val sourceLiveData = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Long, MovieItem> {
        val source = MovieDataSource(dataRepository)
        sourceLiveData.postValue(source)
        return source
    }
}

class MovieDataSource(private var dataRepository: DataRepository) :
    PageKeyedDataSource<Long, MovieItem>() {

    private var currentPage = 1

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, MovieItem>
    ) {

        dataRepository.fetchPopularDataFromServer(currentPage)
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe({
                val nextPage = it.page?.plus(1)
                callback.onResult(it.results!!, 0, nextPage?.toLong())
            }, {
                Log.v("---", it.printStackTrace().toString())

            })


    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, MovieItem>) {

        dataRepository.fetchPopularDataFromServer(++currentPage)
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe({
                val nextPage = it.page?.plus(1)
                callback.onResult(it.results!!, nextPage?.toLong())
            }, {
                Log.v("---", it.printStackTrace().toString())
            })

    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, MovieItem>) {

    }

}

