package com.example.myapplication.ui

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.models.Results
import com.example.myapplication.R

class Adapter(val context:Activity):RecyclerView.Adapter<ViewHolder>() {

    private var listOfItem:MutableList<Results> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_detail_ui, parent, false) // Use your item layout here

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.movieName.text = listOfItem[position].title
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+listOfItem[position].posterPath).into(holder.movieImage)
    }

    override fun getItemCount(): Int {
        return listOfItem.size
    }




    fun updateData(listOfResults:MutableList<Results>)
    {
        listOfItem.clear()
        listOfItem.addAll(listOfResults)
        notifyDataSetChanged()
    }
//DiffUtil

}


class ViewHolder(view:View): RecyclerView.ViewHolder(view)
{
    val movieName = view.findViewById<TextView>(R.id.movieName)
    val movieImage = view.findViewById<ImageView>(R.id.movie_image)

}