package com.polinom.structura;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom extends ArrayList<Monom> {

    int counter = 0;
    String polinomInteg = "";
    ArrayList<Monom> arrayPolinom = new ArrayList<Monom>();
    Monom mona;
    public ArrayList<Monom> monoame = new ArrayList<Monom>();

    public Polinom(Monom mona) {
        this.mona = mona;
        arrayPolinom.add(mona);
    }

    public Polinom() {

    }

    public void splitPolinom(String polinom) {

        Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
        Matcher m = p.matcher(polinom);
        while (m.find()) {

            Monom newMonom = new Monom(Integer.parseInt(m.group(2)), Integer.parseInt(m.group(1)));
            monoame.add(newMonom);
        }

    }

    public String afisarePolinom(ArrayList<Monom> arrayPolinom) {
        counter++;
        for (Monom mon : arrayPolinom) {
            if (mon.getCoeficient() >= 0) {
                polinomInteg = polinomInteg + "+" + Integer.toString(mon.getCoeficient()) + "x^" + Integer.toString(mon.getPutere());
            } else {

                polinomInteg = polinomInteg + Integer.toString(mon.getCoeficient()) + "x^" + Integer.toString(mon.getPutere());
                System.out.print(mon.getCoeficient() + "x^" + mon.getPutere());
            }
        }
        System.out.println("counter: " + counter);
        return polinomInteg;
    }


    public String afisarePolinomIntegrat(ArrayList<Monom> arrayPolinom) {
        for (Monom mon : arrayPolinom) {
            if (mon.getCoeficient() >= 0) {
                polinomInteg = polinomInteg + "+" + Integer.toString(mon.getCoeficient()) + "/" + Integer.toString(mon.getPutere()) + "x^" + Integer.toString(mon.getPutere());
            } else {

                polinomInteg = polinomInteg + Integer.toString(mon.getCoeficient()) + "/" + Integer.toString(mon.getPutere()) + "x^" + Integer.toString(mon.getPutere());
                System.out.print(mon.getCoeficient() + "x^" + mon.getPutere());
            }
        }

        return polinomInteg;
    }

}