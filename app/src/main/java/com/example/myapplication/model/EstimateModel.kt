package com.example.myapplication.model

import java.io.Serializable

data class EntityModel (
    var id: Int,
    var company:String,
    var address:String,
    var number:Int,
    var revision_number:Int,
    var created_by:String,
    var requested_by:String,
    var contact:String
):Serializable