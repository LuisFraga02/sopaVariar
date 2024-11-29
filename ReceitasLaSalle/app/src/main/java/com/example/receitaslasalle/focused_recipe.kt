package com.example.receitaslasalle

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class focused_recipe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_focused_recipe)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val name = intent.getStringExtra("RECIPE_NAME")
        val description = intent.getStringExtra("RECIPE_DESC")
        val imageResource = intent.getIntExtra("RECIPE_IMAGE", 0)
        val ingredients = intent.getStringExtra("RECIPE_INGREDIENTS")
        val modoPreparo = intent.getStringExtra("RECIPE_STEPS")
        val tempo = intent.getStringExtra("RECIPE_TIME")

// Atualize os elementos visuais com esses dados
        findViewById<TextView>(R.id.name).text = name
        findViewById<TextView>(R.id.descricao2).text = description
        findViewById<ImageView>(R.id.image).setImageResource(imageResource)
        findViewById<TextView>(R.id.ingredients).text = ingredients
        findViewById<TextView>(R.id.modoPreparo).text = modoPreparo
        findViewById<TextView>(R.id.tempo).text = tempo


    }
}