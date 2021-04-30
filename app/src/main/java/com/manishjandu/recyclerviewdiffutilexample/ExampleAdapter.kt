package com.manishjandu.recyclerviewdiffutilexample

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.manishjandu.recyclerviewdiffutilexample.MainActivity.Companion.TAG
import com.manishjandu.recyclerviewdiffutilexample.databinding.ActivityMainBinding
import com.manishjandu.recyclerviewdiffutilexample.databinding.ExampleItemBinding

class ExampleAdapter() :
    RecyclerView.Adapter<ExampleAdapter.ExampleAdapterViewHolder>() {
    private val oldExampleList: ArrayList<ExampleItem> = ArrayList()

    fun submitList(newItemsList: ArrayList<ExampleItem>) {
        Log.i(TAG,"old ${oldExampleList.size}")
        Log.i(TAG,"new ${newItemsList.size}")
        val diffUtil = MyDiffUtil(this.oldExampleList,newItemsList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil,false)
        oldExampleList.clear()
        oldExampleList.addAll(newItemsList)
        diffUtilResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleAdapterViewHolder {
        val binding = ExampleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExampleAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExampleAdapterViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = oldExampleList.size


    inner class ExampleAdapterViewHolder(binding: ExampleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val imageView: ImageView = binding.ivIcon
        private val title: TextView = binding.tvTitle
        private val subTitle: TextView = binding.tvSubTitle

        fun bind(position: Int) {
            val item = oldExampleList[position]
            imageView.setImageResource(item.imageResource)
            title.text = item.title
            subTitle.text = item.subTitle
        }
    }
}