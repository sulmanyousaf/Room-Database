package com.sulman.studentrecord.ui.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sulman.studentrecord.R
import com.sulman.studentrecord.data.model.Student
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    private lateinit var studentViewModel: StudentViewModel
//    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
//        adapter = StudentAdapter()

        // Set up RecyclerView (assuming you have a RecyclerView in your layout with the id "recyclerView")
        // Set up RecyclerView
//        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = adapter

        // Observe the StateFlow from the ViewModel using lifecycleScope.launchWhenStarted
//        lifecycleScope.launch {
//            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                studentViewModel.allStudents.collect { students ->
//                    // Update the RecyclerView with the list of students
//                    adapter.submitList(students)
//                }
//            }
//        }

//        // Get the drawable resource ID
//        val drawableResourceId = R.drawable.ic_preview
//
//        // Convert the drawable to Bitmap
//        val profilePictureBitmap: Bitmap = BitmapFactory.decodeResource(resources, drawableResourceId)

        // Insert dummy data (you can replace this with user input)
//        val student = Student(name = "John Doe", studentId = 123, email = "john@example.com")
//        // Set the profile picture
////        student.setProfilePicture(profilePictureBitmap)
//        // Insert the student into the database
//        studentViewModel.insert(student)
//
//
//        val student2 = Student(name = "sulman", studentId = 123, email = "john@example.com")
//        // Set the profile picture
////        student2.setProfilePicture(profilePictureBitmap)
//        studentViewModel.insert(student2)
    }
}
