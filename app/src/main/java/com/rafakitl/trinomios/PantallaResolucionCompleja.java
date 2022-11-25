package com.rafakitl.trinomios;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.TextView;
import android.os.Bundle;
import java.lang.Math;

public class PantallaResolucionCompleja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_resolucion_compleja);

        Intent solucionCompleja = getIntent();
        double terminoCuadratico = solucionCompleja.getDoubleExtra(MainActivity.CUADRATICO, 0);
        double terminoLineal = solucionCompleja.getDoubleExtra(MainActivity.LINEAL, 0);
        double terminoConstante = solucionCompleja.getDoubleExtra(MainActivity.CONSTANTE,0);

        double condicion = -1*((Math.pow(terminoLineal,2))-(4*terminoCuadratico*terminoConstante));
        NumeroComplejo Z1 = new NumeroComplejo(-terminoLineal/(2*terminoCuadratico), (Math.sqrt(condicion))/(2*terminoCuadratico));
        NumeroComplejo Z2 = new NumeroComplejo(-terminoLineal/(2*terminoCuadratico), -(Math.sqrt(condicion))/(2*terminoCuadratico));

        TextView formatoParentesis = findViewById(R.id.formatoParentesisComplejo);
        TextView formatoNormalUno = findViewById(R.id.respuestaZNormalUnoComplejo);
        TextView formatoNormalDos = findViewById(R.id.respuestaZNormalDosComplejo);

        String parentesis;
        String normalUno;
        String normalDos;


        parentesis = "(X - (" + Z1.mostrarNumeroComplejo() + ")) Y (X - (" + Z2.mostrarNumeroComplejo() + "))";

        formatoParentesis.setText(parentesis);
        normalUno = "X1 = " + Z1.mostrarNumeroComplejo();
        normalDos = "X2 = " + Z2.mostrarNumeroComplejo();
        formatoNormalUno.setText(normalUno);
        formatoNormalDos.setText(normalDos);



    }
}