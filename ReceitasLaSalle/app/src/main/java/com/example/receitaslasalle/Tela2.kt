package com.example.receitaslasalle

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Tela2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        val recipeList = listOf(
            Recipe("Sopa de Legumes", R.drawable.sopa_legumes, "Sopa nutritiva de legumes frescos"),
            Recipe("Caldo Verde", R.drawable.caldo_verde, "Sopa tradicional portuguesa com couve e linguiça"),
            Recipe("Sopa de Cebola", R.drawable.sopa_cebola, "Sopa cremosa de cebola gratinada com queijo"),
            Recipe("Sopa de Abóbora", R.drawable.sopa_abobora, "Sopa cremosa de abóbora com gengibre"),
            Recipe("Sopa de Tomate", R.drawable.sopa_tomate, "Sopa leve de tomate com manjericão"),
            Recipe("Sopa de Lentilha", R.drawable.sopa_lentilha, "Sopa rica em proteínas e temperos"),
            Recipe("Sopa de Ervilha", R.drawable.sopa_ervilha, "Sopa cremosa de ervilha com bacon"),
            Recipe("Sopa de Frango", R.drawable.sopa_frango, "Sopa clássica de frango com vegetais"),
            Recipe("Sopa de Legumes", R.drawable.sopa_legumes, "Sopa nutritiva de legumes frescos"),
            Recipe("Caldo Verde", R.drawable.caldo_verde, "Sopa tradicional portuguesa com couve e linguiça"),
            Recipe("Sopa de Cebola", R.drawable.sopa_cebola, "Sopa cremosa de cebola gratinada com queijo"),
            Recipe("Sopa de Abóbora", R.drawable.sopa_abobora, "Sopa cremosa de abóbora com gengibre"),
            Recipe("Sopa de Tomate", R.drawable.sopa_tomate, "Sopa leve de tomate com manjericão"),
            Recipe("Sopa de Lentilha", R.drawable.sopa_lentilha, "Sopa rica em proteínas e temperos"),
            Recipe("Sopa de Ervilha", R.drawable.sopa_ervilha, "Sopa cremosa de ervilha com bacon"),
            Recipe("Sopa de Frango", R.drawable.sopa_frango, "Sopa clássica de frango com vegetais"),
            Recipe("Sopa de Legumes", R.drawable.sopa_legumes, "Sopa nutritiva de legumes frescos"),
            Recipe("Caldo Verde", R.drawable.caldo_verde, "Sopa tradicional portuguesa com couve e linguiça"),
            Recipe("Sopa de Cebola", R.drawable.sopa_cebola, "Sopa cremosa de cebola gratinada com queijo"),
            Recipe("Sopa de Abóbora", R.drawable.sopa_abobora, "Sopa cremosa de abóbora com gengibre"),
            Recipe("Sopa de Tomate", R.drawable.sopa_tomate, "Sopa leve de tomate com manjericão"),
            Recipe("Sopa de Lentilha", R.drawable.sopa_lentilha, "Sopa rica em proteínas e temperos"),
            Recipe("Sopa de Ervilha", R.drawable.sopa_ervilha, "Sopa cremosa de ervilha com bacon"),
            Recipe("Sopa de Frango", R.drawable.sopa_frango, "Sopa clássica de frango com vegetais"),
        )

        fun recipeSearch(recipeList: List<Recipe>, query: String): List<Recipe> {
            return recipeList.filter { it.name.contains(query, ignoreCase = true) }
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = RecipeAdapter(recipeList)

    }
}