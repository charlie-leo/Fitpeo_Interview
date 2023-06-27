package com.fitpeo.interview.main.adapter

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fitpeo.interview.R
import com.fitpeo.interview.data.AlbumItem
import com.fitpeo.interview.databinding.AlbumItemBinding
import com.fitpeo.interview.detail.DetailActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlin.Exception
import kotlin.math.log


/**
 * Created by Charles Raj I on 25/06/23.
 * @author Charles Raj I
 */
class AlbumAdapter( private var albumItem: List<AlbumItem>, private val context: Activity) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val albumItemBinding: AlbumItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.album_item,
            parent,
            false
        )
        return AlbumViewHolder(albumItemBinding)
    }

    override fun getItemCount(): Int {
        return albumItem.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val albumItem  =albumItem.get(position)
        holder.bind(albumItem,context)
    }


    class AlbumViewHolder(private val albumItemBinding: AlbumItemBinding) :
        RecyclerView.ViewHolder(albumItemBinding.root) {

            fun bind(albumItem: AlbumItem, context: Activity) {
                albumItemBinding.albumData = albumItem

                albumItemBinding.albumBase.setOnClickListener(View.OnClickListener {
                    try {
                        val intent = Intent(context, DetailActivity::class.java)
                        intent.putExtra("data", albumItem)
                        context.startActivity(intent)
                    }catch (e: Exception){
                        Log.d("TAG", "bind: $e")
                    }
                })
            }
    }

}