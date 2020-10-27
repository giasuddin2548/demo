package com.genxmultiplexer.roomdatabase.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DaoInterface {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubscriber(subscriberEntity: SubscriberEntity): Long

    @Update
    suspend fun updateSubscriber(subscriberEntity: SubscriberEntity):Int

    @Delete
    suspend fun deleteSubscriber(subscriberEntity: SubscriberEntity) :Int

    @Query("delete from tbl_subscriber")
    suspend fun deleteAllSubscriber():Int

    @Query("select * from tbl_subscriber order by  sub_id")
    fun getAllSubscriber(): LiveData<List<SubscriberEntity>>



}