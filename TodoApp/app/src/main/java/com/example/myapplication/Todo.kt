package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "tid", defaultValue = "null")
    val tid:Int?=null,
    val todo:String,
    @ColumnInfo(name = "checked", defaultValue = "false")
    val cheked:Boolean
)