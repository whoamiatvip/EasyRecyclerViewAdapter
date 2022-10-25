package com.bigw.easyrecyclerviewadapter.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bigw.lib.viewholder.BaseViewHolder
import com.bigw.lib.viewholder.ViewHolderFactory

class Line2ViewHolder(itemView: View) : BaseViewHolder<Line2>(itemView) {
    override fun onBind(position: Int, data: Line2) {
        super.onBind(position, data)
        (itemView as TextView).text = data.content
    }

    class Factory : ViewHolderFactory<Line2>() {
        override fun createViewHolder(
            parent: ViewGroup,
            inflater: LayoutInflater
        ): BaseViewHolder<Line2> {
            return Line2ViewHolder(TextView(parent.context))
        }
    }
}