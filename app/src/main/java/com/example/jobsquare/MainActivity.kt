package com.example.jobsquare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobsquare.Entity.Category
import com.example.jobsquare.databinding.ActivityMainBinding
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var ref: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var loManage: RecyclerView.LayoutManager
    var maxid: Long = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = FirebaseDatabase.getInstance().reference

        writeNewUser("1", "Restaurant & Cafe")
        writeNewUser("2", "Information Technology")
        writeNewUser("3", "Retails & Sales")
        writeNewUser("4", "Finance")
        writeNewUser("5", "Service")
        writeNewUser("6", "Design")

        val cateList: ArrayList<Category>  = ArrayList()

        ref = FirebaseDatabase.getInstance().reference.child("Category")
        val menuListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if(dataSnapshot.exists())
                    maxid = dataSnapshot.childrenCount
                for (i in 1..maxid){
                    cateList.add(Category(dataSnapshot.child((maxid).toString()).child("name").value.toString()))
                }


            }
            override fun onCancelled(databaseError: DatabaseError) {
                // handle error

            }
        }
        ref.addListenerForSingleValueEvent(menuListener)

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.setHasFixedSize(true)
        loManage = LinearLayoutManager(this);
        val adapter = ExAdapter(cateList)
        recyclerView.layoutManager = loManage
        recyclerView.adapter = adapter

    }

    private fun writeNewUser(userId: String, name: String?) {
        val user = Category(name)
        Toast.makeText(this, userId+" ${user.name}", Toast.LENGTH_LONG).show()
        database.child("Category").child(userId).setValue(user)
    }
}
