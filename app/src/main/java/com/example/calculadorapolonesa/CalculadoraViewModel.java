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

    public void tres() {
        if (status == NORMAL) {
            visor.setValue("" + 3);
            status = DIGITANDO;
        } else {
            Log.d("CALCULADORA", visor.getValue());
            visor.setValue(visor.getValue() + "3");
        }
    }

    public void quatro() {
        if (status == NORMAL) {
            visor.setValue("" + 4);
            status = DIGITANDO;
        } else {
            Log.d("CALCULADORA", visor.getValue());
            visor.setValue(visor.getValue() + "4");
        }
    }

    public void cinco() {
        if (status == NORMAL) {
            visor.setValue("" + 5);
            status = DIGITANDO;
        } else {
            Log.d("CALCULADORA", visor.getValue());
            visor.setValue(visor.getValue() + "5");
        }
    }

    public void seis() {
        if (status == NORMAL) {
            visor.setValue("" + 6);
            status = DIGITANDO;
        } else {
            Log.d("CALCULADORA", visor.getValue());
            visor.setValue(visor.getValue() + "6");
        }
    }

    public void sete() {
        if (status == NORMAL) {
            visor.setValue("" + 7);
            status = DIGITANDO;
        } else {
            Log.d("CALCULADORA", visor.getValue());
            visor.setValue(visor.getValue() + "7");
        }
    }

    public void oito() {
        if (status == NORMAL) {
            visor.setValue("" + 8);
            status = DIGITANDO;
        } else {
            Log.d("CALCULADORA", visor.getValue());
            visor.setValue(visor.getValue() + "8");
        }
    }

    public void nove() {
        if (status == NORMAL) {
            visor.setValue("" + 9);
            status = DIGITANDO;
        } else {
            Log.d("CALCULADORA", visor.getValue());
            visor.setValue(visor.getValue() + "9");
        }
    }

    public void zero() {
        if (status == NORMAL) {
            visor.setValue("" + 0);
            status = DIGITANDO;
        } else {
            Log.d("CALCULADORA", visor.getValue());
            visor.setValue(visor.getValue() + "0");
        }
    }

    public void virgula() {
        if (status == NORMAL) {
            visor.setValue("0" + ",");
            status = DIGITANDO;
        } else {
            Log.d("CALCULADORA", visor.getValue());
            visor.setValue(visor.getValue() + ",");
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

    public void subtracao () {
        calculadora.setVisor(Double.valueOf(visor.getValue()));
        calculadora.subtracao();
        visor.setValue(String.format("%f", calculadora.getVisor()));
        status = NORMAL;
    }
}

