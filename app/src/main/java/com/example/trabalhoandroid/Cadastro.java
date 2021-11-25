package com.example.trabalhoandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {
    BDHelper helper = new BDHelper(this);
    private EditText edtNome;
    private EditText edtSenha2, edtConfSenha;
    private Button btnCadastra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = findViewById(R.id.edtNome);
        edtSenha2 = findViewById(R.id.edtSenha2);
        edtConfSenha = findViewById(R.id.edtConfSenha);
        btnCadastra = findViewById(R.id.btnCadastra);
        Bundle args = getIntent().getExtras();

        btnCadastra.setText("CADASTRAR");

    }
    public void Cadastrar(View view){
        String nome = edtNome.getText().toString();
        String senha2 = edtSenha2.getText().toString();
        String confSenha = edtConfSenha.getText().toString();
        if(!senha2.equals(confSenha)){
            Toast toast = Toast.makeText(Cadastro.this,
                    "Senha difere da confirmação!",Toast.LENGTH_SHORT);
            toast.show();
            edtSenha2.setText("");
            edtConfSenha.setText("");
        }
        else {
            Usuario u = new Usuario(nome,senha2);

            helper.insereUsuario(u);
            helper.close();
            Toast toast = Toast.makeText(Cadastro.this,
                    "Cadastro realizado com sucesso!",Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }
    }
}