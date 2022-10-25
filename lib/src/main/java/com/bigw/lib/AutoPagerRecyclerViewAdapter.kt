package com.bigw.lib

import com.bigw.lib.footer.AutoPagerFooterItem
import com.bigw.lib.footer.AutoPagerFooterViewHolder
import com.bigw.lib.footer.FooterState

class AutoPagerRecyclerViewAdapter : MultiTypeRecyclerViewAdapter<Any>() {
    private var mCurrPage: Int = 1
    private var mPageSize: Int = DEFAULT_PAGE_SIZE

    private var mEnableFooter = false
    private val mFooterItem = AutoPagerFooterItem()

    init {
        register(AutoPagerFooterViewHolder.Factory())
    }

    val footerEnable
        get() = mEnableFooter

    fun enableFooter(enable: Boolean) {
        if (mEnableFooter == enable) {
            return
        }
        if (enable) {
            appendItem(mFooterItem)
        } else {
            //removeItem()
        }
    }

    fun resetPageIndex() {
        mCurrPage = 1
    }

    fun setFooterState(s: FooterState) {
    }

    companion object {
        private const val DEFAULT_PAGE_SIZE = 15
    }
}