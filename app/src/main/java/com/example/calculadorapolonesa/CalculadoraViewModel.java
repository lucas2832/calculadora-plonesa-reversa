package com.example.calculadorapolonesa;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CalculadoraViewModel {

    private static final int NORMAL = 0;
    private static final int DIGITANDO = 1;
    private int status; // 0 - normal, 1 - digitando
    private MutableLiveData<String> visor;
    private Calculadora calculadora;

    public CalculadoraViewModel() {
        status = NORMAL;
        calculadora = new Calculadora();
        visor = new MutableLiveData<>("0,00");
    }

    public LiveData<String> getVisor() {
        return visor;
    }

    public void um() {
        if (status == NORMAL) {
            visor.setValue("" + 1);
            status = DIGITANDO;
        } else {
            visor.setValue(visor.getValue() + "1");
        }
    }
    public void dois() {
        if (status == NORMAL) {
            visor.setValue("" + 2);
            status = DIGITANDO;
        } else {
            Log.d("CALCULADORA", visor.getValue());
            visor.setValue(visor.getValue() + "2");
        }
    }

    public void enter() {
        // aquilo que ta no visor passa a ser o operando
        calculadora.setVisor(Double.valueOf(visor.getValue()));
        calculadora.enter();
        status = NORMAL;
    }

    public void soma() {
        calculadora.setVisor(Double.valueOf(visor.getValue()));
        calculadora.soma();
        visor.setValue(String.format("%f", calculadora.getVisor()));
        status = NORMAL;
    }
}

