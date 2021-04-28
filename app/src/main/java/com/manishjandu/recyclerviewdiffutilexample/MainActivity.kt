package com.manishjandu.recyclerviewdiffutilexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.manishjandu.recyclerviewdiffutilexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        const val TAG = "MainActivity"
    }
    private lateinit var binding: ActivityMainBinding
    private val exampleList:ArrayList<ExampleItem> = generateDummyList(500)
    private val adapter = ExampleAdapter(exampleList)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        binding.rv.adapter = adapter
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)
    }


    fun insertItem(view:View){

    }
    fun removeItem(view:View){

    }
    private fun generateDummyList(size: Int): ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }
            val item = ExampleItem(drawable, "Item $i", "Line 2")
            list.add(item)
        }
        return list
    }
}