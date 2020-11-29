package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class PersonModel(

    @SerializedName("id_person")
    var id_person:Int,
    @SerializedName("id")
    var id: String,
    @SerializedName("first_name")
    var first_name:String,
    @SerializedName("last_name")
    var last_name:String,
    @SerializedName("email")
    var email:String,
    @SerializedName("phone_number")
    var phone_number:String
)