package com.example.calculadorapolonesa;

public class Calculadora {
    public static final int VAZIO = 0;
    public static final int PREENCHIDO = 1;
    private double operando;
    private double visor;
    private double i;
    private int flagI;
    private double n;
    private int flagN;
    private double fv;
    private int flagFV;
    private double pv;
    private int flagPV;

    public Calculadora() {
        operando = 0;
        visor = 0;
        i = 0;
        n = 0;
        fv = 0;
        pv = 0;
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

    public void clear () {
        operando = 0;
        visor = 0;
        i = 0;
        n = 0;
        fv = 0;
        pv = 0;
    }

    public void soma() {
        operando = operando + visor;
        visor = operando;
    }

    public void subtracao () {
        operando = operando - visor;
        visor = operando;
    }

    public void multiplicacao () {
        operando = operando * visor;
        visor = operando;
    }

    public void divisao () {
        operando = operando / visor;
        visor = operando;
    }

    public void i () {
        if (flagFV != VAZIO && flagPV != VAZIO && flagN != VAZIO) {
            calculoI();
        } else {
            i = visor;
            flagI = PREENCHIDO;
        }

    }

    public void n () {
        if (flagFV != VAZIO && flagPV != VAZIO && flagI != VAZIO) {
            calculoN();
        } else {
            n = visor;
            flagN = PREENCHIDO;
        }
    }

    public void fv () {
        if (flagPV != VAZIO && flagI != VAZIO && flagN != VAZIO) {
            calculoFV();
        } else {
            fv = visor;
            flagFV = PREENCHIDO;
        }
    }

    public void pv () {
        if (flagFV != VAZIO && flagI != VAZIO && flagN != VAZIO) {
            calculoPV();
        } else {
            pv = visor;
            flagPV = PREENCHIDO;
        }
    }

    public void calculoFV () {
        fv = pv * Math.pow((1 + i), n);
        visor = fv;
    }

    public void calculoPV () {
        pv = fv / Math.pow((1 + i), n);
        visor = pv;
    }

    public void calculoI () {
        i = Math.pow((fv / pv), (1 / n)) - 1;
        visor = i;
    }

    public void calculoN () {
        n = Math.log(fv / pv) / Math.log(1 + i);
        visor = n;
    }
}
