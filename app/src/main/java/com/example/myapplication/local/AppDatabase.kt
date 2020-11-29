package com.example.myapplication.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.local.dao.EstimateDao
import com.example.myapplication.local.dao.PersonDao
import com.example.myapplication.local.entity.Estimate
import com.example.myapplication.local.entity.Person

@Database(entities = [Person::class,Estimate::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao
    abstract fun estimateDao() : EstimateDao
}