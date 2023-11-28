package com.example.pdv.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pdv.controller.ClienteController;

public class CadastroClienteActivity extends AppCompatActivity {

    private EditText editTextNomeCliente;
    private EditText editTextEmailCliente;
    private Button buttonCadastrarCliente;
    private ClienteController cadastroClienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        editTextNomeCliente = findViewById(R.id.editTextNomeCliente);
        editTextEmailCliente = findViewById(R.id.editTextEmailCliente);
        buttonCadastrarCliente = findViewById(R.id.buttonCadastrarCliente);

        cadastroClienteController = new ClienteController(this);

        buttonCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarCliente();
            }
        });
    }

    private void cadastrarCliente() {
        String nomeCliente = editTextNomeCliente.getText().toString();
        String emailCliente = editTextEmailCliente.getText().toString();

        if (!nomeCliente.isEmpty() && !emailCliente.isEmpty()) {
            long idInserido = cadastroClienteController.cadastrarCliente(nomeCliente, emailCliente);

            if (idInserido != -1) {
                Toast.makeText(this, "Cliente cadastrado com sucesso. ID: " + idInserido, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Erro ao cadastrar cliente.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
        }
    }
}
