package com.example.room2.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CustomerDAO {

    //insert customer object to the database
    @Insert
    suspend fun insertCustomer(customer: Customer)

    //update customer object to the database
    @Update
    suspend fun updateCustomer(customer: Customer)

    //delete customer object to the database
    @Delete
    suspend fun deleteCustomer(customer: Customer)

    @Query("DELETE  FROM customer_data_table")
    suspend fun deleteAll()

    //get all the customers as LiveData
    @Query("SELECT * FROM customer_data_table")
    fun getAllCustomers(): LiveData<List<Customer>>

}