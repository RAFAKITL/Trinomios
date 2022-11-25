package com.rafakitl.trinomios;

public class OperacionesComplejos {
    public static NumeroComplejo suma(NumeroComplejo complejoUno, NumeroComplejo complejoDos)
    {
        NumeroComplejo complejoTres = new NumeroComplejo(0, 0);
        complejoTres.setReal(complejoUno.getReal() + complejoDos.getReal());
        complejoTres.setImaginario(complejoUno.getImaginario() + complejoDos.getImaginario());

        return complejoTres;
    }

    public static NumeroComplejo resta(NumeroComplejo complejoUno, NumeroComplejo complejoDos)
    {
        NumeroComplejo complejoTres = new NumeroComplejo(0, 0);
        complejoTres.setReal(complejoUno.getReal() - complejoDos.getReal());
        complejoTres.setImaginario(complejoUno.getImaginario() - complejoDos.getImaginario());

        return complejoTres;
    }

    public static NumeroComplejo multiplicacion(NumeroComplejo complejoUno, NumeroComplejo complejoDos)
    {
        double nuevoReal = (complejoUno.getReal()*complejoDos.getReal())+(-1*(complejoUno.getImaginario()*complejoDos.getImaginario()));
        double nuevoImaginario = (complejoUno.getReal()*complejoDos.getImaginario())+(complejoUno.getImaginario()*complejoDos.getReal());
        NumeroComplejo complejoTres = new NumeroComplejo(nuevoReal, nuevoImaginario);

        return complejoTres;
    }
}
