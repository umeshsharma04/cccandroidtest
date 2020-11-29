package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class EstimateModel (
    @SerializedName("id")
    var id: Int,
    @SerializedName("company")
    var company:String,

    @SerializedName("address")
    var address:String,

    @SerializedName("number")
    var number:Int,
    @SerializedName("revision_number")
    var revision_number:Int,

    @SerializedName("created_by")
    var created_by:String,
    @SerializedName("created_date")
//    @TypeConverters(TimestampConverter::class)
    var created_date: String,
    @SerializedName("requested_by")
    var requested_by:String,
    @SerializedName("contact")
    var contact:String
)