package com.example.ads4

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_all_movie.*
import kotlinx.android.synthetic.main.content_all_movie.*

class AllMovieActivity : AppCompatActivity() {

    private var datalist = ArrayList<FilmModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_movie)
        setSupportActionBar(toolbar)

        datalist = intent.getParcelableArrayListExtra("data")

        rv_all_movie.layoutManager = LinearLayoutManager(this)

        rv_all_movie.adapter = AllMovieAdapter(datalist){
            val intent = Intent(this,DetailActivity::class.java)
                .putExtra("data",it)
            startActivity(intent)
        }

    }

}
