package com.example.myapplication.local

import com.example.myapplication.local.entity.Estimate
import com.example.myapplication.local.entity.Person

interface DatabaseHelper {

    suspend fun getPerson(): List<Person>

    suspend fun insertAllPersons(users: List<Person>)

    suspend fun getEstimate():List<Estimate>
    suspend fun insertAllEstimate(estimate: List<Estimate>)
    suspend fun getEstimateById(id:String):List<Estimate>;

}