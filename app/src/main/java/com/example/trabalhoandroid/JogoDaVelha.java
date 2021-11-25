package com.example.trabalhoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JogoDaVelha extends AppCompatActivity {
    // casas do tabuleiro
    private ImageButton btnA1, btnA2, btnA3, btnA4, btnA5, btnA6, btnA7, btnA8, btnA9;

    // textview para msotrar o nome do usuario
    private TextView usrText;

    // matriz representando o tabuleiro para conferencia
    private int[][] tabuleiro = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    private int jogadas = 0;

    // gerador de número aleatório para acesso ao vetor de botoes
    Random gerador = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_da_velha);

        btnA1 = findViewById(R.id.btnA1);
        btnA2 = findViewById(R.id.btnA2);
        btnA3 = findViewById(R.id.btnA3);
        btnA4 = findViewById(R.id.btnA4);
        btnA5 = findViewById(R.id.btnA5);
        btnA6 = findViewById(R.id.btnA6);
        btnA7 = findViewById(R.id.btnA7);
        btnA8 = findViewById(R.id.btnA8);
        btnA9 = findViewById(R.id.btnA9);

        usrText = findViewById(R.id.usrText);


        usrText.setText(getIntent().getStringExtra("chave_usuario"));

        // vetor de botões para uso da IA
        ImageButton[] btns = {btnA1, btnA2, btnA3, btnA4, btnA5, btnA6, btnA7, btnA8, btnA9};

        // vetor para saber se um botao foi pressionado
        int[] checkBotoes = {0, 0, 0, 0, 0, 0, 0, 0, 0};


                // se o botão for pressionado, muda a imagem para o X
        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnA1.setImageResource(R.drawable.xis);
                tabuleiro[0][0] = 1;
                checkBotoes[0] = 1;
                jogadas++;
                inteligenciaArtificial(btns, checkBotoes);
                checkTabuleiro(checkBotoes);
            }
        });
        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnA2.setImageResource(R.drawable.xis);
                tabuleiro[0][1] = 1;
                checkBotoes[1] = 1;
                jogadas++;
                inteligenciaArtificial(btns, checkBotoes);
                checkTabuleiro(checkBotoes);
            }
        });
        btnA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnA3.setImageResource(R.drawable.xis);
                tabuleiro[0][2] = 1;
                checkBotoes[2] = 1;
                jogadas++;
                inteligenciaArtificial(btns, checkBotoes);
                checkTabuleiro(checkBotoes);
            }
        });
        btnA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnA4.setImageResource(R.drawable.xis);
                tabuleiro[1][0] = 1;
                checkBotoes[3] = 1;
                jogadas++;
                inteligenciaArtificial(btns, checkBotoes);
                checkTabuleiro(checkBotoes);
            }
        });
        btnA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnA5.setImageResource(R.drawable.xis);
                tabuleiro[1][1] = 1;
                checkBotoes[4] = 1;
                jogadas++;
                inteligenciaArtificial(btns, checkBotoes);
                checkTabuleiro(checkBotoes);
            }
        });
        btnA6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnA6.setImageResource(R.drawable.xis);
                tabuleiro[1][2] = 1;
                checkBotoes[5] = 1;
                jogadas++;
                inteligenciaArtificial(btns, checkBotoes);
                checkTabuleiro(checkBotoes);
            }
        });
        btnA7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnA7.setImageResource(R.drawable.xis);
                tabuleiro[2][0] = 1;
                checkBotoes[6] = 1;
                jogadas++;
                inteligenciaArtificial(btns, checkBotoes);
                checkTabuleiro(checkBotoes);
            }
        });
        btnA8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnA8.setImageResource(R.drawable.xis);
                tabuleiro[2][1] = 1;
                checkBotoes[7] = 1;
                jogadas++;
                inteligenciaArtificial(btns, checkBotoes);
                checkTabuleiro(checkBotoes);
            }
        });
        btnA9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnA9.setImageResource(R.drawable.xis);
                tabuleiro[2][2] = 1;
                checkBotoes[8] = 1;
                jogadas++;
                inteligenciaArtificial(btns, checkBotoes);
                checkTabuleiro(checkBotoes);
            }
        });
    }

    // confere o tabuleiro para ver se o usuario venceu
    public void checkTabuleiro(int[] tab)
    {
        if (tab[0] == 1 && tab[1] == 1 && tab[2] == 1) {
            alert("VENCEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[3]  == 1 && tab[4] == 1 && tab[5] == 1) {
            alert("VENCEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[6] == 1 && tab[7] == 1 && tab[8] == 1) {
            alert("VENCEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[0]  == 1 && tab[3]  == 1 && tab[6]  == 1) {
            alert("VENCEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[1] == 1&& tab[4] == 1 && tab[7] == 1) {
            alert("VENCEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[2] == 1 && tab[5] == 1 && tab[8] == 1) {
            alert("VENCEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[0] == 1 && tab[4] == 1 && tab[8] == 1) {
            alert("VENCEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[2] == 1 && tab[4] == 1 && tab[6] == 1) {
            alert("VENCEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[0] == 2 && tab[1] == 2 && tab[2] == 2) {
            alert("PERDEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[3]  == 2 && tab[4] == 2 && tab[5] == 2) {
            alert("PERDEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[6] == 2 && tab[7] == 2 && tab[8] == 2) {
            alert("PERDEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[0] == 2 && tab[3]  == 2 && tab[6]  == 2) {
            alert("PERDEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[1] == 2 && tab[4] == 2 && tab[7] == 2) {
            alert("PERDEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[2] == 2 && tab[5] == 2 && tab[8] == 2) {
            alert("PERDEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[0] == 2 && tab[4] == 2 && tab[8] == 2) {
            alert("PERDEU!");
            finish();
            startActivity(getIntent());
        }

        else if (tab[2] == 2 && tab[4] == 2 && tab[6] == 2) {
            alert("PERDEU!");
            finish();
            startActivity(getIntent());
        }

        else if (jogadas == 9) {
            alert("VELHA!");
            finish();
            startActivity(getIntent());
        }
    }

    public void inteligenciaArtificial(ImageButton[] btns, int[] checkBotoes)
    {
        while(jogadas < 9)
        {
            // gera um numero aleatorio para acessar um botão
            int rand = gerador.nextInt(9);
            ImageButton botao = btns[rand];

            // se o botao nao foi pressionado marca circulo
            if (checkBotoes[rand] == 0) {
                botao.setImageResource(R.drawable.circulo);
                checkBotoes[rand] = 2;
                jogadas++;
                checkTabuleiro(checkBotoes);
                break;
            }
        }
    }

    // mostra uma mensagem na tela
    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}