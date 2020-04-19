package com.example.lcoolougasolina2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText txtAlcool;
    private EditText txtGasolina;
    private Button btnCalcular;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAlcool = (EditText) findViewById(R.id.txtAlcool);
        txtGasolina = (EditText) findViewById(R.id.txtGasolina);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtRes = (TextView) findViewById(R.id.txtRes);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean camposValidados = validarCampos(txtAlcool.getText().toString(), txtAlcool.getText().toString());

                if(camposValidados == true){
                    double alcool = Double.parseDouble(txtAlcool.getText().toString());
                    double gasolina = Double.parseDouble(txtAlcool.getText().toString());
                    double resultado = alcool/gasolina;
                    if(resultado >= 0.7){
                        txtRes.setText("É melhor utilizar gasolina");
                    }else{
                        txtRes.setText("É melhor utilizar álcool");
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Preencha os campos acima", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if( pAlcool == null || pAlcool.equals("") || (pGasolina == null || pGasolina.equals(""))) {
            camposValidados = false;
        }

        return  camposValidados;

    }

}
