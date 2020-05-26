package com.example.ads4

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*

class MovieAdapter (private var data:List<FilmModel>, private val listener: (FilmModel)-> Unit)
    :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context

        val inflatedView : View = layoutInflater.inflate(R.layout.item_movie_horizontal,parent,false)
        return MovieViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter,position)
    }

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val tvTitle:TextView = view.findViewById(R.id.tv_title)
        private val ivPoster:ImageView = view.findViewById(R.id.iv_poster)

        fun bindItem(data: FilmModel, listener: (FilmModel) -> Unit, context: Context, position: Int){
            tvTitle.text = data.judul
            Glide.with(context)
                .load(data.poster)
                .into(ivPoster)
            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}