package com.example.memeapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var currentImageUrl: String? = null
    var previousImageUrl: String? = null
    var realPreviousUrl : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPrevious.isEnabled = false
        btnPrevious.setBackgroundColor(Color.GRAY)
        loadMeme()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menufile,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.shareBtn->{
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT,"Hey, checkout this cool meme $currentImageUrl")
                val chooser = Intent.createChooser(intent,"share this meme using: ")
                startActivity(chooser)

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadMeme()
    {
        progressBar.visibility = View.VISIBLE
        // Instantiate the RequestQueue.
      //  val queue = Volley.newRequestQueue(this)
        currentImageUrl = "https://meme-api.herokuapp.com/gimme"

// Request a string response from the provided URL.
        val stringRequest = JsonObjectRequest(
            Request.Method.GET, currentImageUrl ,null,
            { response ->
                val url = response.getString("url")
                previousImageUrl = url
                Glide.with(this).load(url).listener(object : RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                }).into(imageView)
                            },
            {
                Toast.makeText(this, "something went wrong!\nCheck your connection and try again.", Toast.LENGTH_SHORT).show()
            }
        )

// Add the request to the RequestQueue.
        //queue.add(stringRequest)
        MySingleton.getInstance(this).addToRequestQueue(stringRequest)


    }

//    fun onShare(view: View) {
//    val intent = Intent(Intent.ACTION_SEND)
//        intent.type = "text/plain"
//        intent.putExtra(Intent.EXTRA_TEXT,"Hey, checkout this cool meme $currentImageUrl")
//        val chooser = Intent.createChooser(intent,"share this meme using: ")
//        startActivity(chooser)
//
//    }

    private fun loadPreviousMeme()
    {
        progressBar.visibility = View.VISIBLE
        // Instantiate the RequestQueue.
        //  val queue = Volley.newRequestQueue(this)
        currentImageUrl = "https://meme-api.herokuapp.com/gimme"

// Request a string response from the provided URL.
        val stringRequest = JsonObjectRequest(
            Request.Method.GET, currentImageUrl ,null,
            { response ->
                val url = realPreviousUrl
                Glide.with(this).load(url).listener(object : RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                }).into(imageView)
            },
            {
                Toast.makeText(this, "something went wrong!\nCheck your connection and try again.", Toast.LENGTH_SHORT).show()
            }
        )

// Add the request to the RequestQueue.
        //queue.add(stringRequest)
        MySingleton.getInstance(this).addToRequestQueue(stringRequest)


    }

    fun onNext(view: View) {
        loadMeme()
        if (!btnPrevious.isEnabled) btnPrevious.isEnabled=true
        btnPrevious.setBackgroundColor(Color.parseColor("#AD1457"))
        realPreviousUrl = previousImageUrl

    }

    fun onPrevious(view: View) {
        btnPrevious.isEnabled = false
        btnPrevious.setBackgroundColor(Color.GRAY)
        loadPreviousMeme()

    }
}