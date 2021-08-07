package com.example.socialmediaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialmediaapp.Daos.UserDao
import com.example.socialmediaapp.Models.Post
import com.example.socialmediaapp.Models.User
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*
import java.util.*

class SearchActivity : AppCompatActivity(), ISearchAdapter {
    private lateinit var userDao: UserDao
    private lateinit var adapter: SearchAdapter
    private var listening : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

//        setUpRecyclerView("ll")
        searchIcon2.setOnClickListener{
            val text = searchText.text.toString()

//            Toast.makeText(applicationContext,"BUTTON WORKS!!!!!!!",Toast.LENGTH_LONG).show()
            if (text!="") {
                setUpRecyclerView(text)
                adapter.startListening()
                listening = true
            }
        }


    }
    private fun setUpRecyclerView(text : String) {
        userDao = UserDao()
        val usersCollections = userDao.usersCollection
        //val query = usersCollections.orderBy("displayName", Query.Direction.DESCENDING)

//        val query1 = usersCollections.whereGreaterThanOrEqualTo("displayName",text)

        val query2 = usersCollections.whereGreaterThanOrEqualTo("displayName",
            text.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() })

        val recyclerViewOptions = FirestoreRecyclerOptions.Builder<User>().setQuery(query2, User::class.java).build()

        adapter = SearchAdapter(recyclerViewOptions,this)



        SearchRecyclerView.adapter = adapter
        SearchRecyclerView.layoutManager = LinearLayoutManager(this)
//        Toast.makeText(applicationContext,"Trying to show things!!",Toast.LENGTH_LONG).show()
    }

//    override fun onStart() {
//        super.onStart()
//        adapter.startListening()
//    }

//    override fun onStop() {
//        super.onStop()
//        adapter.stopListening()
//    }

    override fun onDestroy() {
        super.onDestroy()
        if (listening)
        adapter.stopListening()
    }



    override fun onItemClicked(postId: String) {
        Toast.makeText(applicationContext,"NOT YET IMPLEMENTED!!!!!!!",Toast.LENGTH_LONG).show()
    }




}