package com.manishjandu.recyclerviewdiffutilexample

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(
    private val oldList:ArrayList<ExampleItem>,
    private val newList:ArrayList<ExampleItem>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        if (oldList.javaClass != newList?.javaClass) {
            return false
        }
        if (oldList[oldItemPosition].id != newList[newItemPosition].id) {
            return false
        }
        if (oldList[oldItemPosition].imageResource != newList[newItemPosition].imageResource) {
            return false
        }
        if (oldList[oldItemPosition].title != newList[newItemPosition].title) {
            return false
        }
        if (oldList[oldItemPosition].subTitle != newList[newItemPosition].subTitle) {
            return false
        }
        return true
    }
}