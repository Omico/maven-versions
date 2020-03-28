package me.omico.maven.google.api

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object GoogleMavenService {

    private const val baseUrl = "https://maven.google.com/"

    fun createGoogleMavenApi(): GoogleMavenApi {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        return retrofit.create(GoogleMavenApi::class.java)
    }
}