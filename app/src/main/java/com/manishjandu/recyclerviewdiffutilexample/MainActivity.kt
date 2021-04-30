package com.manishjandu.recyclerviewdiffutilexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.manishjandu.recyclerviewdiffutilexample.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
        var size = 5
    }

    private lateinit var binding: ActivityMainBinding
    private val exampleList: ArrayList<ExampleItem> = generateDummyList(size)
    private val adapter by lazy { ExampleAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)


        binding.rv.adapter = adapter
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)


        adapter.submitList(exampleList)

        binding.btnInsertItem.setOnClickListener {
            val newItem = ExampleItem(
                "$size",
                R.drawable.ic_android,
                "New item at position $size",
                "Second Line $size"
            )
            size++
            exampleList.add(newItem)
            //Log.i(TAG, "example list size ${exampleList.size}")
            adapter.submitList(exampleList)
        }
        binding.btnRemoveItem.setOnClickListener {
            if(exampleList.isNotEmpty()){
                exampleList.removeAt(0)
            }
            adapter.submitList(exampleList)
        }
    }

    private fun generateDummyList(size: Int): ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }
            val item = ExampleItem("$i", drawable, "Item $i", "Second Line $i")
            list.add(item)
        }
        return list
    }
}