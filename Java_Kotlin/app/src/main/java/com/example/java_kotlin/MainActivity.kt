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
    /*private var btnSalvar: Button? = null
    private var txtNome: EditText? = null
    private var txtSobNome: EditText? = null
    private var lblResultado: TextView? = null*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var txtNome = findViewById<EditText>(R.id.txtNome)
        var txtSobNome = findViewById<EditText>(R.id.txtSobNome)
        var btnSalvar = findViewById<Button>(R.id.btnSalvar)
        var lblResultado = findViewById<TextView>(R.id.lblResultado)
        btnSalvar.setOnClickListener(View.OnClickListener {
            val preferences = getSharedPreferences(ARQUIVO_REFENCIA, 0)
            val editor = preferences.edit()

//                VALIDAR NOME
            if (txtNome.getText().toString() == "" || txtSobNome.getText().toString() == "") {
                Toast.makeText(
                    applicationContext,
                    "Atenção, Nome ou Sobrenome vazios.\nPor favor preencha-o(s)",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val nome = txtNome.getText().toString()
                editor.putString("nome", nome)
                val sobnome = txtSobNome.getText().toString()
                editor.putString("sobnome", sobnome)
                editor.commit()
                lblResultado.setText("Seja Bem-vindo(a)\n$nome $sobnome")
            }
        })

//        RECUPERAR DADOS SALVOS
        val preferences = getSharedPreferences(ARQUIVO_REFENCIA, 0)
        if (preferences.contains("nome")) {
            val nome = preferences.getString("nome", "\" Olá, usuário não defenido")
            val sobnome = preferences.getString("sobnome", "\" Olá, usuário não defenido")
            lblResultado.setText("Seja Bem-vindo(a)\n$nome $sobnome")
        } else {
            lblResultado.setText("Olá, usuário não definido")
        }
    }

    companion object {
        private const val ARQUIVO_REFENCIA = "ArquivoPreferencia"
    }
}