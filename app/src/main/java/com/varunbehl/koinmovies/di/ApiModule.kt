package com.varunbehl.koinmovies.di

import com.varunbehl.koinmovies.network.NetworkApiSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val BASE_URL: String = "https://api.themoviedb.org/"

/**
 * Network module compilation used by KOIN
 */
val ApiModule = module {
    single { createStatusService(get()) }
    single { createOkHttpClient() }
    single { createRetrofit(get()) }
}


fun createOkHttpClient(): OkHttpClient {
    val clientBuilder = OkHttpClient.Builder()

    addTimeout(clientBuilder)

    clientBuilder.addInterceptor { chain ->
        val original = chain.request()
        val requestBuilder = original.newBuilder()

        requestBuilder
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .method(original.method, original.body)

        chain.proceed(requestBuilder.build())

    }.build()

    clientBuilder.addInterceptor(loggingInterceptor())

    return clientBuilder.build()
}


/**
 * This method add timeout for CRUD API calls
 * @param clientBuilder Builder
 */
private fun addTimeout(clientBuilder: OkHttpClient.Builder) {
    clientBuilder
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
}


/**
 * This method add logging interceptop
 * The logs are at level body and will only be added for debug mode
 * @return HttpLoggingInterceptor
 */
fun loggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
}

/**
 * This function creates retrofit for the network service to use.
 * @param okHttpClient OkHttpClient
 * @return Retrofit
 */
fun createRetrofit(okHttpClient: OkHttpClient, baseUrl: String = BASE_URL): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

/**
 * Create network api service for api calls
 * @param retrofit Retrofit
 * @return NetworkApiSource
 */
fun createStatusService(retrofit: Retrofit): NetworkApiSource =
    retrofit.create(NetworkApiSource::class.java)



