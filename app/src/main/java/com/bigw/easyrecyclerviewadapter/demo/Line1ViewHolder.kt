package com.bigw.easyrecyclerviewadapter.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bigw.lib.viewholder.BaseViewHolder
import com.bigw.lib.viewholder.ViewHolderFactory

class Line1ViewHolder(itemView: View) : BaseViewHolder<Line1>(itemView) {

    override fun onBind(position: Int, data: Line1) {
        super.onBind(position, data)
        (itemView as TextView).text = data.line
    }

    class Factory : ViewHolderFactory<Line1>() {
        override fun createViewHolder(parent: ViewGroup, inflater: LayoutInflater): BaseViewHolder<Line1> {
            return Line1ViewHolder(TextView(parent.context))
        }
    }
}