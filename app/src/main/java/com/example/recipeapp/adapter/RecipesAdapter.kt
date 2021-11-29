package com.example.recipeapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeapp.DetailActivity
import com.example.recipeapp.data.Recipes
import com.example.recipeapp.databinding.RowItemRecipeBinding

class RecipesAdapter(private val listRecipe: ArrayList<Recipes>) :
    RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RowItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            with(listRecipe[position]) {
                tvNameRecipe.text = name
                tvCategory.text = category
                tvPrice.text = price
                Glide.with(imgRecipe.context).load(photo).into(imgRecipe)
                holder.itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.RECIPES_DATA, listRecipe[position])
                    it.context.startActivity(intent)
                }

            }
        }
    }

    override fun getItemCount(): Int = listRecipe.size
}