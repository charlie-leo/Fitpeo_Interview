package com.fitpeo.interview.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.fitpeo.interview.data.AlbumItem
import com.fitpeo.interview.service.RestServiceInterface
import dagger.Component
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Charles Raj I on 25/06/23.
 * @author Charles Raj I
 */


class MainActivityRepository @Inject constructor(private val retrofitService: RestServiceInterface) {

    suspend fun getAlbumData(albumMutableLiveData: MutableLiveData<List<AlbumItem>>) {
        try {
            val response = retrofitService.getAllAlbumData()
            if (response.isSuccessful){
                albumMutableLiveData.postValue(response.body())
            }else{
                albumMutableLiveData.postValue(null)
            }
        }catch (e: Exception){
            Log.d("TAG", "getAlbumData: $e")
        }
    }

}