package com.example.testrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var vm : MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewModel = vm
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        // Set listener
        // binding.tvAddItem.setOnClickListener(this)
        // binding.btnSubmit.setOnClickListener(this)
    }
}