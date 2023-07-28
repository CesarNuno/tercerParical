package com.example.tercerparical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tercerparical.core.PokemonAdapter
import com.example.tercerparical.databinding.ActivityConsumoApiBinding
import retrofit2.Retrofit

class ConsumoApiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConsumoApiBinding
    private val imagesPokemon = mutableListOf<String>()
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsumoApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}