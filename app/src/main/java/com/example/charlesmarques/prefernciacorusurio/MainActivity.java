package com.example.charlesmarques.prefernciacorusurio;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {
private RadioGroup oRadioGroup;
private Button oButton_Salvar;
private RadioButton oRadioButton_Selecionado;
private  static final String ARQUIVO = "ArqPreferencia";
private ConstraintLayout oConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oRadioGroup = findViewById(R.id.rg_Grupo);
        oButton_Salvar = findViewById(R.id.btn_Salvar);
        oConstraintLayout = findViewById(R.id.id_Layout);

        oButton_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id_Selecionado = oRadioGroup.getCheckedRadioButtonId();
                oRadioButton_Selecionado = (RadioButton) findViewById(id_Selecionado);


                SharedPreferences oSharedPreferences = getSharedPreferences(ARQUIVO,0);
                SharedPreferences.Editor oEditor = oSharedPreferences.edit();

                oEditor.putString("corEscolhida", oRadioButton_Selecionado.getText().toString());

                oEditor.commit();
                setCor(oRadioButton_Selecionado.getText().toString());

            }
        });

        SharedPreferences oSharedPreferences = getSharedPreferences(ARQUIVO,0);
        if(oSharedPreferences.contains("corEscolhida")){
         String oRecuperar = oSharedPreferences.getString("corEscolhida","Laranja");
         setCor(oRecuperar);
        }


    }
    private void setCor(String cor){

        if(cor.equals("Azul")){
oConstraintLayout.setBackgroundColor(Color.parseColor("#495b7c"));

        }else if(cor.equals("Laranja")){
            oConstraintLayout.setBackgroundColor(Color.parseColor("#ffce26"));

        }else if(cor.equals("Verde")){
            oConstraintLayout.setBackgroundColor(Color.parseColor("#009670"));

        }
    }
}
