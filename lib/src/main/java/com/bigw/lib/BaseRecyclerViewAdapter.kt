package com.bigw.lib

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.bigw.lib.viewholder.BaseViewHolder

abstract class BaseRecyclerViewAdapter<ITEM, T : BaseViewHolder<*>> : RecyclerView.Adapter<T>() {
    private val mItems = ArrayList<ITEM>()

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun getItem(position: Int): ITEM {
        return mItems[position]
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearItems() {
        mItems.clear()
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearAndSetItem(item: ITEM) {
        mItems.clear()
        mItems.add(item)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearAndSetItems(newItems: List<ITEM>) {
        mItems.clear()
        mItems.addAll(newItems)
        notifyDataSetChanged()
    }

    fun appendItem(newItem: ITEM) {
        val startPosition = mItems.size
        mItems.add(newItem)
        notifyItemChanged(startPosition)
    }

    fun appendItems(newItems: List<ITEM>) {
        if (newItems.isEmpty()) {
            return
        }
        val startPosition = mItems.size
        mItems.addAll(newItems)
        notifyItemRangeChanged(startPosition, newItems.size)
    }
}