package com.example.testrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.databinding.ListStudentItemBinding

val studentList : ObservableArrayList<Student> = ObservableArrayList()

class MainActivityViewModel : ViewModel()
{
    var studentAdapter : StudentAdapter = StudentAdapter()

    fun onAdd() {
        studentList.add(Student())
        studentAdapter.notifyItemInserted(studentList.size-1)
        Log.d("onAdd","OK")
    }

    fun onSubmitClick()
    {
        studentList.forEachIndexed { index, student ->
            Log.d("<RESULT>", "Name : ${student.name} - Score : ${student.score} - Index : ${index}" )
        }
        Log.d("onSubmitClick","OK")
    }
}

class StudentAdapter() : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(private val binding: ListStudentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.student = student
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(
            ListStudentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }
}