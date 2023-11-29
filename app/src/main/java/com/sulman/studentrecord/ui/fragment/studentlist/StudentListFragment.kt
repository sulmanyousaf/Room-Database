package com.sulman.studentrecord.ui.fragment.studentlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sulman.studentrecord.databinding.FragmentStudentEntryBinding
import com.sulman.studentrecord.databinding.FragmentStudentListBinding
import com.sulman.studentrecord.ui.activity.StudentAdapter
import com.sulman.studentrecord.ui.activity.StudentViewModel
import com.sulman.studentrecord.ui.fragment.base.fragment.BaseFragmentVMBP
import com.sulman.studentrecord.utils.extensions.navigateBack
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StudentListFragment : BaseFragmentVMBP<FragmentStudentListBinding, StudentViewModel>(
    FragmentStudentListBinding::inflate,
    StudentViewModel::class.java
) {
    private val adapter = StudentAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.allStudents.collect { students ->
                    // Update the RecyclerView with the list of students
                    adapter.submitList(students)
                }
            }
        }
    }

    override fun onBackPressed() {
        navigateBack()
    }
}
