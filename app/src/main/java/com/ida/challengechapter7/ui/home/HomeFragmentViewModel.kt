package com.ida.challengechapter7.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ida.challengechapter7.data.Repository
import com.ida.challengechapter7.data.Resource
import com.ida.challengechapter7.data.model.GetAllMoviePopular
import kotlinx.coroutines.launch

class HomeFragmentViewModel(private val repository: Repository): ViewModel() {
    private var _dataMovie = MutableLiveData<Resource<GetAllMoviePopular>>()
    val dataMovie : LiveData<Resource<GetAllMoviePopular>> get() = _dataMovie

    fun getMovie(){
        viewModelScope.launch {
            _dataMovie.postValue(Resource.loading())
            try {
                _dataMovie.postValue(Resource.success(repository.getPopularMovie()))
            } catch (e: Exception){
                _dataMovie.postValue(Resource.error(e.message ?: "Error Occurred"))
            }
        }
    }
}