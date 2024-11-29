package com.example.receitaslasalle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG : String = "FIREBASE"
    }

    lateinit var user: EditText
    lateinit var pass: EditText
    lateinit var loginButton: Button
    lateinit var cadastroButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        user = findViewById(R.id.userid)
        pass = findViewById(R.id.pass)
        loginButton = findViewById(R.id.loginButton)
        cadastroButton = findViewById(R.id.cadastroButton)

        cadastroButton.setOnClickListener {
            var intent = Intent(applicationContext, cadastro::class.java)
            startActivity(intent)
        }


        loginButton.setOnClickListener {
            if (user.text.toString() != "qualquercoisaqualquercoisa" &&
                pass.text.toString() != "qualquercoisaqualquercoisa"){


            }
        }

    }

    fun loginFireabase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    goToList()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }

    fun goToList() {
        val intent = Intent(applicationContext, Tela2::class.java)
        startActivity(intent)
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            goToList()
        }
    }
}