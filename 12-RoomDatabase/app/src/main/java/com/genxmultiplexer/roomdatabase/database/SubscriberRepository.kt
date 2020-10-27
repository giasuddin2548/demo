package com.genxmultiplexer.roomdatabase.database

class SubscriberRepository(private val dao:DaoInterface) {


    val getAllSubscriber=dao.getAllSubscriber()

    suspend fun insertSubs(subscriberEntity: SubscriberEntity):Long{

       return dao.insertSubscriber(subscriberEntity)
    }

    suspend fun updateSubs(subscriberEntity: SubscriberEntity):Int{
      return  dao.updateSubscriber(subscriberEntity)
    }

    suspend fun deleteSubs(subscriberEntity: SubscriberEntity):Int{
       return dao.deleteSubscriber(subscriberEntity)
    }

    suspend fun deleteAllSubs():Int{
       return dao.deleteAllSubscriber()
    }



}