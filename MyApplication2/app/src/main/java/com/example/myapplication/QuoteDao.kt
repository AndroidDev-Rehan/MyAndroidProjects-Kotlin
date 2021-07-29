package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Delete
    suspend fun deleteQuote(quote: Quote)

    @Query("Select * from quote")
    fun getAllQuotes(): LiveData<List<Quote>>

}