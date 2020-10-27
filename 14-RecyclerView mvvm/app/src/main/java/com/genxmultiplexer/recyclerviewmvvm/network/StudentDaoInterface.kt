package com.genxmultiplexer.recyclerviewmvvm.network

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDaoInterface {

    @Insert
    suspend fun insert(studentDataEntity: StudentDataEntity): Long

    @Update
    suspend fun update(studentDataEntity: StudentDataEntity): Int

    @Delete
    suspend fun delete(studentDataEntity: StudentDataEntity): Int

    @Query("delete from tbl_student")
    suspend fun deleteAllStudent(): Int

    @Query("SELECT * FROM tbl_student ORDER BY id")
    fun getAllStudent(): LiveData<List<StudentDataEntity>>
}