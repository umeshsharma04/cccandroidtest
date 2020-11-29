package com.example.myapplication.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity
data class Estimate(

    @PrimaryKey(autoGenerate = true)
    val id_estimate: Int,
    @ColumnInfo(name = "company")
    val company: String?,
    @ColumnInfo(name = "address")
    val address: String?,

    @ColumnInfo(name = "number")
    val number: Int?,
    @ColumnInfo(name = "revision_number")
    val revision_number: Int?,


    @ColumnInfo(name = "created_date")
  //  @TypeConverters(TimestampConverter::class)
    val created_date: String,

    @ColumnInfo(name = "created_by")
    val created_by: String?,
    @ColumnInfo(name = "requested_by")
    val requested_by: String?,
    @ColumnInfo(name = "contact")
    val contact: String?,

    )