package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteRoomDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao

    companion object {
        private var INSTANCE: QuoteRoomDatabase? = null
        fun getDatabase(context: Context): QuoteRoomDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        QuoteRoomDatabase::class.java,
                        "quote_database"
                    )
                        //.createFromAsset("quotes.db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}