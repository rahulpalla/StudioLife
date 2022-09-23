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
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.example.studiolife.QuestionCardAdapter
import com.example.studiolife.databinding.EntryFormBinding
import com.example.studiolife.databinding.EntryFormFullBinding

class EntryFormActivity : AppCompatActivity() {

    private lateinit var binding: EntryFormFullBinding
    private lateinit var listIntent: Intent
    private val myData: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EntryFormFullBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.continueRBtn.setOnClickListener{ launchEndPage() }

        binding.verticalRecyclerView.adapter = QuestionCardAdapter(
            applicationContext,
            myData
        )

        // Specify fixed size to improve performance
        binding.verticalRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    private fun launchEndPage() {
        listIntent = Intent(this, EndActivity::class.java)
        listIntent.putStringArrayListExtra("data_list", myData)
        startActivity(listIntent)
    }
}
