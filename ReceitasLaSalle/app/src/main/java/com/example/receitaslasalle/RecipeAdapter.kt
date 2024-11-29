package com.example.receitaslasalle

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

data class Recipe(
    val name: String,
    val imageResourceId: Int,
    val description: String,
    val ingredients: String = "",
    val steps: String = "",
    val time: String = ""
)

class RecipeAdapter(private var listRecipe: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeItemHolder>() {
    var onItemClick: ((Recipe) -> Unit)? = null


    class RecipeItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeName: TextView = itemView.findViewById(R.id.tvRecipeName)
        var recipeImage: ImageView = itemView.findViewById(R.id.imageView)
        var recipeDescription: TextView = itemView.findViewById(R.id.tvRecipeDescription)
        val recipeIngredients: TextView = itemView.findViewById(R.id.ingredients)
        val recipeSteps: TextView = itemView.findViewById(R.id.modoPreparo)
        val recipeTime: TextView = itemView.findViewById(R.id.tempo)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_receita, parent, false)
        return RecipeItemHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listRecipe.size
    }

    override fun onBindViewHolder(holder: RecipeItemHolder, position: Int) {
        val recipe = listRecipe[position]
        holder.recipeName.text = recipe.name
        holder.recipeImage.setImageResource(recipe.imageResourceId)
        holder.recipeDescription.text = recipe.description
        holder.recipeIngredients.text = recipe.ingredients
        holder.recipeSteps.text = recipe.steps
        holder.recipeTime.text = recipe.time

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                recipe.name,
                Toast.LENGTH_SHORT
            ).show()
            var intent = Intent(holder.itemView.context, focused_recipe::class.java)
            intent.putExtra("RECIPE_NAME", recipe.name)
            intent.putExtra("RECIPE_DESC", recipe.description)
            intent.putExtra("RECIPE_IMAGE", recipe.imageResourceId)
            intent.putExtra("RECIPE_INGREDIENTS", recipe.ingredients)
            intent.putExtra("RECIPE_STEPS", recipe.steps)
            intent.putExtra("RECIPE_TIME", recipe.time)
            holder.itemView.context.startActivity(intent)
            onItemClick?.invoke(listRecipe[position])
        }


    }

}