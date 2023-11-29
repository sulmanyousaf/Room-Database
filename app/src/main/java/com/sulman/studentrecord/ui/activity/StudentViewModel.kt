package com.sulman.studentrecord.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sulman.studentrecord.data.model.Student
import com.sulman.studentrecord.data.repo.StudentRepository
import com.sulman.studentrecord.ui.fragment.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor(private val repository: StudentRepository) : BaseViewModel() {
    val allStudents: StateFlow<List<Student>> = repository.allStudents

    fun insert(student: Student) {
        viewModelScope.launch {
            repository.insert(student)
        }
    }
}

