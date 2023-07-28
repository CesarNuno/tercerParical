package com.example.tercerparical.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tercerparical.R
import com.example.tercerparical.databinding.ItemPokemonBinding

class PokemonAdapter(val images:List<String>):RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ItemPokemonBinding.bind(view)
        fun bind(image: String){
            binding.ivPokemon.fromUrl(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon,parent,false))
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(images[position])
    }
}