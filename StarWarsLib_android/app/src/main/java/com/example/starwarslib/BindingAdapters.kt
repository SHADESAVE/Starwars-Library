package com.example.starwarslib

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.starwarslib.list.ListGridAdapter
import com.example.starwarslib.list.StarWarsApiStatus
import com.example.starwarslib.database.StarWarsItem

@BindingAdapter("listData", "status")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<StarWarsItem>?, status: StarWarsApiStatus?) {
    val adapter = recyclerView.adapter as ListGridAdapter
    if (status == StarWarsApiStatus.LOADING) {
        recyclerView.visibility = View.GONE
    } else {
        adapter.submitList(data)
        recyclerView.visibility = View.VISIBLE
    }
}

@BindingAdapter("starWarsApiStatus")
fun bindStatus(statusImageView: ImageView, status: StarWarsApiStatus?) {
    statusImageView.setOnClickListener { imageView ->
        if (status != StarWarsApiStatus.LOADING) imageView.visibility = View.GONE
    }
    when (status) {
        StarWarsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        StarWarsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        StarWarsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUrl = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUrl)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}