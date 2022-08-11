package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(val carsCompanies: List<Companies>, private val clickListener: (Companies)->Unit) : RecyclerView.Adapter<MyViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val carCom = carsCompanies[position]
        holder.bind(carCom, clickListener)
    }

    override fun getItemCount(): Int {
        return carsCompanies.size
    }

}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun bind(carCompany: Companies, clickListener: (Companies)->Unit) {
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = carCompany.name

        view.setOnClickListener {
            clickListener(carCompany)
        }
    }
}