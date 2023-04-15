package com.example.mansrusyak

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class GroupActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var groupList: ArrayList<Group>
    private var db = Firebase.firestore

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        recyclerView = findViewById(R.id.groupRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        groupList = arrayListOf()

        db = FirebaseFirestore.getInstance()

        db.collection("groups").get().addOnSuccessListener {
            if(!it.isEmpty){
                for(data in it.documents){
                    val group:Group? = data.toObject(Group::class.java)
                    if (group != null) {
                        groupList.add(group)
                    }
                }
                recyclerView.adapter = GroupAdapter(groupList)
            }
        }
            .addOnFailureListener{
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }
    }
}