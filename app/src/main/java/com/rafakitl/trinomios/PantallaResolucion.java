package com.rafakitl.trinomios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.lang.Math;

public class PantallaResolucion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_resolucion);

        Intent solucionReal = getIntent();

        double terminoCuadratico = solucionReal.getDoubleExtra(MainActivity.CUADRATICO, 0);
        double terminoLineal = solucionReal.getDoubleExtra(MainActivity.LINEAL, 0);
        double terminoConstante = solucionReal.getDoubleExtra(MainActivity.CONSTANTE,0);

        String parentesis;
        String normalUno;
        String normalDos;

        double condicion = (Math.pow(terminoLineal,2))-(4*terminoCuadratico*terminoConstante);
        double X1=(-terminoLineal+(Math.sqrt(condicion)))/(2*terminoCuadratico);
        double X2=(-terminoLineal-(Math.sqrt(condicion)))/(2*terminoCuadratico);

        TextView formatoParentesis = findViewById(R.id.formatoParentesis);
        TextView formatoNormalUno = findViewById(R.id.respuestaXNormalUno);
        TextView formatoNormalDos = findViewById(R.id.respuestaXNormalDos);

        if (X1>=0)
        {
            if (X2>=0)
            {
                parentesis = "(X - " + X1 + ") Y (X - " + X2 + ")";
            }
            else
            {
                parentesis = "(X - " + X1 + ") Y (X + " + -X2 + ")";
            }
        }
        else
        {
            if (X2>=0)
            {
                parentesis = "(X + " + -X1 + ") Y (X - " + X2 + ")";
            }
            else
            {
                parentesis = "(X + " + -X1 + ") Y (X + " + -X2 + ")";
            }
        }
        formatoParentesis.setText(parentesis);
        normalUno = "X1 = " + X1;
        normalDos = "X2 = " + X2;
        formatoNormalUno.setText(normalUno);
        formatoNormalDos.setText(normalDos);
    }
}