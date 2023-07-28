package com.example.tercerparical.core

import com.example.tercerparical.responses.data.pokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiPokemonService {
    @GET
    suspend fun consultaPokemon(@Url url:String):Response<pokemonResponse>
}