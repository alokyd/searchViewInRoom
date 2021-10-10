package com.example.searchViewInRoom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.searchViewInRoom.adapter.MyAdapter
import com.example.searchViewInRoom.data.Person
import com.example.searchViewInRoom.databinding.ActivityMainBinding
import com.example.searchViewInRoom.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    /*
    as you can see this is my main activity and
    here I have created view binding for binding our views
     */
    private lateinit var binding: ActivityMainBinding

    // here i have initialized our mainViewModel
    private val mainViewModel: MainViewModel by viewModels()
    // and recycler view adapter
    private val myAdapter: MyAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // here i am using linear layout manager for our recyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //here i am setting my recyclerView to custom adapter that i have already made
        binding.recyclerView.adapter = myAdapter

        // here i am observing data by mainViewModel using readData variable
        mainViewModel.readData.observe(this, {
            // using custom recyclerView adapter i have set the data to our recycler view
            myAdapter.setData(it)
        })

    }
}














