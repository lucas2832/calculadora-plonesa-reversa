package com.example.calculadorapolonesa;

public class Calculadora {
    private double operando;
    private double visor;

    public Calculadora() {
        operando = 0;
        visor = 0;
    }

    public void setVisor(double numero) {
        visor = numero;
    }

    public double getVisor() {
        return visor;
    }

    public void enter() {
        operando = visor;
    }

    public void soma() {
        operando = visor + operando;
        visor = operando;
    }
}
