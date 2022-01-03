package com.example.room2.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room2.databinding.ListItemBinding
import com.example.room2.db.Customer

class MyRecyclerViewAdapter(private val customersList: List<Customer>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }

}

class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

     fun bind(customer: Customer) {
         binding.nameTextView.text = customer.name
         binding.emailTextView.text = customer.email
         binding.phoneTextView.text = customer.phoneNumber
     }
}