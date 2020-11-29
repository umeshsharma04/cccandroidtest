package com.example.myapplication.model

import java.io.Serializable
import java.util.*

data class UserModel(

    var id: Int,
    var first_name:String,
    var last_name:String,
    var email:String,
    var phone_number:String
) : Serializable