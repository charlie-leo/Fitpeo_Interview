package com.fitpeo.interview.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by Charles Raj I on 26/06/23.
 * @author Charles Raj I
 */
@Parcelize
data class AlbumItem(

    @field:SerializedName("albumId")
    val albumId: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("thumbnailUrl")
    val thumbnailUrl: String? = null
) : Parcelable
