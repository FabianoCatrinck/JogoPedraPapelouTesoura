package com.cursoandroid.jogopedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
      this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }
    public void opcaoSelecionada(String escolhaUsuario){
      ImageView imageResultado = findViewById(R.id.imageResultado);
      TextView textResultado = findViewById(R.id.textResultado);
      int numero = new Random().nextInt(3);
      String[] opcoes = {"pedra","papel","tesoura"};
      String escolhaApp = opcoes[numero];
      switch (escolhaApp){
          case "pedra" :
              imageResultado.setImageResource(R.drawable.pedra);
              break;
          case "papel" :
              imageResultado.setImageResource(R.drawable.papel);
              break;
          case "tesoura" :
              imageResultado.setImageResource(R.drawable.tesoura);
              break;
      }

      if (
              (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                      (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                      (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
          ){//app ganhador
          textResultado.setText("Você perdeu :0(");

      }else if ((escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
              (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
              (escolhaUsuario == "pedra" && escolhaApp == "tesoura")){// usuario granhador
          textResultado.setText("Você ganhou !! :0)");
      }else{// empate
          textResultado.setText("Uaaalll temos um empate!!!");
      }
    }
}