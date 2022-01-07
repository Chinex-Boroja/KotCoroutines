package com.example.room2

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room2.db.Customer
import com.example.room2.repository.CustomerRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CustomerViewModel(private val repository: CustomerRepository) : ViewModel(), Observable  {
    val customers = repository.customers


    @Bindable
    val inputName = MutableLiveData<String?>()
    @Bindable
    val inputEmail = MutableLiveData<String?>()
    @Bindable
    val inputPhoneNumber = MutableLiveData<String?>()
    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()
    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }
    fun saveOrUpdate() {
        val name : String = inputName.value!!
        val email : String = inputEmail.value!!
        val number : String = inputPhoneNumber.value!!

        insert(Customer(0, name, email, number))

        inputName.value = null
        inputEmail.value = null
        inputPhoneNumber.value = null

    }
    fun clearAllOrDelete() {
        clearAll()
    }

    //function to insert a customer
    fun insert(customer: Customer): Job = viewModelScope.launch {
        repository.insert(customer)
    }

    //function to update a customer
    fun update(customer: Customer): Job = viewModelScope.launch {
        repository.update(customer)

    }
    //function to delete a customer
    fun delete(customer: Customer): Job = viewModelScope.launch {
        repository.delete(customer)

    }
    //function to delete all customers
    fun clearAll(): Job = viewModelScope.launch {
        repository.deleteAll()

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}