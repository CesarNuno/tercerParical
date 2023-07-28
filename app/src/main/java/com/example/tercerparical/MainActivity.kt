package com.example.tercerparical

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tercerparical.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPokedex.setOnClickListener {
            startActivity(Intent(this, PokedexActivity::class.java))
        }
        binding.btnMenus.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}