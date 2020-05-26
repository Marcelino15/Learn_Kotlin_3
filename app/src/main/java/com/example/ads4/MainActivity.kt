package com.example.ads4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var dataList = ArrayList<FilmModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movie.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        loadDataSample()

        rv_movie.adapter = MovieAdapter(dataList){
            val intent = Intent(this,DetailActivity::class.java)
                .putExtra("data", it)
            startActivity(intent)
        }

        tv_viewall.setOnClickListener {
            val intent = Intent(this,AllMovieActivity::class.java)
                .putExtra("data", dataList)
            startActivity(intent)
        }
    }

    private fun loadDataSample() {
        dataList.add(
            FilmModel(
                "1",
                "Ad Astra (2019)",
                "Seorang astronot melakukan perjalanan ke tepi luar tata surya untuk menemukan ayahnya dan mengungkap misteri yang mengancam kelangsungan hidup planet kita. Dia mengungkap rahasia yang menantang sifat keberadaan manusia dan tempat kita di kosmos.",
                "Science Fiction, Drama ",
                R.drawable.ic_ad_astra,
                R.raw.ad_astra,
                4.0F
            )
        )
        dataList.add(
            FilmModel(
                "2",
                "A Rainy Day in New York (2019)",
                "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                "Komedi, Percintaan",
                R.drawable.ic_poster_a_rainy_day_in_new_york,
                R.raw.video_a_rainy_day,
                3.0F
            )
        )
        dataList.add(
            FilmModel(
                "3",
                "Avengers: Endgame (2019)",
                "Terdampar di luar angkasa tanpa persediaan makanan dan minuman, Tony Stark berusaha mengirim pesan untuk Pepper Potts dimana persediaan oksigen mulai menipis. Sementara itu para Avengers yang tersisa harus menemukan cara untuk mengembalikan 50% mahluk di seluruh dunia yang telah dilenyapkan oleh Thanos.",
                "Petualangan, Cerita Fiksi, Aksi",
                R.drawable.ic_avengers,
                R.raw.avenger,
                5.0F
            )
        )
        dataList.add(
            FilmModel(
                "4",
                "Sonic the Hedgehog (2020)",
                "Mengisahkan petualangan Sonic saat ia belajar tentang kompleksitas kehidupan di bumi bersama manusia sahabat barunya, Tom Wachowski. Sonic dan Tom bersatu untuk menghentikan si jahat Dr. Robotnik yang ingin menangkap Sonic dan menggunakan kekuatan istimewanya untuk menguasai dunia.",
                "Aksi, Cerita Fiksi, Komedi, Keluarga",
                R.drawable.ic_poster_sonic,
                R.raw.video_sonic,
                4.5F
            )
        )
    }
}
