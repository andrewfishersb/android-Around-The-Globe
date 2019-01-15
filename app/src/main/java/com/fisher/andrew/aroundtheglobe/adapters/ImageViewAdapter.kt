package com.fisher.andrew.aroundtheglobe.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fisher.andrew.aroundtheglobe.R
import com.fisher.andrew.aroundtheglobe.models.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_image_slide_page.view.*

class ImageViewAdapter(private val photos : List<Photo>, private val context: Context): RecyclerView.Adapter<ImageViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_image_slide_page,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val currentPhoto = photos[position]

        Picasso.with(context).load(currentPhoto.photoUrl).resize(300, 300).onlyScaleDown().centerCrop().into(holder?.rvCityPhotos)

    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val rvCityPhotos = view.city_image_view!!

    }


}