package com.example.myapplication.local

import com.example.myapplication.local.entity.Estimate
import com.example.myapplication.local.entity.Person

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getPerson(): List<Person> = appDatabase.personDao().getAll()

    override suspend fun insertAllPersons(persons: List<Person>) = appDatabase.personDao().insertAll(persons)


    override suspend fun getEstimate(): List<Estimate> = appDatabase.estimateDao().getAll()

    override suspend fun insertAllEstimate(estimates: List<Estimate>) = appDatabase.estimateDao().insertAll(estimates)
    override suspend fun getEstimateById(id: String): List<Estimate> = appDatabase.estimateDao().estimateData(id)

}