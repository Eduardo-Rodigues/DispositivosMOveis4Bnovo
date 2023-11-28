package com.example.pdv.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pdv.controller.PedidoController;

public class CadastrarPedidoActivity extends AppCompatActivity {

    private EditText editTextIdCliente;
    private EditText editTextProduto;
    private Button buttonCadastrarPedido;
    private PedidoController cadastroPedidoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_pedido);

        editTextIdCliente = findViewById(R.id.editTextIdCliente);
        editTextProduto = findViewById(R.id.editTextProduto);
        buttonCadastrarPedido = findViewById(R.id.buttonCadastrarPedido);

        cadastroPedidoController = new PedidoController(this);

        buttonCadastrarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarPedido();
            }
        });
    }

    private void cadastrarPedido() {
        String idClienteStr = editTextIdCliente.getText().toString();
        String produto = editTextProduto.getText().toString();

        if (!idClienteStr.isEmpty() && !produto.isEmpty()) {
            int idCliente = Integer.parseInt(idClienteStr);

            long idInserido = cadastroPedidoController.cadastrarPedido(idCliente, produto);

            if (idInserido != -1) {
                Toast.makeText(this, "Pedido cadastrado com sucesso. ID: " + idInserido, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Erro ao cadastrar pedido.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
        }
    }
}
