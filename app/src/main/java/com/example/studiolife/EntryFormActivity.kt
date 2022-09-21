package com.example.studiolife
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.studiolife.databinding.ActivityMainBinding
import com.example.studiolife.databinding.EntryFormBinding

class EntryFormActivity : Fragment(R.layout.entry_form) {

    private lateinit var binding: EntryFormBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = EntryFormBinding.bind(view)

    }
}