package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var quoteRepository: QuoteRepository

    init {
        val dao = QuoteRoomDatabase.getDatabase(application).quoteDao()
        quoteRepository = QuoteRepository(dao)
    }

    fun getQuotes(): LiveData<List<Quote>> {
        return quoteRepository.getQuotes()
    }

    fun insertQuote(quote: Quote) {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.insertQuote(quote)
        }
    }

    fun deletetQuote(quote: Quote) {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.deleteQuote(quote)
        }
    }

}