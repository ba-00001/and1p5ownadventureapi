package com.example.and1p5ownadventureapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    var animalImageURL_1 = ""
    var animalImageURL_2 = ""
    var animalImageURL_3 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.getPhotoButton)
        val imageView = findViewById<ImageView>(R.id.AnimalPhoto1)
        val imageView2 = findViewById<ImageView>(R.id.AnimalPhoto2)
        val imageView3 = findViewById<ImageView>(R.id.AnimalPhoto3)
        getNextImage(button, imageView)
        getNextImage2(button, imageView2)
        getNextImage3(button, imageView3)
    }

    /*
       For Animal #1
        */
    private fun getAnimalImageURL_1(){
        val client = AsyncHttpClient()
        client["https://dog.ceo/api/breeds/image/random", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.d("Dog", "response successful")
                animalImageURL_1 = json.jsonObject.getString("message")
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.e("Error", "Request failed with error: $errorResponse")
                throwable?.printStackTrace()

            }
        }]
    }

    private fun getNextImage(button: Button, imageView: ImageView) {
        button.setOnClickListener {
            getAnimalImageURL_1()

            Glide.with(this)
                .load(animalImageURL_1)
                .fitCenter()
                .into(imageView)
        }
    }


    /*
      For Animal #2
       */

private fun getAnimalImageURL_2(){
    val client = AsyncHttpClient()
    client["https://api.thecatapi.com/v1/images/search?limit=10", object : JsonHttpResponseHandler() {
        override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
            Log.d("Cat", "response successful")
            animalImageURL_2 = json.jsonObject.getString("url")
        }

        override fun onFailure(
            statusCode: Int,
            headers: Headers?,
            errorResponse: String,
            throwable: Throwable?
        ) {
            Log.e("Error", "Request failed with error: $errorResponse")
            throwable?.printStackTrace()

        }
    }]
}

private fun getNextImage2(button: Button, imageView2: ImageView) {
    button.setOnClickListener {
        getAnimalImageURL_2()

        Glide.with(this)
            .load(animalImageURL_2)
            .fitCenter()
            .into(imageView2)
    }
}
/*
  For Animal #3
   */

private fun getAnimalImageURL_3(){
    val client = AsyncHttpClient()
    client["https://randomfox.ca/floof/?ref=apilist.fun", object : JsonHttpResponseHandler() {
        override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
            Log.d("fox", "response successful")
            animalImageURL_3 = json.jsonObject.getString("image")
        }

        override fun onFailure(
            statusCode: Int,
            headers: Headers?,
            errorResponse: String,
            throwable: Throwable?
        ) {
            Log.e("Error", "Request failed with error: $errorResponse")
            throwable?.printStackTrace()

        }
    }]
}

private fun getNextImage3(button: Button, imageView3: ImageView) {
    button.setOnClickListener {
        getAnimalImageURL_3()

        Glide.with(this)
            .load(animalImageURL_3)
            .fitCenter()
            .into(imageView3)
    }
}
}

