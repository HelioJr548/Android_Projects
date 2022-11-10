package com.example.java_kotlin

import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import com.example.java_kotlin.R
import android.content.SharedPreferences
import android.view.View
import android.widget.Button
import com.example.java_kotlin.MainActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//    private lateinit var btnSalvar: Button? = null
//    private lateinit var txtNome: EditText? = null
//    private lateinit var lblResultado: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var txtNome = findViewById<EditText>(R.id.txtNome)
        var btnSalvar = findViewById<Button>(R.id.btnSalvar)
        var lblResultado = findViewById<TextView>(R.id.lblResultado)
        btnSalvar.setOnClickListener(View.OnClickListener {
            val preferences = getSharedPreferences(ARQUIVO_REFENCIA, 0)
            val editor = preferences.edit()

//                VALIDAR NOME
            if (txtNome.getText().toString() == "") {
                Toast.makeText(
                    applicationContext,
                    "Por favor, preencher seu nome",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val nome = txtNome.getText().toString()
                editor.putString("nome", nome)
                editor.commit()
                lblResultado.setText("olá $nome")
            }
        })

//        RECUPERAR DADOS SALVOS
        val preferences = getSharedPreferences(ARQUIVO_REFENCIA, 0)
        if (preferences.contains("nome")) {
            val nome = preferences.getString("nome", "\" Olá, usuário não defenido")
            lblResultado.setText("Olá $nome")
        } else {
            lblResultado.setText("Olá, usuário não definido")
        }
    }

    companion object {
        private const val ARQUIVO_REFENCIA = "ArquivoPreferencia"
    }
}
