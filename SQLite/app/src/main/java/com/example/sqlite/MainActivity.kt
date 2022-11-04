package com.example.sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
//            CRIAR DB
            val bd = openOrCreateDatabase("copa", MODE_PRIVATE, null)

//            CRIAR TABELA COM AUTOINCREMENT
            bd.execSQL(
                "CREATE TABLE IF NOT EXISTS jogosCopa " +
                        "(jogo INTEGER PRIMARY KEY AUTOINCREMENT, info VARCHAR, " +
                        "data VARCHAR, selecao VARCHAR, rival VARCHAR, placar VARCHAR)"
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}