package com.rafakitl.trinomios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    public static final String CUADRATICO =  "com.rafakitl.Trinomios.CUADRATICO";
    public static final String LINEAL = "com.rafakitl.Trinomios.LINEAL";
    public static final String CONSTANTE = "com.rafakitl.Trinomios.CONSTANTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void obtenerDatos(View v){

        EditText editableTerminoCuadratico = (EditText) findViewById(R.id.entradaTerminoCuadratico);
        EditText editableTerminoLineal = (EditText) findViewById(R.id.entradaTerminoLineal);
        EditText editableTerminoConstante = (EditText) findViewById(R.id.entradaTerminoConstante);

        String stringTerminoCuadratico = editableTerminoCuadratico.getText().toString();
        String stringTerminoLineal = editableTerminoLineal.getText().toString();
        String stringTerminoConstante = editableTerminoConstante.getText().toString();

        if (stringTerminoCuadratico.equals("") || stringTerminoLineal.equals("") || stringTerminoConstante.equals(""))
        {
            Snackbar.make( v, R.string.aviso1, Snackbar.LENGTH_LONG).show();
        }
        if (stringTerminoCuadratico.equals(".") || stringTerminoLineal.equals(".") || stringTerminoConstante.equals("."))
        {
            Snackbar.make( v, R.string.aviso2, Snackbar.LENGTH_LONG).show();
        }
        else
        {
            double doubleTerminoCuadratico = Double.parseDouble(stringTerminoCuadratico);
            double doubleTerminoLineal = Double.parseDouble(stringTerminoLineal);
            double doubleTerminoConstante= Double.parseDouble(stringTerminoConstante);

            if(doubleTerminoCuadratico == 0)
            {
                Snackbar.make(v, "Este no es un trinomio, no se puede factorizar", Snackbar.LENGTH_SHORT).show();
            }
            else
            {
                double Condicion = (Math.pow(doubleTerminoLineal,2))-(4*doubleTerminoCuadratico*doubleTerminoConstante);

                if (Condicion < 0 )
                {
                    Intent solucionCompleja = new Intent(this, PantallaResolucionCompleja.class);
                    solucionCompleja.putExtra(CUADRATICO, doubleTerminoCuadratico);
                    solucionCompleja.putExtra(LINEAL, doubleTerminoLineal);
                    solucionCompleja.putExtra(CONSTANTE, doubleTerminoConstante);
                    startActivity(solucionCompleja);
                }
                else
                {
                    Intent solucionReal = new Intent(this, PantallaResolucion.class);
                    solucionReal.putExtra(CUADRATICO, doubleTerminoCuadratico);
                    solucionReal.putExtra(LINEAL, doubleTerminoLineal);
                    solucionReal.putExtra(CONSTANTE, doubleTerminoConstante);
                    startActivity(solucionReal);
                }
            }
        }
    }
}