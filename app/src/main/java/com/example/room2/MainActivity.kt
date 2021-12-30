package com.example.room2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.room2.databinding.ActivityMainBinding
import com.example.room2.db.CustomerDAO
import com.example.room2.db.CustomerDatabase
import com.example.room2.repository.CustomerRepository

class MainActivity : AppCompatActivity() {

    //get the data binding object
    private lateinit var binding: ActivityMainBinding

    //reverence variable for customer ViewModel instance
    private lateinit var customerViewModel: CustomerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //create a DAO instance
        val dao: CustomerDAO = CustomerDatabase.getInstance(application).customerDAO
        val repository = CustomerRepository(dao)
        val factory = CustomerViewModelFactory(repository)
        customerViewModel = ViewModelProvider(this, factory).get(CustomerViewModel::class.java)

        //assigning the viewModel to the DataBinding Object
        binding.myViewModel = customerViewModel
        //providing a lifeCycle owner
        binding.lifecycleOwner = this

        displayCustomersList()
    }

    private fun displayCustomersList() {
         customerViewModel.customers.observe(this, Observer {
             Log.i("MYTAG", it.toString())
         })
    }
}