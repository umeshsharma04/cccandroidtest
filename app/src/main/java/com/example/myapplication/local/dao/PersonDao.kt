package com.example.myapplication.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.local.entity.Person


@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    suspend fun getAll(): List<Person>

    @Insert
    suspend fun insertAll(users: List<Person>)

    @Delete
    suspend fun delete(user: Person)

}