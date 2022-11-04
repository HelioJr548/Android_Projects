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

//            INSERT DE DADOS
            bd.execSQL(
                "INSERT INTO jogosCopa (info, data, selecao, rival, placar) " +
                        "VALUES ('Amistoso', '23/09/2022', 'Brasil', 'Gana', '3x0')"
            )

            bd.execSQL(
                "INSERT INTO jogosCopa (info, data, selecao, rival, placar) " +
                        "VALUES ('Amistoso', '27/09/2022', 'Brasil', 'Tunísia', '5x1')"
            )


            bd.execSQL(
                "INSERT INTO jogosCopa (info, data, selecao, rival, placar) " +
                        "VALUES ('Cerimonia de Abertura da Copa', '20/11/2022', 'Qatar', 'Equador', '2x1')"
            )


            bd.execSQL(
                "INSERT INTO jogosCopa (info, data, selecao, rival, placar) " +
                        "VALUES ('Fase de Grupos', '24/11/2022', 'Brasil', 'Sérvia', '4x0')"
            )

            bd.execSQL(
                "INSERT INTO jogosCopa (info, data, selecao, rival, placar) " +
                        "VALUES ('Fase de Grupos', '28/11/2022', 'Brasil', 'Suíça', '3x1')"
            )

            bd.execSQL(
                "INSERT INTO jogosCopa (info, data, selecao, rival, placar) " +
                        "VALUES ('Fase de Grupos', '02/12/2022', 'Brasil', 'Camarões', '5x0')"
            )

            bd.execSQL(
                "INSERT INTO jogosCopa (info, data, selecao, rival, placar) " +
                        "VALUES ('Oitavas de final', '06/12/2022', 'Brasil', 'Portugal', '2x0')"
            )

            bd.execSQL(
                "INSERT INTO jogosCopa (info, data, selecao, rival, placar) " +
                        "VALUES ('Quartas de final', '10/12/2022', 'Brasil', 'Alemanha', '2x1')"
            )

            bd.execSQL(
                "INSERT INTO jogosCopa (info, data, selecao, rival, placar) " +
                        "VALUES ('Semifinais', '14/12/2022', 'Brasil', 'Argentina', '3x1')"
            )

            bd.execSQL(
                "INSERT INTO jogosCopa (info, data, selecao, rival, placar) " +
                        "VALUES ('Final', '18/12/2022', 'Brasil', 'Inglaterra', '3x1')"
            )

//            RECUPERAR DADOS
            val cursor = bd.rawQuery("SELECT * FROM jogosCopa ORDER BY jogo ASC", null)

/*
//            UPDATE
            bd.execSQL("UPDATE jogosCopa SET info = 'BRASIL CAMPEÃO' WHERE info = 'Final'")
*/

//            CAPTURA DE DADOS
            val jogo = cursor.getColumnIndex("jogo")
            val info = cursor.getColumnIndex("info")
            val data = cursor.getColumnIndex("data")
            val selecao = cursor.getColumnIndex("selecao")
            val rival = cursor.getColumnIndex("rival")
            val placar = cursor.getColumnIndex("placar")

//            APRESENTAR DADOS
            cursor.moveToFirst()
            while (cursor != null) {
                Log.i(
                    "RESULTADO ", "ID: " + cursor.getString(jogo) +
                            "| INFO: " + cursor.getString(info) +
                            "| DATA: " + cursor.getString(data) +
                            "| SELEÇÃO: " + cursor.getString(selecao) +
                            "| RIVAL: " + cursor.getString(rival) +
                            "| PLACAR: " + cursor.getString(placar)
                )
                cursor.moveToNext()
            }

/*
//            APAGAR TABELA
            bd.execSQL("DROP TABLE jogosCopa")
*/

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}