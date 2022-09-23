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

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studiolife.databinding.EndPageBinding

class EndActivity: AppCompatActivity() {

    private lateinit var binding: EndPageBinding
    private lateinit var listIntent: Intent
    private val resultList: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EndPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val optionList = listIntent.getStringArrayListExtra("optionsToChoose")

        val life = Life(optionList as ArrayList<String>, resultList)
        life.select()

        if (resources != null && resultList.size == 5) {
            resources.getString(R.string.career_txt, resultList[0])
            resources.getString(R.string.spouse_txt, resultList[1])
            resources.getString(R.string.location_txt, resultList[2])
            resources.getString(R.string.house_txt, resultList[3])
            resources.getString(R.string.kids_txt, resultList[4])
        }
    }
}

class Life (private val optionList: ArrayList<String>, private val resultList: MutableList<String>){

    fun select() {

        for (i in 0..(optionList.size/3)) {
            var rand: Int = (0..2).random()
            resultList.add(optionList[i*rand])
        }
    }

}