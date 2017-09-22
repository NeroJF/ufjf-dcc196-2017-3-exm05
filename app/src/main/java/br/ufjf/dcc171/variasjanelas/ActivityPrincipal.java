package br.ufjf.dcc171.variasjanelas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityPrincipal extends AppCompatActivity {

    public static final int PEDE_NOME = 1;
    private Button btnAux1;
    private Button btnAux2;
    private TextView txtPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnAux1 = (Button) findViewById(R.id.btnAux1);
        btnAux2 = (Button) findViewById(R.id.btnAux2);
        txtPrincipal = (TextView) findViewById(R.id.txtPrincipal);
        btnAux1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviarDadosParaAuxiliar1 = new Intent(
                        ActivityPrincipal.this, ActivityAuxiliar1.class
                );
                enviarDadosParaAuxiliar1.putExtra("mensagem", "Olá Mundo!");
                startActivity(enviarDadosParaAuxiliar1);
            }
        });

        btnAux2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pedirNome = new Intent(
                        ActivityPrincipal.this, ActivityAuxiliar2.class
                );
            startActivityForResult(pedirNome, PEDE_NOME);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ActivityPrincipal.PEDE_NOME  &&
                resultCode == RESULT_OK && data !=null){
            String nome = data.getStringExtra("nome");
            txtPrincipal.setText("Olá "+nome+"!");
        }
    }
}
