/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.studiolife

import android.R.attr.data
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.studiolife.databinding.EndPageBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage


class EndActivity: AppCompatActivity() {

    private lateinit var binding: EndPageBinding
    private val resultList: ArrayList<String> = arrayListOf()
    private lateinit var storage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EndPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val optionList = intent?.getStringArrayListExtra("optionsToChoose")

        //create a Life object based on the entire list of user inputted options
        val life = Life(optionList as ArrayList<String>, resultList)
        //choose the random selection
        life.select()

        //set all the text fields to the random selections
        if (resources != null && resultList.size == 5) {
            binding.career.text = resources.getString(R.string.career_txt, resultList[0])
            binding.spouse.text = resources.getString(R.string.spouse_txt, resultList[1])
            binding.location.text =resources.getString(R.string.location_txt, resultList[2])
            binding.house.text =resources.getString(R.string.house_txt, resultList[3])
            binding.kids.text =resources.getString(R.string.kids_txt, resultList[4])
        }
// ImageView in your Activity
        val image = findViewById<ImageView>(R.id.final_img)

        storage = Firebase.storage

        // we will get the default FirebaseDatabase instance
        val firebaseDatabase = FirebaseDatabase.getInstance()
        // we will get a DatabaseReference for the database
        // root node
        val databaseReference = firebaseDatabase.reference
        // Here "image" is the child node value we are
        // getting child node data in the getImage variable
        val getImage = databaseReference.child("image")
        var storageRef = storage.reference
        storageRef.child("images/house_image.jpg").getBytes(Long.MAX_VALUE).addOnSuccessListener { metadata ->
            // Use the bytes to display the image
            var byteArr  = metadata
            val bitmap = BitmapFactory.decodeByteArray(byteArr, 0, byteArr.size)
            image.setImageBitmap(bitmap)
        }.addOnFailureListener {
            // Handle any errors
        }
//        val pathreference = storageRef.child("images/house_image.jpg")

    }
}

//class to hold user inputted choices about their life
class Life (private val optionList: ArrayList<String>, private val resultList: MutableList<String>){

    //randomly selects an option out of the three given by the user
    fun select() {

        for (i in 0 until optionList.size/3) {
            var rand: Int = (0..2).random()
            resultList.add(optionList[(i * 3) + rand])
        }

    }

}

fun main() {

    val order: MutableList<Int> = mutableListOf();
    for (i in 0..5) {
        order.add((10..25).random())
    }

    DonutOrders(order)

}

fun DonutOrders(orders: List<Int>): Boolean {
    var count = 100
   for (i in 0 until orders.size) {
         count -= orders.get(i)
         if (count < 0) {
         println("You ran out of Donuts")
         return false
         }
   }
     println("You sold " + (100 - count) + " Donuts")
    return true
}