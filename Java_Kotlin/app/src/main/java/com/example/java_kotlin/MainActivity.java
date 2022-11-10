package com.example.java_kotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSalvar;
    private EditText txtNome;
    private TextView lblResultado;
    private static String ARQUIVO_REFENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        btnSalvar = findViewById(R.id.btnSalvar);
        lblResultado = findViewById(R.id.lblResultado);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_REFENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

//                VALIDAR NOME
                if (txtNome.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Por favor, preencher seu nome", Toast.LENGTH_LONG).show();
                } else {
                    String nome = txtNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    lblResultado.setText("olá " + nome);
                }

            }
        });

//        RECUPERAR DADOS SALVOS
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_REFENCIA, 0);
        if (preferences.contains("nome")) {
            String nome = preferences.getString("nome", "\" Olá, usuário não defenido");
            lblResultado.setText("Olá " + nome);
        } else {
            lblResultado.setText("Olá, usuário não definido");
        }
    }
}