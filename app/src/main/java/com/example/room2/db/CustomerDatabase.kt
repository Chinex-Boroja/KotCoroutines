package com.example.room2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Customer::class], version = 1)
abstract class CustomerDatabase : RoomDatabase() {
    //A reference for the DAO interface
    abstract val customerDAO : CustomerDAO

    //Create a Singleton to avoid multiple instances of database
    companion object{
        @Volatile
        private var INSTANCE : CustomerDatabase? = null
        fun getInstance(context: Context):CustomerDatabase {
            synchronized(this) {
                var instance: CustomerDatabase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CustomerDatabase::class.java,
                        "customer_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}