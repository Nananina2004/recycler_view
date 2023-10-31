package com.example.recycler_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogItemAdapter
    private val dogItemList = mutableListOf<DogItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dogNames = listOf(
            "Buddy", "Max", "Charlie", "Bailey", "Lucy", "Cooper", "Leo", "Luna",
            "Sadie", "Daisy", "Rocky", "Molly", "Milo", "Roxy", "Tucker", "Oliver",
            "Rosie", "Ruby", "Lola", "Zoe"
        )

        val dogBreeds = listOf(
            "Labrador Retriever", "German Shepherd", "Golden Retriever", "Bulldog", "Beagle",
            "Poodle", "Rottweiler", "Yorkshire Terrier", "Boxer", "Dachshund",
            "Siberian Husky", "Great Dane", "Shih Tzu", "Doberman Pinscher", "Miniature Schnauzer",
            "Border Collie", "Cocker Spaniel", "Pomeranian", "Chihuahua", "French Bulldog"
        )

        for (i in 0 until 20) {
            val name = dogNames[i]
            val breed = dogBreeds[i]
            val dogItem = DogItem(name, breed)
            dogItemList.add(dogItem)
        }



    setupRecyclerView()
    }


    private fun setupRecyclerView() {
        adapter = DogItemAdapter(this, dogItemList)
        binding.dogItems.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        binding.dogItems.layoutManager = layoutManager

        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.dogItems.addItemDecoration(dividerItemDecoration)
    }
}
