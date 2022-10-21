package com.bigw.easyrecyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bigw.easyrecyclerviewadapter.demo.Line1
import com.bigw.easyrecyclerviewadapter.demo.Line1ViewHolder
import com.bigw.lib.MultiTypeRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MultiTypeRecyclerViewAdapter<Any>()
        adapter.register(Line1ViewHolder.Factory())
        recyclerView.adapter = adapter


        val dataList = ArrayList<Line1>().apply {
            add(Line1("line1"))
            add(Line1("line2"))
            add(Line1("line3"))
        }
        adapter.clearAndSetItems(dataList)
    }
}