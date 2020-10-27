package com.genxmultiplexer.roomdatabase.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_subscriber")
data class SubscriberEntity(
    @PrimaryKey(autoGenerate = true)
    var sub_id: Int,
    var sub_name: String,
    var sub_email: String
) {
}