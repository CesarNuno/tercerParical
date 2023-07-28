package com.example.tercerparical.core

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.fromUrl(url:String){
    Picasso.get().load(url).into(this)
}