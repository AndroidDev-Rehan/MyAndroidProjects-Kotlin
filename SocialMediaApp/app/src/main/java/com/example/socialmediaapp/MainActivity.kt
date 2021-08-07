package com.example.socialmediaapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialmediaapp.Daos.PostDao
import com.example.socialmediaapp.Models.Post
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import com.bumptech.glide.Glide
import com.example.socialmediaapp.Daos.UserDao
import com.example.socialmediaapp.Models.User
import kotlinx.android.synthetic.main.custom_tool_bar.*


class MainActivity : AppCompatActivity(), IPostAdapter {
    private lateinit var postDao: PostDao
    private lateinit var adapter: PostAdapter
    lateinit var mGoogleSignInClient: GoogleSignInClient




    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        fab.setOnClickListener{
            val intent = Intent(this,CreatePostActivity::class.java)
            startActivity(intent)
        }
        setUpRecyclerView()
        setUpLogout()

        newButtonLogOut.setOnClickListener{
            newLogOut()
        }

        val userDao = UserDao()
        val cUserSP = userDao.getUserById(auth.currentUser!!.uid)
        var cUser : User?
        GlobalScope.launch(Dispatchers.Main) {
            cUser = cUserSP.await().toObject(User::class.java)
            withContext(Dispatchers.Main) {
                Glide.with(this@MainActivity).load(cUser?.imageUrl).circleCrop().into(imageViewPerson)
            }
        }

        searchIcon.setOnClickListener{
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }



        imageViewPerson.setOnClickListener{
            val intent = Intent(this@MainActivity,SingleUserPostsActivity::class.java)
            intent.putExtra("uid",auth.currentUser!!.uid)
            startActivity(intent)
        }
        
    }

    

    private fun setUpLogout(){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso)
    }
    
    private fun newLogOut(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sign out confirmation message")
        builder.setMessage("Are you sure you want to log out of the app?\n(Dubara soch lien!)")

        builder.setPositiveButton("Yes") { dialog, id ->
            newSignOut()
            dialog.cancel()
        }

        builder.setNegativeButton("No") { dialog, id ->
            dialog.cancel()
        }
        builder.create().show()

    }

    private fun newSignOut() {
        // Firebase sign out
        auth.signOut()

        // Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener(
            this
        ) {  val intent = Intent(this, SignInActivity::class.java)
            intent.putExtra("flagg", true)

            startActivity(intent)
            finish()
        }
    }


    private fun setUpRecyclerView() {
        postDao = PostDao()
        val postsCollections = postDao.postCollections
        val query = postsCollections.orderBy("createdAt", Query.Direction.DESCENDING)
        val recyclerViewOptions = FirestoreRecyclerOptions.Builder<Post>().setQuery(query, Post::class.java).build()

        adapter = PostAdapter(recyclerViewOptions,this)



        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
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

        val postDao = PostDao()
        var userId: String
        var post: Post?
        GlobalScope.launch{
            post = postDao.getPostById(postId).await().toObject(Post::class.java)
            userId = post!!.createdBy.uid
            withContext(Dispatchers.Main){
                val intent = Intent(this@MainActivity,SingleUserPostsActivity::class.java)
                intent.putExtra("uid",userId)
                startActivity(intent)
            }
        }
    }
}