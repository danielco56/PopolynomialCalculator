package com.polinom.structura;

import java.util.*;

public class Monom {

    private int putere;
    private int coeficient;

    public Monom(int putere, int coeficient) {
        this.putere = putere;
        this.coeficient = coeficient;
    }

    public int getPutere() {
        return putere;
    }

    public int getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }
}
