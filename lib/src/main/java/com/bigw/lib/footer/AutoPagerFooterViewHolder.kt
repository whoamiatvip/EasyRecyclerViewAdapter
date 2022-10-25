package com.bigw.lib.footer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bigw.lib.R
import com.bigw.lib.viewholder.BaseViewHolder
import com.bigw.lib.viewholder.ViewHolderFactory

class AutoPagerFooterViewHolder(itemView: View) : BaseViewHolder<AutoPagerFooterItem>(itemView) {
    private val mLoadingView = itemView.findViewById<ViewGroup>(R.id.group_loading)
    private val mErrorView = itemView.findViewById<View>(R.id.text_failed)
    private val mEndView = itemView.findViewById<View>(R.id.text_end)

    override fun onBind(position: Int, data: AutoPagerFooterItem) {
        super.onBind(position, data)

        mLoadingView.visibility = if (data.isLoadingState()) View.VISIBLE else View.GONE
        mErrorView.visibility = if (data.isErrorState()) View.VISIBLE else View.GONE
        mEndView.visibility = if (data.isEndState()) View.VISIBLE else View.GONE
    }

    class Factory : ViewHolderFactory<AutoPagerFooterItem>() {
        override fun createViewHolder(
            parent: ViewGroup,
            inflater: LayoutInflater
        ): BaseViewHolder<AutoPagerFooterItem> {
            val itemView = inflater.inflate(R.layout.layout_footer_view, parent, false)
            return AutoPagerFooterViewHolder(itemView)
        }
    }
}