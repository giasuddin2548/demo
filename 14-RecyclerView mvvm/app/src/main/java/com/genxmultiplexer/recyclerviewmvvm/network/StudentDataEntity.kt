package com.genxmultiplexer.recyclerviewmvvm.network

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_student")
data class StudentDataEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var status: String
)