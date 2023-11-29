package com.sulman.studentrecord.data.repo

import com.sulman.studentrecord.data.model.Student
import com.sulman.studentrecord.room.StudentDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StudentRepository @Inject constructor(
    private val studentDao: StudentDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val _allStudents = MutableStateFlow<List<Student>>(emptyList())
    val allStudents: StateFlow<List<Student>> = _allStudents.asStateFlow()

    init {
        observeStudentsFromDao()
    }

    private fun observeStudentsFromDao() {
        CoroutineScope(ioDispatcher).launch {
            studentDao.getAllStudentsFlow().collect { students ->
                _allStudents.value = students
            }
        }
    }

    suspend fun insert(student: Student) {
        withContext(ioDispatcher) {
            studentDao.insertStudent(student)
        }
    }
}



