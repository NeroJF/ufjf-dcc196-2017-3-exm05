package br.ufjf.dcc171.variasjanelas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityAuxiliar1 extends AppCompatActivity {

    private TextView txtAux1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliar1);
        txtAux1 = (TextView) findViewById(R.id.txtAux1);
        String mensagem = getIntent().getStringExtra("mensagem");
        txtAux1.setText(mensagem);
    }
}
