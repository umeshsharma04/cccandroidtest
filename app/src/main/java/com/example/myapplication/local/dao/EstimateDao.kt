package com.example.myapplication.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.local.entity.Estimate

@Dao
interface EstimateDao {

    @Query("SELECT * FROM estimate")
    suspend fun getAll(): List<Estimate>

    @Insert
    suspend fun insertAll(users: List<Estimate>)

    @Delete
    suspend fun delete(user: Estimate)

    @Query("SELECT * FROM estimate WHERE contact =:id")
    fun estimateData(id: String): List<Estimate>
}