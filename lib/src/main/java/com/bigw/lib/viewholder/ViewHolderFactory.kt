package com.bigw.lib.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import java.lang.reflect.Modifier
import java.lang.reflect.ParameterizedType

abstract class ViewHolderFactory<Item : Any> {
    abstract fun createViewHolder(parent: ViewGroup, inflater: LayoutInflater): BaseViewHolder<Item>

    @Suppress("UNCHECKED_CAST")
    fun getGenericType(): Class<Item> {
        val clz = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<Item>
        checkClassType(clz)
        return clz
    }

    private fun checkClassType(clz: Class<*>) {
        if (clz.isInterface) {
            throw IllegalStateException("interface is not supported here: $clz")
        }
        if (Modifier.isAbstract(clz.modifiers)) {
            throw IllegalStateException("abstract class is not supported here: $clz")
        }
        if (clz.isArray) {
            throw IllegalStateException("array is not supported here: $clz")
        }
        if (Map::class.java.isAssignableFrom(clz) || Iterable::class.java.isAssignableFrom(clz)) {
            throw IllegalStateException("map or iterable is not supported here: $clz")
        }
    }
}