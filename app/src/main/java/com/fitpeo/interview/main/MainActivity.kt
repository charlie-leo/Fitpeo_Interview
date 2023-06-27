package com.fitpeo.interview.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.fitpeo.interview.R
import com.fitpeo.interview.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitpeo.interview.data.AlbumItem
import com.fitpeo.interview.main.adapter.AlbumAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        mainActivityViewModel.albumMutableLiveData.observe(this, albumResult())
    }

    private fun albumResult() = Observer<List<AlbumItem>> { albumList ->
        albumList?.let { albumItem ->
            val albumAdapter = AlbumAdapter(albumItem, this)
            activityMainBinding.let {
                it.albumRecyclerView.layoutManager = LinearLayoutManager(this)
                it.albumRecyclerView.adapter = albumAdapter
            }
        }
    }
}