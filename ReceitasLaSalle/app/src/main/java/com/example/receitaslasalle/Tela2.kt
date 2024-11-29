package com.example.receitaslasalle

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.receitaslasalle.databinding.ActivityCadastroBinding
import com.example.receitaslasalle.databinding.ActivityTela2Binding
import java.util.Timer
import java.util.TimerTask

class Tela2 : AppCompatActivity() {
    private lateinit var binding: ActivityTela2Binding

    //    private var timer: Timer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTela2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var recipeList = listOf(
            Recipe(
                "Sopa de Legumes",
                R.drawable.sopa_legumes,
                "Sopa nutritiva de legumes frescos",
                "1 cebola 2 dentes de alho 1 cenoura 1 courgette 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos, a cenoura e a courgette. Pique a cebola e os alhos e corte a cenoura e a courgette em cubos. Leve ao lume um tacho com o azeite, a cebola e os alhos. Deixe refogar até a cebola ficar macia. Junte a cenoura e a courgette. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Caldo Verde",
                R.drawable.caldo_verde,
                "Sopa tradicional portuguesa com couve e linguiça",
                "meio kg de batata uma cebola média 2 dentes de alho 1 folha de louro 1/2 chouriço 1/2 couve galega 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque as batatas, a cebola e os alhos. Corte as batatas em cubos e pique a cebola e os alhos. Leve ao lume um tacho com o azeite, a cebola, os alhos e a folha de louro. Deixe refogar até a cebola ficar macia. Junte as batatas e a água. Tempere com sal e pimenta. Deixe cozer durante 20 minutos. Retire a folha de louro e triture tudo com a varinha mágica. Corte a couve em juliana fina e junte ao creme. Deixe cozer durante 10 minutos. Corte o chouriço em rodelas e junte à sopa. Deixe ferver durante 5 minutos. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Cebola",
                R.drawable.sopa_cebola,
                "Sopa cremosa de cebola gratinada com queijo",
                "4 cebolas médias 2 colheres de sopa de manteiga 1 colher de sopa de azeite 1 colher de sopa de farinha 1,5l de caldo de carne 1/2 copo de vinho branco 4 fatias de pão 100g de queijo ralado sal q.b. pimenta q.b.",
                "Descasque as cebolas e corte-as em rodelas finas. Leve ao lume um tacho com a manteiga e o azeite. Deixe aquecer e junte as cebolas. Deixe refogar até a cebola ficar macia. Polvilhe com a farinha e mexa. Junte o caldo de carne e o vinho branco. Tempere com sal e pimenta. Deixe cozer durante 20 minutos. Corte o pão em cubos e coloque-os num tabuleiro. Polvilhe com o queijo ralado e leve ao forno a gratinar. Sirva a sopa com os croutons de pão e queijo.",
                "40 min"
            ),
            Recipe(
                "Sopa de Abóbora",
                R.drawable.sopa_abobora,
                "Sopa cremosa de abóbora com gengibre",
                "1 kg de abóbora 1 cebola 2 dentes de alho 1 pedaço de gengibre 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a abóbora, a cebola, os alhos e o gengibre. Corte a abóbora em cubos e pique a cebola, os alhos e o gengibre. Leve ao lume um tacho com o azeite, a cebola, os alhos e o gengibre. Deixe refogar até a cebola ficar macia. Junte a abóbora e a água. Tempere com sal e pimenta. Deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Tomate",
                R.drawable.sopa_tomate,
                "Sopa leve de tomate com manjericão",
                "1 kg de tomate 1 cebola 2 dentes de alho 1 folha de louro 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos e os tomates. Pique a cebola e os alhos e corte os tomates em cubos. Leve ao lume um tacho com o azeite, a cebola, os alhos e a folha de louro. Deixe refogar até a cebola ficar macia. Junte os tomates. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Lentilha",
                R.drawable.sopa_lentilha,
                "Sopa rica em proteínas e temperos",
                "1 chávena de lentilhas 1 cebola 2 dentes de alho 1 cenoura 1 folha de louro 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos e a cenoura. Pique a cebola e os alhos e corte a cenoura em cubos. Leve ao lume um tacho com o azeite, a cebola, os alhos e a folha de louro. Deixe refogar até a cebola ficar macia. Junte a cenoura e as lentilhas. Tempere com sal e pimenta. Junte a água e deixe cozer durante 30 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Ervilha",
                R.drawable.sopa_ervilha,
                "Sopa cremosa de ervilha com bacon",
                "1 cebola 2 dentes de alho 1 cenoura 1 courgette 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos, a cenoura e a courgette. Pique a cebola e os alhos e corte a cenoura e a courgette em cubos. Leve ao lume um tacho com o azeite, a cebola e os alhos. Deixe refogar até a cebola ficar macia. Junte a cenoura e a courgette. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Frango",
                R.drawable.sopa_frango,
                "Sopa clássica de frango com vegetais",
                "1 peito de frango 1 cebola 2 dentes de alho 1 cenoura 1 courgette 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos, a cenoura e a courgette. Pique a cebola e os alhos e corte a cenoura e a courgette em cubos. Leve ao lume um tacho com o azeite, a cebola e os alhos. Deixe refogar até a cebola ficar macia. Junte o peito de frango e deixe cozinhar durante 10 minutos. Junte a cenoura e a courgette. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Retire o frango e desfie-o. Triture os legumes com a varinha mágica. Junte o frango desfiado e deixe ferver durante 5 minutos. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Legumes",
                R.drawable.sopa_legumes,
                "Sopa nutritiva de legumes frescos",
                "1 cebola 2 dentes de alho 1 cenoura 1 courgette 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos, a cenoura e a courgette. Pique a cebola e os alhos e corte a cenoura e a courgette em cubos. Leve ao lume um tacho com o azeite, a cebola e os alhos. Deixe refogar até a cebola ficar macia. Junte a cenoura e a courgette. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Caldo Verde",
                R.drawable.caldo_verde,
                "Sopa tradicional portuguesa com couve e linguiça",
                "meio kg de batata uma cebola média 2 dentes de alho 1 folha de louro 1/2 chouriço 1/2 couve galega 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque as batatas, a cebola e os alhos. Corte as batatas em cubos e pique a cebola e os alhos. Leve ao lume um tacho com o azeite, a cebola, os alhos e a folha de louro. Deixe refogar até a cebola ficar macia. Junte as batatas e a água. Tempere com sal e pimenta. Deixe cozer durante 20 minutos. Retire a folha de louro e triture tudo com a varinha mágica. Corte a couve em juliana fina e junte ao creme. Deixe cozer durante 10 minutos. Corte o chouriço em rodelas e junte à sopa. Deixe ferver durante 5 minutos. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Cebola",
                R.drawable.sopa_cebola,
                "Sopa cremosa de cebola gratinada com queijo",
                "4 cebolas médias 2 colheres de sopa de manteiga 1 colher de sopa de azeite 1 colher de sopa de farinha 1,5l de caldo de carne 1/2 copo de vinho branco 4 fatias de pão 100g de queijo ralado sal q.b. pimenta q.b.",
                "Descasque as cebolas e corte-as em rodelas finas. Leve ao lume um tacho com a manteiga e o azeite. Deixe aquecer e junte as cebolas. Deixe refogar até a cebola ficar macia. Polvilhe com a farinha e mexa. Junte o caldo de carne e o vinho branco. Tempere com sal e pimenta. Deixe cozer durante 20 minutos. Corte o pão em cubos e coloque-os num tabuleiro. Polvilhe com o queijo ralado e leve ao forno a gratinar. Sirva a sopa com os croutons de pão e queijo.",
                "40 min"
            ),
            Recipe(
                "Sopa de Abóbora",
                R.drawable.sopa_abobora,
                "Sopa cremosa de abóbora com gengibre",
                "1 kg de abóbora 1 cebola 2 dentes de alho 1 pedaço de gengibre 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a abóbora, a cebola, os alhos e o gengibre. Corte a abóbora em cubos e pique a cebola, os alhos e o gengibre. Leve ao lume um tacho com o azeite, a cebola, os alhos e o gengibre. Deixe refogar até a cebola ficar macia. Junte a abóbora e a água. Tempere com sal e pimenta. Deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Tomate",
                R.drawable.sopa_tomate,
                "Sopa leve de tomate com manjericão",
                "1 kg de tomate 1 cebola 2 dentes de alho 1 folha de louro 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos e os tomates. Pique a cebola e os alhos e corte os tomates em cubos. Leve ao lume um tacho com o azeite, a cebola, os alhos e a folha de louro. Deixe refogar até a cebola ficar macia. Junte os tomates. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Lentilha",
                R.drawable.sopa_lentilha,
                "Sopa rica em proteínas e temperos",
                "1 chávena de lentilhas 1 cebola 2 dentes de alho 1 cenoura 1 folha de louro 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos e a cenoura. Pique a cebola e os alhos e corte a cenoura em cubos. Leve ao lume um tacho com o azeite, a cebola, os alhos e a folha de louro. Deixe refogar até a cebola ficar macia. Junte a cenoura e as lentilhas. Tempere com sal e pimenta. Junte a água e deixe cozer durante 30 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Ervilha",
                R.drawable.sopa_ervilha,
                "Sopa cremosa de ervilha com bacon",
                "1 cebola 2 dentes de alho 1 cenoura 1 courgette 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos, a cenoura e a courgette. Pique a cebola e os alhos e corte a cenoura e a courgette em cubos. Leve ao lume um tacho com o azeite, a cebola e os alhos. Deixe refogar até a cebola ficar macia. Junte a cenoura e a courgette. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Frango",
                R.drawable.sopa_frango,
                "Sopa clássica de frango com vegetais",
                "1 peito de frango 1 cebola 2 dentes de alho 1 cenoura 1 courgette 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos, a cenoura e a courgette. Pique a cebola e os alhos e corte a cenoura e a courgette em cubos. Leve ao lume um tacho com o azeite, a cebola e os alhos. Deixe refogar até a cebola ficar macia. Junte o peito de frango e deixe cozinhar durante 10 minutos. Junte a cenoura e a courgette. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Retire o frango e desfie-o. Triture os legumes com a varinha mágica. Junte o frango desfiado e deixe ferver durante 5 minutos. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Legumes",
                R.drawable.sopa_legumes,
                "Sopa nutritiva de legumes frescos",
                "1 cebola 2 dentes de alho 1 cenoura 1 courgette 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos, a cenoura e a courgette. Pique a cebola e os alhos e corte a cenoura e a courgette em cubos. Leve ao lume um tacho com o azeite, a cebola e os alhos. Deixe refogar até a cebola ficar macia. Junte a cenoura e a courgette. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Caldo Verde",
                R.drawable.caldo_verde,
                "Sopa tradicional portuguesa com couve e linguiça",
                "meio kg de batata uma cebola média 2 dentes de alho 1 folha de louro 1/2 chouriço 1/2 couve galega 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque as batatas, a cebola e os alhos. Corte as batatas em cubos e pique a cebola e os alhos. Leve ao lume um tacho com o azeite, a cebola, os alhos e a folha de louro. Deixe refogar até a cebola ficar macia. Junte as batatas e a água. Tempere com sal e pimenta. Deixe cozer durante 20 minutos. Retire a folha de louro e triture tudo com a varinha mágica. Corte a couve em juliana fina e junte ao creme. Deixe cozer durante 10 minutos. Corte o chouriço em rodelas e junte à sopa. Deixe ferver durante 5 minutos. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Cebola",
                R.drawable.sopa_cebola,
                "Sopa cremosa de cebola gratinada com queijo",
                "4 cebolas médias 2 colheres de sopa de manteiga 1 colher de sopa de azeite 1 colher de sopa de farinha 1,5l de caldo de carne 1/2 copo de vinho branco 4 fatias de pão 100g de queijo ralado sal q.b. pimenta q.b.",
                "Descasque as cebolas e corte-as em rodelas finas. Leve ao lume um tacho com a manteiga e o azeite. Deixe aquecer e junte as cebolas. Deixe refogar até a cebola ficar macia. Polvilhe com a farinha e mexa. Junte o caldo de carne e o vinho branco. Tempere com sal e pimenta. Deixe cozer durante 20 minutos. Corte o pão em cubos e coloque-os num tabuleiro. Polvilhe com o queijo ralado e leve ao forno a gratinar. Sirva a sopa com os croutons de pão e queijo.",
                "40 min"
            ),
            Recipe(
                "Sopa de Abóbora",
                R.drawable.sopa_abobora,
                "Sopa cremosa de abóbora com gengibre",
                "1 kg de abóbora 1 cebola 2 dentes de alho 1 pedaço de gengibre 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a abóbora, a cebola, os alhos e o gengibre. Corte a abóbora em cubos e pique a cebola, os alhos e o gengibre. Leve ao lume um tacho com o azeite, a cebola, os alhos e o gengibre. Deixe refogar até a cebola ficar macia. Junte a abóbora e a água. Tempere com sal e pimenta. Deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Tomate",
                R.drawable.sopa_tomate,
                "Sopa leve de tomate com manjericão",
                "1 kg de tomate 1 cebola 2 dentes de alho 1 folha de louro 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos e os tomates. Pique a cebola e os alhos e corte os tomates em cubos. Leve ao lume um tacho com o azeite, a cebola, os alhos e a folha de louro. Deixe refogar até a cebola ficar macia. Junte os tomates. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Lentilha",
                R.drawable.sopa_lentilha,
                "Sopa rica em proteínas e temperos",
                "1 chávena de lentilhas 1 cebola 2 dentes de alho 1 cenoura 1 folha de louro 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos e a cenoura. Pique a cebola e os alhos e corte a cenoura em cubos. Leve ao lume um tacho com o azeite, a cebola, os alhos e a folha de louro. Deixe refogar até a cebola ficar macia. Junte a cenoura e as lentilhas. Tempere com sal e pimenta. Junte a água e deixe cozer durante 30 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Ervilha",
                R.drawable.sopa_ervilha,
                "Sopa cremosa de ervilha com bacon",
                "1 cebola 2 dentes de alho 1 cenoura 1 courgette 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos, a cenoura e a courgette. Pique a cebola e os alhos e corte a cenoura e a courgette em cubos. Leve ao lume um tacho com o azeite, a cebola e os alhos. Deixe refogar até a cebola ficar macia. Junte a cenoura e a courgette. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Triture tudo com a varinha mágica. Sirva a sopa quente.",
                "40 min"
            ),
            Recipe(
                "Sopa de Frango",
                R.drawable.sopa_frango,
                "Sopa clássica de frango com vegetais",
                "1 peito de frango 1 cebola 2 dentes de alho 1 cenoura 1 courgette 1,5l de água 1/2 dl de azeite sal q.b. pimenta q.b.",
                "Descasque a cebola, os alhos, a cenoura e a courgette. Pique a cebola e os alhos e corte a cenoura e a courgette em cubos. Leve ao lume um tacho com o azeite, a cebola e os alhos. Deixe refogar até a cebola ficar macia. Junte o peito de frango e deixe cozinhar durante 10 minutos. Junte a cenoura e a courgette. Tempere com sal e pimenta. Junte a água e deixe cozer durante 20 minutos. Retire o frango e desfie-o. Triture os legumes com a varinha mágica. Junte o frango desfiado e deixe ferver durante 5 minutos. Sirva a sopa quente.",
                "40 min"
            ),
        )
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = RecipeAdapter(recipeList)
        binding.btnPesquisar.setOnClickListener {
            val pesquisa = binding.pesquisa.text.toString()
            val newList = recipeList.filter { it.name.contains(pesquisa, ignoreCase = true) }
            recyclerView.adapter = RecipeAdapter(newList)
        }
        //se a pesquisa esta em branca ele volta a lista original
//        timer = Timer()
//        timer?.schedule(object : TimerTask() {
//            override fun run() {
//                if (binding.pesquisa.text.isEmpty()) {
//                    runOnUiThread {
//                        recyclerView.adapter = RecipeAdapter(recipeList)
//                    }
//                }
//            }
//        }, 250, 250)


        val adapter = RecipeAdapter(recipeList)
        recyclerView.adapter = adapter

//        adapter.onItemClick = {
//
//            recipe ->
//            Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, focused_recipe::class.java)
//            intent.putExtra("RECIPE_NAME", recipe.name)
//            intent.putExtra("RECIPE_DESC", recipe.description)
//            intent.putExtra("RECIPE_IMAGE", recipe.imageResourceId)
//            intent.putExtra("RECIPE_INGREDIENTS", recipe.ingredients)
//            intent.putExtra("RECIPE_STEPS", recipe.steps)
//            intent.putExtra("RECIPE_TIME", recipe.time)
//
//            startActivity(intent)
//        }


    }
}