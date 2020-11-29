package com.example.myapplication.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(

        @PrimaryKey(autoGenerate = true) val id_person: Int,
        @ColumnInfo(name = "id") val id: String?,
        @ColumnInfo(name = "first_name") val first_name: String?,
        @ColumnInfo(name = "last_name") val last_name: String?,
        @ColumnInfo(name = "email") val email: String?,
        @ColumnInfo(name = "phone_number") val phone_number: String?) {

}