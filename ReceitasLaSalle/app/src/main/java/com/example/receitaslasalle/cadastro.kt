package com.example.receitaslasalle

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.receitaslasalle.databinding.ActivityCadastroBinding

class cadastro : AppCompatActivity() {
    private lateinit var binding : ActivityCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.CadastrarButton.setOnClickListener{
            Toast.makeText(this, binding.CadastrarNome.text.toString(), Toast.LENGTH_SHORT).show()
            Toast.makeText(this, binding.CadastrarPass.text.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}