package com.genxmultiplexer.recyclerviewmvvm.network

import android.content.Context

class Repository(private val dao: StudentDaoInterface) {

    val getAllStudent = dao.getAllStudent()

    suspend fun insertStudent(studentDataEntity: StudentDataEntity): Long {

        return dao.insert(studentDataEntity)
    }

    suspend fun updatStudent(studentDataEntity: StudentDataEntity): Int {

        return dao.update(studentDataEntity)
    }

    suspend fun deleteStudent(studentDataEntity: StudentDataEntity): Int {

        return dao.delete(studentDataEntity)
    }

    suspend fun deleteAllStudent(): Int {
        return dao.deleteAllStudent()
    }


}