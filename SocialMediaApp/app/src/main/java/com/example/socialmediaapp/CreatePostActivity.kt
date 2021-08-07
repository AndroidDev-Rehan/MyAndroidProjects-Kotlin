package com.example.socialmediaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.socialmediaapp.Daos.PostDao
import kotlinx.android.synthetic.main.activity_create_post.*

class CreatePostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
        val postDao = PostDao()
        postButton.setOnClickListener {
            val input = postInput.text.toString().trim()
            if (input.isNotEmpty()) {
                postDao.addPost(input)
                finish()
            }
        }

    }
}