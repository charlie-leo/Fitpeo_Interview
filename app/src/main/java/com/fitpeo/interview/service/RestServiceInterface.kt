package com.fitpeo.interview.service

import com.fitpeo.interview.data.AlbumItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Charles Raj I on 25/06/23.
 * @author Charles Raj I
 */
interface RestServiceInterface {

    @GET("/photos")
    suspend fun getAllAlbumData(): Response<List<AlbumItem>>
}