package com.example.jobsquare


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.example.jobsquare.Entity.Category
import com.example.jobsquare.databinding.FragmentCategoryBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment() {

    private lateinit var database: DatabaseReference
    private lateinit var ref: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var loManage: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCategoryBinding>(inflater,
            R.layout.fragment_category,container,false)

        database = FirebaseDatabase.getInstance().reference

        val cateList: ArrayList<Category>  = ArrayList()
        cateList.add(Category(" Finance"))
        cateList.add(Category(" Design"))
        cateList.add(Category(" Cafe"))

        recyclerView = binding.recycleView
        recyclerView.setHasFixedSize(true)
        loManage = LinearLayoutManager(context);
        val adapter = ExAdapter(cateList)
        recyclerView.layoutManager = loManage
        recyclerView.adapter = adapter

        return binding.root
    }


}
