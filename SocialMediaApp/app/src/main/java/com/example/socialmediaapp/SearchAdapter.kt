package com.example.socialmediaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.socialmediaapp.Models.Post
import com.example.socialmediaapp.Models.User
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SearchAdapter(options: FirestoreRecyclerOptions<User>, private val listener: ISearchAdapter ) : FirestoreRecyclerAdapter<User, SearchAdapter.SearchViewHolder>(
    options
) {

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.SearchResult)
        val userImage: ImageView = itemView.findViewById(R.id.SuserImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        val viewHolder =  SearchViewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(snapshots.getSnapshot(viewHolder.adapterPosition).id)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int, model: User) {
        holder.userName.text = model.displayName
        Glide.with(holder.userImage.context).load(model.imageUrl).circleCrop().into(holder.userImage)

    }
}

interface ISearchAdapter {
    fun onItemClicked(postId: String)
}
