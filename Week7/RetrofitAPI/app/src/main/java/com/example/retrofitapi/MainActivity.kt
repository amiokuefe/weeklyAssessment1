package com.example.retrofitapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitapi.activity.StudentAddActivity
import com.example.retrofitapi.databinding.ActivityMainBinding
import com.example.retrofitapi.view.ItemAdapter
import com.example.retrofitapi.view.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, StudentAddActivity::class.java)
            startActivity(intent)
        }

        itemAdapter = ItemAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.itemRecycler.adapter = itemAdapter

        viewModel.getItems()
        viewModel.itemsLiveData.observe(this, { items ->
            itemAdapter.items = items
            itemAdapter.notifyDataSetChanged()
        })
    }
}