package com.example.room2.repository

import com.example.room2.db.Customer
import com.example.room2.db.CustomerDAO

class CustomerRepository(private val dao : CustomerDAO) {

    //Variable for livedata of the list of customers
    val customers = dao.getAllCustomers()

    suspend fun insert(customer: Customer) {
        dao.insertCustomer(customer)
    }

    suspend fun update(customer: Customer) {
        dao.updateCustomer(customer)
    }

    suspend fun delete(customer: Customer) {
        dao.deleteCustomer(customer)
    }

    suspend fun deleteAll(customer: Customer) {
        dao.deleteAll()
    }
}