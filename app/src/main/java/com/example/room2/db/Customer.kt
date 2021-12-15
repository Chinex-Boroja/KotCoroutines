package com.example.room2.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Annotate the class with Entity Annotation
@Entity(tableName = "customer_data_table")

//An Entity class to manage the Customer
data class Customer(

    //Set the primary of theTable and set the auto generate as true
    @PrimaryKey(autoGenerate = true)

    /**Use ColumnInfo to specify the name of the member variable in the Table*/
    @ColumnInfo(name = "customer_id")
    val id : Int,

    @ColumnInfo(name = "customer_name")
    val name : String,

    @ColumnInfo(name = "customer_email")
    val email : String,

    @ColumnInfo(name = "customer_phoneNumber")
    val phoneNumber: String
) {}