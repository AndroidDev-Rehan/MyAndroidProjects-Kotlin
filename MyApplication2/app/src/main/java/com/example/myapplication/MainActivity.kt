package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IRVAdapter {
//    lateinit var binding: ActivityMainBinding




    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapterrr = QuotesAdapter(this,this)
        recyclerView.adapter = adapterrr

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)

        mainViewModel.getQuotes().observe(this, Observer {list->
            list?.let {
                adapterrr.updateList(it)
            }

        })



        button.setOnClickListener {
            val quote = Quote(0, ETQuote.text.toString(),"testing")
            ETQuote.text.clear()
            mainViewModel.insertQuote(quote)

        }
    }

    override fun onItemClicked(quote: Quote) {
    mainViewModel.deletetQuote(quote)

    }
}