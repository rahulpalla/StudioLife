package com.example.studiolife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import com.example.studiolife.adapter.QuestionCardAdapter
import com.example.studiolife.databinding.ActivityMainBinding
import com.example.studiolife.databinding.EntryFormBinding
import androidx.fragment.app.Fragment
import com.example.studiolife.databinding.EntryFormFullBinding

class EntryFormActivity : AppCompatActivity() {

    private lateinit var binding: EntryFormFullBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EntryFormFullBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verticalRecyclerView.adapter = QuestionCardAdapter(
            applicationContext,
        )

        // Specify fixed size to improve performance
        binding.verticalRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}