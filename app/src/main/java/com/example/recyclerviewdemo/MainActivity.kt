package com.example.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val carsCompanies = listOf<Companies>(
        Companies("Bugatti", "Germany"),
        Companies("Rolls Royce", "UK"),
        Companies("Nissan", "Japan"),
        Companies("Ferrari", "Italy"),
        Companies("McLaren", "UK"),
        Companies("Tesla", "USA")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.BLUE)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(carsCompanies) { selectedItems: Companies ->
            listItemClicked(selectedItems)
        }
    }

    private fun listItemClicked(carCompanies: Companies) {
        Toast.makeText(this, carCompanies.country, Toast.LENGTH_SHORT).show()
    }
}