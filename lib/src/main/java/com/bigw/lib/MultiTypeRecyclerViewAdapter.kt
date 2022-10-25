package com.bigw.lib

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bigw.lib.viewholder.BaseViewHolder
import com.bigw.lib.viewholder.ViewHolderFactory

open class MultiTypeRecyclerViewAdapter<ITEM : Any> : BaseRecyclerViewAdapter<ITEM, BaseViewHolder<ITEM>>() {

    private val mViewTypes = arrayListOf<ViewTypeHolder<ITEM>>()

    fun register(factory: ViewHolderFactory<out ITEM>) {
        val clz = factory.getGenericType()
        //check duplicate register
        val previous = mViewTypes.firstOrNull { it.factory.getGenericType() == clz }
        if (previous != null) {
            throw IllegalAccessException("duplicate register, clz:$clz")
        }
        val newType = ViewTypeHolder(factory, mViewTypes.size + 1)
        mViewTypes.add(newType)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ITEM> {
        val viewTypeHolder = mViewTypes.firstOrNull { it.viewType == viewType }
        if (viewTypeHolder != null) {
            val inflater = LayoutInflater.from(parent.context)
            return viewTypeHolder.factory.createViewHolder(parent, inflater) as BaseViewHolder<ITEM>
        }
        throw IllegalAccessException("not found view type, viewType:$viewType")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ITEM>, position: Int) {
        holder.onBind(position, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        val item = super.getItem(position)
        val viewTypeHolder = mViewTypes.firstOrNull { it.factory.getGenericType() == item::class.java }
        if (viewTypeHolder != null) {
            return viewTypeHolder.viewType
        }
        throw IllegalAccessException("not found viewType with position:$position, clz:${item::class.java}")
    }

    private class ViewTypeHolder<T : Any>(
        val factory: ViewHolderFactory<out T>,
        val viewType: Int
    )

    companion object {
        private const val TAG = "MultiTypeAdapter"
    }
}