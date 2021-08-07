package com.example.socialmediaapp.Daos

import com.example.socialmediaapp.Models.Post
import com.example.socialmediaapp.Models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserDao {

    private val db = FirebaseFirestore.getInstance()
    val usersCollection = db.collection("users")
//    val text = "Rehan Jutt"
//    val usersCollection = db.collection("users").whereGreaterThanOrEqualTo("displayName",)

    fun addUser(user: User?) {
        user?.let {
            GlobalScope.launch(Dispatchers.IO) {
                usersCollection.document(user.uid).set(it)
            }
        }
    }

    fun addPost(user: User,post: Post,postId: String)
    {
        GlobalScope.launch(Dispatchers.IO) {
            val userPosts = usersCollection.document(user.uid).collection("user_posts")
            userPosts.document(postId).set(post)
        }
    }

    fun getUserById(uId: String): Task<DocumentSnapshot> {
        return usersCollection.document(uId).get()
    }
}