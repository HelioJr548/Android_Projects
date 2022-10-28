package com.example.blocoanotacao

import android.os.Bundle
import android.widget.EditText
import android.support.v7.app.AppCompatActivity
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar

class MainActivity : AppCompatActivity() {
    private var preferencias: AnotacaoPreferencias? = null
    private var editAnotacao: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val modoLeitura = findViewById<FloatingActionButton>(R.id.modoLeitura)
        val modoNormal = findViewById<FloatingActionButton>(R.id.modoNormal)

        val editAnotacao = findViewById<EditText>(R.id.blocoAnotacao)
        val preferencias = AnotacaoPreferencias(applicationContext)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener { view ->
            val textoRecuperado = editAnotacao.getText().toString()

//            VERIFICA SE BLOCO DE NOTAS ESTA VAZIO
            if (textoRecuperado == "") {
                Snackbar.make(
                    view, "Digite uma anotação para ser salva",
                    Snackbar.LENGTH_LONG
                ).show()
//            CASO POSSUA CONTEUDO SALVA
            } else {
                preferencias!!.salvarAnotacao(textoRecuperado)
                Snackbar.make(
                    view, "Anotação salva com sucesso",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

//        RECUPERAR A ANOTAÇÂO SALVA
        val anotacao = preferencias!!.recuperarAnotacao()
        if (anotacao != "") {
            editAnotacao.setText(anotacao)
        }

        modoLeitura.setOnClickListener {
            editAnotacao.setBackgroundColor(getResources().getColor(R.color.modoLeitura))
        }

        modoNormal.setOnClickListener {
            editAnotacao.setBackgroundColor(getResources().getColor(R.color.white))
        }

    }

}


