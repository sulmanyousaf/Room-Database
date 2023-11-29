package com.sulman.studentrecord.ui.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sulman.studentrecord.R
import com.sulman.studentrecord.data.model.Student

class StudentAdapter : ListAdapter<Student, StudentAdapter.StudentViewHolder>(StudentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentStudent = getItem(position)
        holder.bind(currentStudent)
    }

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val studentIdTextView: TextView = itemView.findViewById(R.id.studentIdTextView)
        private val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        private val phoneNumberTextView: TextView = itemView.findViewById(R.id.phoneNumberTextView)
        private val profilePictureImageView: ImageView = itemView.findViewById(R.id.profilePictureImageView)

        fun bind(student: Student) {
            nameTextView.text = student.name
            studentIdTextView.text = student.studentId.toString()
            emailTextView.text = student.email
            phoneNumberTextView.text = student.phoneNumber ?: "N/A"

            // Set profile picture
            student.getProfilePicture()?.let {
                profilePictureImageView.setImageBitmap(it)
            }
        }
    }

    private class StudentDiffCallback : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem == newItem
        }
    }
}
