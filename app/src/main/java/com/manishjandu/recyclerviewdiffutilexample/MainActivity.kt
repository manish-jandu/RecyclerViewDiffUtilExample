package com.manishjandu.recyclerviewdiffutilexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.manishjandu.recyclerviewdiffutilexample.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    companion object{
        const val TAG = "MainActivity"
        var size = 500
    }
    private lateinit var binding: ActivityMainBinding
    private val exampleList:ArrayList<ExampleItem> = generateDummyList(size)
    private val adapter by lazy { ExampleAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)


        binding.rv.adapter = adapter
        adapter.submitList(exampleList)
        binding.rv.layoutManager = LinearLayoutManager(this)

    }


    fun insertItem(view:View){
        val index = Random.nextInt(8)
        val newItem = ExampleItem(
            "${size++}",
            R.drawable.ic_android,
            "New item at position $index",
            "Line 2"
        )
        exampleList.add(index,newItem)
    }
    fun removeItem(view:View){
        val index = Random.nextInt(8)
        exampleList.removeAt(index)
    }
    private fun generateDummyList(size: Int): ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }
            val item = ExampleItem("$i",drawable, "Item $i", "Line 2")
            list.add(item)
        }
        return list
    }
}