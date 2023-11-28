package com.example.pdv.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuOpcoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opcoes);

        Button buttonCadastrarCliente = findViewById(R.id.buttonCadastrarCliente);
        Button buttonCadastrarProduto = findViewById(R.id.buttonCadastrarProduto);
        Button buttonCadastrarPedido = findViewById(R.id.buttonCadastrarPedido);

        buttonCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCadastroCliente();
            }
        });

        buttonCadastrarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCadastroProduto();
            }
        });

        buttonCadastrarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCadastroPedido();
            }
        });
    }

    private void abrirCadastroCliente() {
        Intent intent = new Intent(this, CadastroClienteActivity.class);
        startActivity(intent);
    }

    private void abrirCadastroProduto() {
        Intent intent = new Intent(this, CadastroProdutoActivity.class);
        startActivity(intent);
    }

    private void abrirCadastroPedido() {
        Intent intent = new Intent(this, CadastrarPedidoActivity.class);
        startActivity(intent);
    }
}
