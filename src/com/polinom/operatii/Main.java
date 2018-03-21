package com.polinom.operatii;

import com.polinom.interfata.InterfatGUI;

public class Main {

    public static void main(String[] args) {

        InterfatGUI interfat = new InterfatGUI();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                interfat.afisareGUI();
                interfat.adaugareComponente();
                interfat.operatiiButoane();
            }
        });



    }


}
