package com.example.aposentadoria

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_Sexo = findViewById<Spinner>(R.id.spn_Sexo)
        val txt_Idade = findViewById<EditText>(R.id.txt_Idade)
        val txt_Contribuicao = findViewById<EditText>(R.id.txt_Contribuicao)
        val btn_Calcular = findViewById<Button>(R.id.btn_Calcular)
        val txt_Resultado = findViewById<TextView>(R.id.txt_Resultado)

        spn_Sexo.adapter = ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino", "Feminino")
        )


        //btn_Calcular_onclick
        btn_Calcular.setOnClickListener {
            //Verifica se campo de idade esta vazio
            if (txt_Idade.text.isEmpty() && txt_Contribuicao.text.isEmpty()) {
                txt_Idade.error = "Adicione sua idade!"
                txt_Contribuicao.error = "Adicione seu tempo de contribuição"
            } else if (txt_Idade.text.isEmpty() && txt_Contribuicao.text.isNotEmpty()) {
                txt_Idade.error = "Adicione sua idade!"
            } else if (txt_Idade.text.isNotEmpty() && txt_Contribuicao.text.isEmpty()) {
                txt_Contribuicao.error = "Adicione seu tempo de contribuição"
            } else {
                val sexo = spn_Sexo.selectedItem as String
                val idade = txt_Idade.text.toString().toInt()
                val cont = txt_Contribuicao.text.toString().toInt()

                val idm = 65    ;   val idf = 62
                val ptm = 105   ;   val ptf = 100
                var tApos: Int  ;   var ptApos = 1
                val contribuido = idade + cont

                //Verifica se tem idade para aposentar
                if (idade < 14 && cont > 0) {
                    txt_Idade.error = "Idade precisa ser maior que 14"
                    txt_Contribuicao.error = "Menores de 14 anos não podem contribuir"
                } else if (idade < 14 && cont == 0) {
                    txt_Idade.error = "Idade precisa ser maior que 14"
                } else if (sexo == "Masculino") {
                    tApos = idm - idade
                    ptApos = ptm - contribuido
                    if (idade < idm && contribuido < ptm) {
                        txt_Resultado.text =
                            "Tempo para aposentar\nPor idade:\t\t\t|\t\t\tPor Contribuição:\n$tApos ano(s)\t\t\t|\t\t\t\t\t\t$ptApos pontos\t\t\t\t\t\t"
                    } else {
                        txt_Resultado.text = "Já pode se aposentar"
                    }
                } else if (sexo == "Feminino") {
                    tApos = idf - idade
                    ptApos = ptf - contribuido
                    if (idade < idf && contribuido < ptf) {
                        txt_Resultado.text =
                            "Tempo para aposentar\nPor idade:\t\t\t|\t\t\tPor Contribuição:\n$tApos ano(s)\t\t\t|\t\t\t\t\t\t$ptApos pontos\t\t\t\t\t\t"
                    } else {
                        txt_Resultado.text = "Já pode se aposentar"
                    }
                }
            }
        }
    }
}