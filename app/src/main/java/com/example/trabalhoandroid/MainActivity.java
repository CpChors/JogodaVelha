package com.example.trabalhoandroid;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BDHelper helper = new BDHelper(this);
    private EditText edtUsuario;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
    }
    public void Cadastrar(View view){
        Intent it = new Intent(this, Cadastro.class);
        startActivity(it);
    }
    public void Conectar(View view){
        String usr = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();
        String password = helper.buscarSenha(usr);
        if(senha.equals(password)){
            Intent intent = new Intent(MainActivity.this, JogoDaVelha.class);
            intent.putExtra("chave_usuario",usr);
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(MainActivity.this,
                    password,Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}