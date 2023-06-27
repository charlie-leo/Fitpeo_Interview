package com.fitpeo.interview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

/**
 * Created by Charles Raj I on 26/06/23.
 * @author Charles Raj I
 */
class StaticComponents {

    companion object {


        @BindingAdapter("thumbUrl", "imageUrl", requireAll = true)
        @JvmStatic
        fun ImageView.loadImageWithThumbnail(thumbnailUrl: String?, imageUrl: String?) {
            thumbnailUrl?.let {
                Picasso.get()
                    .load(thumbnailUrl) // thumbnail url goes here
                    .into(this, object : Callback {
                        override fun onSuccess() {
                            imageUrl?.let {
                                Picasso.get()
                                    .load(imageUrl)
                                    .placeholder(R.drawable.ic_launcher_background)
                                    .into(this@loadImageWithThumbnail)
                            }
                        }

                        override fun onError(e: Exception?) {
                            imageUrl?.let {
                                Picasso.get()
                                    .load(imageUrl)
                                    .placeholder(R.drawable.ic_launcher_background)
                                    .into(this@loadImageWithThumbnail)
                            }
                        }
                    })
            }
        }
    }

}