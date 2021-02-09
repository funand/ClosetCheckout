package com.example.minicheckout.extensions

import android.app.Activity
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.minicheckout.ui.DecodedImageUrl

private const val FILE_SCHEME = "file"

// Load callback provided if there is any task to perform once image is loaded or failed.
fun ImageView.load(imageUrl: String, loadCallback: (() -> Unit)? = null) {
    if (imageUrl.isBlank()) {
        // Load placeholder if image is missing maybe?
        // Glide.with(context).load().into(this)
    } else {
        if (isLoadable()) {
            // don't use GlideUrl for local files as it causes refresh problems
            val request = if (Uri.parse(imageUrl).scheme == FILE_SCHEME) {
                Glide.with(context)
                    .load(imageUrl)
            } else {
                Glide.with(context)
                    .load(DecodedImageUrl(imageUrl))
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .skipMemoryCache(true)
            }

            if (loadCallback != null) {
                request.listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        TODO("Not yet implemented")
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        post { loadCallback() }
                        return false
                    }
                })
            } else {
                request
            }
                .into(this)
        }
    }
}

fun ImageView.loadCircleCrop(imageUri: String) {
    if (isLoadable()) {
        // don't use GlideUrl for local files as it causes refresh problems
        if (Uri.parse(imageUri).scheme == FILE_SCHEME) {
            Glide.with(context)
                .load(imageUri)
                .circleCrop()
                .into(this)

        } else {
            Glide.with(context)
                .load(DecodedImageUrl(imageUri))
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .skipMemoryCache(true)
                .into(this)
        }
    }
}

fun ImageView.clear() {
    Glide.with(this).clear(this)
}

private fun ImageView.isLoadable() = if (context is Activity) {
    val activity = context as Activity
    (!activity.isFinishing && !activity.isDestroyed)
} else {
    true
}
