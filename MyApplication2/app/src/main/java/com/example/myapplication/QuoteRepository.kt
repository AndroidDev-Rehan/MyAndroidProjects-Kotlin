package com.example.myapplication

import androidx.lifecycle.LiveData

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quote>> {
        return quoteDao.getAllQuotes()
    }

    suspend fun insertQuote(quote: Quote) {
        quoteDao.insertQuote(quote)
    }

    suspend fun deleteQuote(quote: Quote) {
        quoteDao.deleteQuote(quote)
    }
}