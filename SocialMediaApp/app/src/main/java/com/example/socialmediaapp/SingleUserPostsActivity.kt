package com.example.socialmediaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialmediaapp.Daos.PostDao
import com.example.socialmediaapp.Daos.UserDao
import com.example.socialmediaapp.Models.Post
import com.example.socialmediaapp.Models.User
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.recyclerView
import kotlinx.android.synthetic.main.activity_single_user_posts.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class SingleUserPostsActivity : AppCompatActivity(), IPostAdapter {

    private lateinit var postDao: PostDao
    private lateinit var adapter: PostAdapter
    private var uid : String? = null
    private var user : User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_user_posts)
        uid = intent.getStringExtra("uid")
//        if (uid!=null){
        GlobalScope.launch(Dispatchers.Main) {
            user = getUser(uid!!)
            val text = "${user!!.displayName}'s Profile"
            TVProfileTitle.text = text
        }
//            Toast.makeText(applicationContext,"User ID is $uid",Toast.LENGTH_LONG).show()
 //       }
//        else{
//        Toast.makeText(applicationContext,"User ID recieved by intent (Main Activity) is null",Toast.LENGTH_LONG).show()
 //       }



        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        postDao = PostDao()
        val postsCollections = postDao.users.document(uid!!).collection("user_posts")
        val query = postsCollections.orderBy("createdAt", Query.Direction.DESCENDING)
        val recyclerViewOptions = FirestoreRecyclerOptions.Builder<Post>().setQuery(query, Post::class.java).build()

        adapter = PostAdapter(recyclerViewOptions,this)



        recyclerViewS.adapter = adapter
        recyclerViewS.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }



    override fun onLikeClicked(postId: String) {
        postDao.updateLikes(postId)
    }

    override fun onNameClicked(postId: String) {
        Toast.makeText(applicationContext,"You are already visiting ${user!!.displayName}'s id.",Toast.LENGTH_SHORT).show()
    }

    suspend fun getUser(uid : String): User?{
        var user : User? = null
        val userDao = UserDao()
        user =  userDao.getUserById(uid).await().toObject(User::class.java)
        return user
    }
}