package com.genxmultiplexer.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SubscriberEntity::class], version = 1)
abstract class RoomDbClass : RoomDatabase() {


    abstract val getSubscriberDao: DaoInterface

    companion object {


        @Volatile
        private var INSTANCE: RoomDbClass? = null


        operator fun invoke(context: Context) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }


        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RoomDbClass::class.java,
            "subscriber.db"
        ).build()


        /*

     operator fun invoke(context: Context): RoomDatabase? {

          synchronized(this){

              var instance:RoomDatabase?=null
              if (instance==null){

                  instance=Room.databaseBuilder(
                      context.applicationContext,
                      RoomDbClass::class.java,
                      "subscriber.db"
                  ).build()



              }
              return instance

          }



      }




      private fun buildDatabase(context: Context) = Room.databaseBuilder(
          context.applicationContext,
          RoomDbClass::class.java,
          "subscriber.db"
      ).build()




      operator fun invoke(context: Context) = instance ?: synchronized(lock) {
          instance ?: buildDatabase(context).also {
              instance = it
          }
      }




      private fun buildDatabase(context: Context) = Room.databaseBuilder(
          context.applicationContext,
          RoomDbClass::class.java,
          "subscriber.db"
      ).build()

       */


    }


}