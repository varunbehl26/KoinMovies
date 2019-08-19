package com.varunbehl.koinmovies.di

import com.varunbehl.koinmovies.DataRepository
import com.varunbehl.koinmovies.viewModel.MovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val MovieModule = module {
    viewModel { MovieViewModel(get()) }
    single { DataRepository(get()) }
}