package com.bigw.lib.footer

class AutoPagerFooterItem {
    var state: FooterState = FooterState.INIT

    fun isEndState(): Boolean {
        return state == FooterState.END
    }

    fun isErrorState(): Boolean {
        return state == FooterState.ERROR
    }

    fun isLoadingState(): Boolean {
        return state == FooterState.LOADING
    }
}