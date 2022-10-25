package com.bigw.easyrecyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bigw.easyrecyclerviewadapter.demo.Line1
import com.bigw.easyrecyclerviewadapter.demo.Line1ViewHolder
import com.bigw.easyrecyclerviewadapter.demo.Line2
import com.bigw.easyrecyclerviewadapter.demo.Line2ViewHolder
import com.bigw.lib.MultiTypeRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MultiTypeRecyclerViewAdapter<Any>()
        adapter.register(Line1ViewHolder.Factory())
        adapter.register(Line2ViewHolder.Factory())
        recyclerView.adapter = adapter


        val dataList = ArrayList<Any>().apply {
            add(Line1("line1"))
            add(Line1("line2"))
            add(Line1("line3"))
            add(Line2("line2_1"))
            add(Line2("line2_2"))
            add(Line2("line2_2"))
            add(Line1("line1_3"))
        }
        adapter.clearAndSetItems(dataList)
    }
}