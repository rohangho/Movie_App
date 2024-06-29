package com.example.myapplication.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.viewmodel.HomeViewModel
import com.example.myapplication.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val  homeViewModel by viewModels<HomeViewModel>()
    private lateinit var  recyclerView:RecyclerView
    private var adapter: Adapter = Adapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.now_playing)
        recyclerView.adapter = adapter
        recyclerView.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                true
            )
        )
        homeViewModel.getData()
        observerViewModel()
    }

    private fun observerViewModel() {
        homeViewModel.getMovieList.observe(this) {
            adapter.updateData(it.data.results)
        }
    }
}