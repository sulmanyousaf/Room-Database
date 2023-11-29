package com.sulman.studentrecord.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sulman.studentrecord.data.model.Student
import com.sulman.studentrecord.room.StudentDao

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}