package com.fitpeo.interview.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fitpeo.interview.R
import com.fitpeo.interview.data.AlbumItem
import com.fitpeo.interview.databinding.DetailActivityBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Charles Raj I on 26/06/23.
 * @author Charles Raj I
 */
@AndroidEntryPoint
public class DetailActivity :
    AppCompatActivity() {

    private val detailViewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val detailActivityBinding: DetailActivityBinding =
            DataBindingUtil
                .setContentView(this, R.layout.detail_activity)

        detailActivityBinding.detailViewModel = detailViewModel
        intent?.let {
            val albumItem = it.getParcelableExtra("data") as AlbumItem?
            albumItem?.let {
                detailViewModel.albumItem.postValue(albumItem)
            }
        }

        detailViewModel.backPressMutableLiveData.observe(this, backPress())

    }

    private fun backPress() = Observer<Int> { type ->
        if (type == 0) {
            onBackPressedDispatcher.onBackPressed()
        }
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
