package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return  true
    }
}