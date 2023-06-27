package com.fitpeo.interview.detail

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fitpeo.interview.R
import com.fitpeo.interview.data.AlbumItem

import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Charles Raj I on 26/06/23.
 * @author Charles Raj I
 */
@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {

    val backPressMutableLiveData: MutableLiveData<Int> = MutableLiveData()

    val albumItem = MutableLiveData<AlbumItem>()

    fun onBackPress(view: View){
        backPressMutableLiveData.postValue(0)
    }

    override fun onCleared() {
        super.onCleared()
    }

}