package com.example.tercerparical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tercerparical.core.ApiPokemonService
import com.example.tercerparical.core.PokemonAdapter
import com.example.tercerparical.databinding.ActivityPokedexBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale

class PokedexActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    lateinit var binding: ActivityPokedexBinding
    private val imagesPokemon = mutableListOf<String>()
    private lateinit var pokemonAdapter: PokemonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svNombrePokemon.setOnQueryTextListener(this)
        initRecycler()
    }
    private fun initRecycler(){
        pokemonAdapter = PokemonAdapter(imagesPokemon)
        binding.rvImagenesPokemon.layoutManager = LinearLayoutManager(this)
        binding.rvImagenesPokemon.adapter = pokemonAdapter
    }

    private fun getRetrofit(base_url_resource:Int): Retrofit {
        return Retrofit.Builder()
            .baseUrl(resources.getString(base_url_resource))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun onQueryTextSubmit(query: String?): Boolean{
        buscarPokemonPorNombre(query!!.lowercase(Locale.getDefault()))
        return true
    }

    override fun onQueryTextChange(newText: String?):Boolean{
        return true
    }
    
    private fun buscarPokemonPorNombre(nombre:String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = getRetrofit(R.string.base_url_pokemon).create(ApiPokemonService::class.java).consultaPokemon("pokemon/$nombre")
            val pokemon = response.body()
            runOnUiThread{
                if(response.isSuccessful){
                    if(pokemon?.name != ""){
                        val list = listOf(
                            pokemon?.sprites?.back_default!!,
                            pokemon?.sprites?.back_shiny!!,
                            pokemon?.sprites?.front_default!!,
                            pokemon?.sprites?.front_shiny!!
                        )
                        imagesPokemon.clear()
                        imagesPokemon.addAll(list)
                    }else
                        imagesPokemon.clear()
                    pokemonAdapter.notifyDataSetChanged()

                }else{
                    imagesPokemon.clear()
                    pokemonAdapter.notifyDataSetChanged()
                    mostrarError()
                }
                esconderTeclado()
            }
        }
    }
    private fun mostrarError(){
        Toast.makeText(this,"Ocurrio un error, intente de nuevo", Toast.LENGTH_SHORT).show()
    }
    private fun esconderTeclado(){
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken,0)
    }
}