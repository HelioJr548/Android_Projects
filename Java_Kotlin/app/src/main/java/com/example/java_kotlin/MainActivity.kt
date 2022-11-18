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
    private EditText txtSobNome;
    private TextView lblResultado;
    private static String ARQUIVO_REFENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        txtSobNome = findViewById(R.id.txtSobNome);
        btnSalvar = findViewById(R.id.btnSalvar);
        lblResultado = findViewById(R.id.lblResultado);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_REFENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

//                VALIDAR NOME
                if (txtNome.getText().toString().equals("") || txtSobNome.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Atenção, Nome ou Sobrenome vazios.\nPor favor preencha-o(s)", Toast.LENGTH_LONG).show();
                } else {
                    String nome = txtNome.getText().toString();
                    editor.putString("nome", nome);
                    String sobnome = txtSobNome.getText().toString();
                    editor.putString("sobnome", sobnome);
                    editor.commit();
                    lblResultado.setText("Seja Bem-vindo(a)\n" + nome + " " + sobnome);
                }

            }
        });

//        RECUPERAR DADOS SALVOS
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_REFENCIA, 0);
        if (preferences.contains("nome")) {
            String nome = preferences.getString("nome", "\" Olá, usuário não defenido");
            String sobnome = preferences.getString("sobnome", "\" Olá, usuário não defenido");
            lblResultado.setText("Seja Bem-vindo(a)\n" + nome + " " + sobnome);
        } else {
            lblResultado.setText("Olá, usuário não definido");
        }
    }
}