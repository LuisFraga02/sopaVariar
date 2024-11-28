package com.example.receitaslasalle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var user : EditText
    lateinit var pass : EditText
    lateinit var loginButton : Button
    lateinit var cadastroButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = findViewById(R.id.userid)
        pass = findViewById(R.id.pass)
        loginButton = findViewById(R.id.loginButton)
        cadastroButton = findViewById(R.id.cadastroButton)

        cadastroButton.setOnClickListener{
            var intent = Intent(applicationContext, cadastro::class.java)
            startActivity(intent)
        }


        loginButton.setOnClickListener{
            var intent = Intent(applicationContext, Tela2::class.java)
            startActivity(intent)
//            if (user.text.toString() != "qualquercoisaqualquercoisa" &&
//                pass.text.toString() != "qualquercoisaqualquercoisa"){
//                Toast.makeText(this,"entrando como "+user.text.toString(),Toast.LENGTH_LONG).show()
//                var intent = Intent(applicationContext, Tela2::class.java)
//                startActivity(intent)
//            }
        }

    }
}