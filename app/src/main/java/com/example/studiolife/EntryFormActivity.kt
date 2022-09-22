//package com.example.studiolife
//import android.os.Bundle
//import android.view.View
//import androidx.databinding.DataBindingUtil.setContentView
//import androidx.fragment.app.Fragment
//import com.example.studiolife.databinding.ActivityMainBinding
//import com.example.studiolife.databinding.EntryFormBinding
//
//class EntryFormActivity : Fragment(R.layout.entry_form) {
//
//    private lateinit var binding: EntryFormBinding
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = EntryFormBinding.bind(view)
//
//    }
//}

package com.example.studiolife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import com.example.studiolife.adapter.QuestionCardAdapter
import com.example.studiolife.databinding.ActivityMainBinding
import com.example.studiolife.databinding.EntryFormBinding
import androidx.fragment.app.Fragment

class EntryFormActivity : AppCompatActivity() {

    private lateinit var binding: EntryFormBinding

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = EntryFormBinding.bind(view)
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EntryFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.entryFormRecyclerView.adapter = QuestionCardAdapter(
            applicationContext,
        )

        // Specify fixed size to improve performance
        binding.verticalRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}