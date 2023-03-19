package com.example.filmsmvvm.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.filmsmvvm.R
import com.example.filmsmvvm.databinding.ActivityMainBinding
import com.example.filmsmvvm.presentation.fragments.fragments.FeedFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = FeedFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}