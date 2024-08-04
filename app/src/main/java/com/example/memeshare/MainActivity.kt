package com.example.memeshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMeme()
    }

    private fun loadMeme(){
//        // instantiate the RequestQueue
//        val queue  = Volley.newRequestQueue(this)
//        //val url  = "https://www.google.com"
//        val url  = "https://meme-api.herokuapp.com/gimme"
//
//        //Requesting a string response from the provided URL
//        val stringRequest = StringRequest(
//            Request.Method.GET,url,
//            Response.Listener<String> { response ->  },
//            Response.ErrorListener {  })
//        // Add the request to the RequestQueue
//
//        queue.add(stringRequest)
//
        // instantiate the RequestQueue
        val queue  = Volley.newRequestQueue(this)
        val url  = "https://meme-api.com/gimme"

        //Requesting a string response from the provided URL

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,
            {response->
                val url = response.getString("url")
               // val memeImageView : ImageView = findViewById(R.id.memeImageView)
                Glide.with(this).load(url).into(findViewById(R.id.memeImageView))
            },
            {
                Toast.makeText(this,"something wrong",Toast.LENGTH_LONG).show() })

        queue.add(jsonObjectRequest)


   }


    fun nextMeme(view: View) {}
    fun shareMeme(view: View) {}
}