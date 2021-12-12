package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
     lateinit var button:Button;
    var client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)

        //networking with httpClient when someone presses the button

        button.setOnClickListener{
            val request = Request.Builder()
                .url("https://mars.udacity.com")
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        if (!response.isSuccessful) throw IOException("Unexpected code $response")
                        var getString = response.body!!.string()
                        println(getString)
                        var intent = Intent(this@MainActivity, home_view::class.java)
                        intent.putExtra("gotFromInternet", getString)
                        startActivity(intent)

                    }
                }
            })
        }


    }

}

