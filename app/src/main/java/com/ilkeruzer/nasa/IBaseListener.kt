package com.ilkeruzer.nasa

interface IBaseListener {

    interface Adapter<T> {

        fun onItemClick(item: T, position: Int)
        fun onLoadMore(itemCount: Int)

    }

}