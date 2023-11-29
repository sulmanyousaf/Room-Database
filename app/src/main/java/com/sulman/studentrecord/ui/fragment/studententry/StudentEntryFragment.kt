package com.sulman.studentrecord.ui.fragment.studententry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.sulman.studentrecord.R
import com.sulman.studentrecord.data.model.Student
import com.sulman.studentrecord.databinding.FragmentStudentEntryBinding
import com.sulman.studentrecord.ui.activity.StudentViewModel
import com.sulman.studentrecord.ui.fragment.base.fragment.BaseFragmentVMBP
import com.sulman.studentrecord.utils.extensions.navigateBack
import com.sulman.studentrecord.utils.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StudentEntryFragment : BaseFragmentVMBP<FragmentStudentEntryBinding,StudentViewModel>(
    FragmentStudentEntryBinding::inflate,
    StudentViewModel::class.java
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddStudent.setOnClickListener {
            viewModel.showLoader()
            val name = binding.etName.text.toString()
            val studentId = binding.etStudentId.text.toString().toIntOrNull() ?: 0
            val email = binding.etEmail.text.toString()
            val phoneNumber = binding.etPhoneNumber.text.toString().takeIf { it.isNotEmpty() }
//            val profilePicture = null // You can handle profile picture input here

            val student = Student(name = name, studentId = studentId, email = email, phoneNumber = phoneNumber)

            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.insert(student)
                    showToast("Data Entered Successfully.")
                    binding.etName.text.clear()
                    binding.etStudentId.text.clear()
                    binding.etEmail.text.clear()
                    binding.etPhoneNumber.text.clear()
                    viewModel.hideLoader()
                }
            }
        }

        binding.btnShowAllStudent.setOnClickListener {
            findNavController().navigate(R.id.action_studentEntryFragment_to_studentListFragment)
        }
    }

    override fun onBackPressed() {
        navigateBack()
    }


}
