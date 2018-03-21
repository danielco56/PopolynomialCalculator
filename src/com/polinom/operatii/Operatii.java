package com.polinom.operatii;

import com.polinom.structura.Monom;
import com.polinom.structura.Polinom;

public class Operatii {

    private Polinom polinom1;
    private Polinom polinom2;
    public Polinom polinomAdunare;
    public Polinom polinomScadere;
    public Polinom polinomDerivare1;
    public Polinom polinomDerivare2;
    public Polinom polinomIntegrat1;
    public Polinom polinomIntegrat2;
    public Polinom polinomInmultire;

    public Operatii(Polinom polinom1, Polinom polinom2) {
        this.polinom1 = polinom1;
        this.polinom2 = polinom2;
    }

    public void adunare() {

        polinomAdunare = new Polinom();

        for (Monom mon : polinom1.monoame) {
            polinomAdunare.monoame.add(new Monom(mon.getPutere(), mon.getCoeficient()));
        }

        for (Monom mon2 : polinom2.monoame) {
            polinomAdunare.monoame.add(new Monom(mon2.getPutere(), mon2.getCoeficient()));
        }

        for (int i = 0; i < polinomAdunare.monoame.size(); i++) {
            for (int j = i + 1; j < polinomAdunare.monoame.size(); j++) {
                if (polinomAdunare.monoame.get(i).getPutere() == polinomAdunare.monoame.get(j).getPutere()) {

                    polinomAdunare.monoame.get(i).setCoeficient(polinomAdunare.monoame.get(i).getCoeficient() + polinomAdunare.monoame.get(j).getCoeficient());
                    polinomAdunare.monoame.remove(j);
                    j--;
                }

            }
        }


    }

    public String scadere() {
        String rez = new String();
        polinomScadere = new Polinom();

        for (Monom mon : polinom1.monoame) {
            polinomScadere.monoame.add(new Monom(mon.getPutere(), mon.getCoeficient()));
        }
        for (Monom mon2 : polinom2.monoame) {
            polinomScadere.monoame.add(new Monom(mon2.getPutere(), -mon2.getCoeficient()));
        }


        for (int i = 0; i < polinomScadere.monoame.size(); i++) {
            for (int j = i + 1; j < polinomScadere.monoame.size(); j++) {
                if (polinomScadere.monoame.get(i).getPutere() == polinomScadere.monoame.get(j).getPutere()) {
                    polinomScadere.monoame.get(i).setCoeficient(polinomScadere.monoame.get(i).getCoeficient() + polinomScadere.monoame.get(j).getCoeficient());
                    polinomScadere.monoame.remove(j);
                    j--;
                }

            }
        }
        rez = polinomScadere.afisarePolinom(polinomScadere.monoame);
        return rez;
    }


    public void derivarePolinom1() {

        polinomDerivare1 = new Polinom();

        for (Monom mon : polinom1.monoame) {
            if (mon.getPutere() > 0)
                polinomDerivare1.monoame.add(new Monom(mon.getPutere(), mon.getCoeficient()));
        }

        for (Monom mon : polinomDerivare1.monoame) {

            mon.setCoeficient(mon.getPutere() * mon.getCoeficient());
            mon.setPutere(mon.getPutere() - 1);
        }
        System.out.println(polinomDerivare1.monoame);

    }

    public void derivarePolinom2() {
        polinomDerivare2 = new Polinom();
        for (Monom mon : polinom2.monoame) {
            if (mon.getPutere() > 0)
                polinomDerivare2.monoame.add(new Monom(mon.getPutere(), mon.getCoeficient()));
        }

        for (Monom mon : polinomDerivare2.monoame) {
            mon.setCoeficient(mon.getCoeficient() * mon.getPutere());
            mon.setPutere(mon.getPutere() - 1);
        }
    }

    public void integrare1() {
        polinomIntegrat1 = new Polinom();
        for (Monom mon : polinom1.monoame) {
            polinomIntegrat1.monoame.add(new Monom(mon.getPutere(), mon.getCoeficient()));
        }

        for (Monom mon : polinomIntegrat1.monoame) {
            mon.setPutere(mon.getPutere() + 1);
        }

    }

    public void integrare2() {
        polinomIntegrat2 = new Polinom();
        for (Monom mon : polinom2.monoame) {
            polinomIntegrat2.monoame.add(new Monom(mon.getPutere(), mon.getCoeficient()));
        }

        for (Monom mon : polinomIntegrat2.monoame) {
            mon.setPutere(mon.getPutere() + 1);
        }

    }

    public void inmultire() {
        polinomInmultire = new Polinom();


        for (Monom mon1 : polinom1.monoame) {
            for (Monom mon2 : polinom2.monoame) {
                polinomInmultire.monoame.add(new Monom(mon1.getPutere() + mon2.getPutere(), mon1.getCoeficient() * mon2.getCoeficient()));
            }
        }

        for (int i = 0; i < polinomInmultire.monoame.size(); i++) {
            for (int j = i + 1; j < polinomInmultire.monoame.size(); j++) {
                if (polinomInmultire.monoame.get(i).getPutere() == polinomInmultire.monoame.get(j).getPutere()) {
                    polinomInmultire.monoame.get(i).setCoeficient(polinomInmultire.monoame.get(i).getCoeficient() - polinomInmultire.monoame.get(j).getCoeficient());
                    polinomInmultire.monoame.remove(j);
                    j--;
                }

            }

        }

    }
}