package com.sulman.studentrecord.di

import android.content.Context
import androidx.room.Room
import com.sulman.studentrecord.data.db.StudentDatabase
import com.sulman.studentrecord.data.repo.StudentRepository
import com.sulman.studentrecord.room.StudentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideStudentDatabase(@ApplicationContext context: Context): StudentDatabase {
        return Room.databaseBuilder(
            context,
            StudentDatabase::class.java,
            "student_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideStudentDao(database: StudentDatabase): StudentDao {
        return database.studentDao()
    }

    @Provides
    @Singleton
    fun provideRepository(studentDao: StudentDao): StudentRepository {
        return StudentRepository(studentDao)
    }
}
