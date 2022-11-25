package com.rafakitl.trinomios;

public class NumeroComplejo {
    private double real;
    private double imaginario;

    public NumeroComplejo(double x, double y){
        this.real = x;
        this.imaginario = y;
    }

    public double getReal()
    {
        return real;
    }

    public double getImaginario()
    {
        return imaginario;
    }

    public void setReal(double x)
    {
        this.real = x;
    }

    public void setImaginario(double y)
    {
        this.imaginario = y;
    }

    public String mostrarNumeroComplejo(){
        if (imaginario >= 0)
        {
            return (real + " + " + imaginario + "j");
        }
        else
        {
            return (real + " - " + -imaginario + "j");
        }

    }
}
