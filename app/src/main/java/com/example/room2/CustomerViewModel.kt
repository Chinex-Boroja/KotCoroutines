package com.example.room2

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.room2.repository.CustomerRepository

class CustomerViewModel(private val repository: CustomerRepository) : ViewModel() {
    @Bindable
    val inputName = MutableLiveData<String>()
    @Bindable
    val inputEmail = MutableLiveData<String>()
    @Bindable
    val inputPhoneNumber = MutableLiveData<String>()
}