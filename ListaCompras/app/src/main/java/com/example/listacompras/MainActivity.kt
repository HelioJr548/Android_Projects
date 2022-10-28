package com.example.listacompras

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewProdutos = findViewById<ListView>(R.id.listViewProdutos)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val txtProduto = findViewById<EditText>(R.id.txtProduto)
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val ModoEscuro = findViewById<Switch>(R.id.switch_cor)
        val tela = findViewById<LinearLayout>(R.id.view_Tela)
        listViewProdutos.adapter = produtosAdapter

        btnInserir.setOnClickListener {
            val produto = txtProduto.text.toString()
            if (produto.isNotEmpty()) {
                produtosAdapter.add(produto)
                txtProduto.text.clear()
            } else {
                txtProduto.error = "Coloque um Produto"
            }

        }

        listViewProdutos.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
        }

        ModoEscuro.setOnCheckedChangeListener { buttonView, isChecked ->
            isChecked
            if (isChecked) {
                tela.setBackgroundColor(getResources().getColor(R.color.cfE))
                txtProduto.setTextColor(getResources().getColor(R.color.tpE))
//                btnInserir.setTextColor(getResources().getColor(R.color.tsE))
                btnInserir.setBackground(getResources().getDrawable(R.drawable.send_claro))
                listViewProdutos.setBackgroundColor(getResources().getColor(R.color.tsE))
                txtProduto.setHintTextColor(getResources().getColor(R.color.tsE))
                ModoEscuro.setTextColor(getResources().getColor(R.color.tsE))

            } else {
                tela.setBackgroundColor(getResources().getColor(R.color.cfC))
                txtProduto.setTextColor(getResources().getColor(R.color.black))
                btnInserir.setBackground(getResources().getDrawable(R.drawable.round_send_black_20))
                listViewProdutos.setBackgroundColor(getResources().getColor(R.color.tsC))
                txtProduto.setHintTextColor(getResources().getColor(R.color.black))
                ModoEscuro.setTextColor(getResources().getColor(R.color.black))
            }
        }
    }
}