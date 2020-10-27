package com.genxmultiplexer.recyclerviewmvvm.network

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.genxmultiplexer.recyclerviewmvvm.R

@Database(entities = [StudentDataEntity::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {

    abstract val daoStudentInterface: StudentDaoInterface


    companion object {
        @Volatile
        private var instance: StudentDatabase? = null

        operator fun invoke(context: Context) = instance ?: synchronized(this) {
            instance ?: builderFunction(context).also {
                instance = it
            }
        }

        private fun builderFunction(context: Context): StudentDatabase {

            return Room.databaseBuilder(
                context.applicationContext,
                StudentDatabase::class.java,

                "student.db"
            ).build()
        }
    }

}




