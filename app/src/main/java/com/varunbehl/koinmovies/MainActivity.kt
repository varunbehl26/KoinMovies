package com.varunbehl.koinmovies

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.varunbehl.koinmovies.databinding.ActivityMainBinding
import com.varunbehl.koinmovies.datamodel.MovieItem
import com.varunbehl.koinmovies.viewModel.MovieViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val myViewModel: MovieViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        myViewModel.getMovieData()

        myViewModel.moviesLiveData.observe(this, Observer<PagedList<MovieItem>> {
            binding.recyclerView.layoutManager =
                StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            val movieAdapter = MoviePagedListAdapter { movieItem: MovieItem, view: View, pos: Int ->
                //                clickListener.onMovieItemClick(movieItem.id!!, view.image)
            }
            binding.recyclerView.adapter = movieAdapter
            movieAdapter.submitList(it)
        })

    }
}
