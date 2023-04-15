package com.example.mansrusyak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupAdapter(private val groupList: ArrayList<Group>) : RecyclerView.Adapter<GroupAdapter.GroupViewHolder>() {
    class GroupViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val gName : TextView = itemView.findViewById(R.id.group)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.group_item, parent,false)
        return GroupViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return groupList.size
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.gName.text = groupList[position].group
    }
}