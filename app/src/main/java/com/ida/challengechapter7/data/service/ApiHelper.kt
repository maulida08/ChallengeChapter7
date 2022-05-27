package com.ida.challengechapter7.data.service

class ApiHelper(private val apiService: ApiService) {
    suspend fun getPopularMovie() = apiService.getAllMoviePopular()

    suspend fun getAllDetail(movie_id : Int) = apiService.getALLDetail(movie_id)
}