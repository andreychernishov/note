package com.example.moneynote.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moneynote.InfoAdapter

@Database (entities = [BaseItem::class], version = 1)
abstract class MainDb: RoomDatabase() {

    abstract fun getDao(): Dao

    companion object{
        fun getDb(context: Context): MainDb {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java,
                "note.db"
            ).build()
        }


    }
}