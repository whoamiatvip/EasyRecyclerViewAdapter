package com.bigw.lib.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T : Any>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    open fun onBind(position: Int, data: T) {}
}