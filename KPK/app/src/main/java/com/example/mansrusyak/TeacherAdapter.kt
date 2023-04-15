package com.example.mansrusyak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TeacherAdapter(private val teacherList: ArrayList<Teacher>, ) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    class TeacherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val lastName : TextView = itemView.findViewById(R.id.lastName)
        val firstName : TextView = itemView.findViewById(R.id.FirstName)
        val surName : TextView = itemView.findViewById(R.id.SurName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.teacher_item, parent,false)
        return TeacherViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return teacherList.size
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.lastName.text = teacherList[position].lastname
        holder.firstName.text = teacherList[position].firstname
        holder.surName.text = teacherList[position].surname
    }
}