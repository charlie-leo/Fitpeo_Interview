package com.fitpeo.interview.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fitpeo.interview.data.AlbumItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Charles Raj I on 25/06/23.
 * @author Charles Raj I
 */

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val mainRepository: MainActivityRepository) :
    ViewModel() {

    lateinit var job: Job
    val albumMutableLiveData: MutableLiveData<List<AlbumItem>> = MutableLiveData<List<AlbumItem>>()

    init {
        getAlbumData()
    }

    private fun getAlbumData() {
        job = viewModelScope.launch {
            mainRepository.getAlbumData(albumMutableLiveData)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}