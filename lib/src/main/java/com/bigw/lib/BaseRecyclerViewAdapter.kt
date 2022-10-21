package com.bigw.lib

import androidx.recyclerview.widget.RecyclerView
import com.bigw.lib.viewholder.BaseViewHolder

abstract class BaseRecyclerViewAdapter : RecyclerView.Adapter<BaseViewHolder>() {
    private val mItems = ArrayList<Any>()

    override fun getItemCount(): Int {
        return mItems.size
    }
}