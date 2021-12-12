package com.example.myapplication

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class home_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_view)

        var actionBar = supportActionBar
        actionBar!!.title = "push pull"
        actionBar.setDisplayHomeAsUpEnabled(true)

        var textPlace = findViewById<TextView>(R.id.textView)
        textPlace.setText(intent.getStringExtra("gotFromInternet"))

        var imageView = findViewById<ImageView>(R.id.imageView)
        Glide.with(this).load("https://picsum.photos/200/300").into(imageView)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return  true
    }
}