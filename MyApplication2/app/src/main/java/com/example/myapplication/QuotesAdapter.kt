package com.example.myapplication

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_item.view.*

class QuotesAdapter(private val context: Context, private val listener: IRVAdapter): RecyclerView.Adapter<QuoteViewHolder>() {

    private val items: ArrayList<Quote> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_item, parent, false)
        val viewHolder = QuoteViewHolder(view)
        view.deleteIcon.setOnClickListener{
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val currentNote = items[position]
        holder.textView.text = currentNote.text
    }
    fun updateList(newList : List<Quote>){
        items.clear()
        items.addAll(newList)

        notifyDataSetChanged()
    }

}

class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView: TextView = itemView.findViewById(R.id.TVnotePV)
}

interface IRVAdapter {
    fun onItemClicked(item: Quote)
}
