package com.polinom.interfata;

import com.polinom.structura.Monom;
import com.polinom.structura.Polinom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.polinom.operatii.*;

public class InterfatGUI {

    private JTextField textField = new JTextField();
    private JFrame frame = new JFrame("Calculator Polinoame");
    private JLabel header = new JLabel("", SwingConstants.CENTER);
    private JLabel status1 = new JLabel("Rezultat", SwingConstants.CENTER);
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JButton butonAdunare = new JButton("Adunare");
    private JButton butonScadere = new JButton("Scadere");
    private JButton butonDerivare1 = new JButton("Derivare P1");
    private JButton butonDerivare2 = new JButton("Derivare P2");
    private JButton butonIntegrare1 = new JButton("Integrare P1");
    private JButton butonIntegrare2 = new JButton("Integrare P2");
    private JButton butonInmultire = new JButton("Inmultire");
    private JButton butonImpartire = new JButton("Impartire");
    private JLabel pol1Label = new JLabel("Polinom1: ", JLabel.LEFT);
    private JLabel pol2Label = new JLabel("Polinom2: ", JLabel.LEFT);
    private final JTextField pol2Text = new JTextField(6);
    private final JTextField pol1Text = new JTextField(6);

    public void afisareGUI() {


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 300));
        frame.setBackground(Color.gray);
        frame.setLayout(new GridLayout(4, 1));

        panel.setLayout(new GridLayout(2, 3));
        panel2.setLayout(new GridLayout(2, 3));

        frame.add(header);
        frame.add(panel);
        frame.add(panel2);
        frame.add(status1);

        frame.pack();
        frame.setVisible(true);
    }

    public void adaugareComponente() {

        header.setText("Calcularor Polinoame");


        pol1Text.setSize(100, 40);
        pol2Text.setSize(100, 40);


        panel.add(pol1Label);
        panel.add(pol1Text);
        panel.add(pol2Label);
        panel.add(pol2Text);
        panel2.add(butonAdunare);
        panel2.add(butonScadere);
        panel2.add(butonInmultire);
        panel2.add(butonImpartire);
        panel2.add(butonDerivare1);
        panel2.add(butonDerivare2);
        panel2.add(butonIntegrare1);
        panel2.add(butonIntegrare2);
    }

    public void operatiiButoane() {
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Operatii o1 = new Operatii(p1, p2);


        butonAdunare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                status1.setText("");
                p1.splitPolinom(pol1Text.getText());
                p2.splitPolinom(pol2Text.getText());
                o1.adunare();
                status1.setText(o1.polinomAdunare.afisarePolinom(o1.polinomAdunare.monoame));
            }
        });

        butonScadere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.splitPolinom(pol1Text.getText());
                p2.splitPolinom(pol2Text.getText());
                status1.setText(o1.scadere());
            }
        });

        butonDerivare1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.splitPolinom(pol1Text.getText());
                p2.splitPolinom(pol2Text.getText());
                o1.derivarePolinom1();
                status1.setText(o1.polinomDerivare1.afisarePolinom(o1.polinomDerivare1.monoame));

            }
        });

        butonDerivare2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.splitPolinom(pol1Text.getText());
                p2.splitPolinom(pol2Text.getText());
                o1.derivarePolinom2();
                status1.setText(o1.polinomDerivare2.afisarePolinom(o1.polinomDerivare2.monoame));
            }
        });

        butonIntegrare1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.splitPolinom(pol1Text.getText());
                p2.splitPolinom(pol2Text.getText());
                o1.integrare1();
                status1.setText(o1.polinomIntegrat1.afisarePolinomIntegrat(o1.polinomIntegrat1.monoame));
            }
        });

        butonIntegrare2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.splitPolinom(pol1Text.getText());
                p2.splitPolinom(pol2Text.getText());
                o1.integrare2();
                status1.setText(o1.polinomIntegrat2.afisarePolinomIntegrat(o1.polinomIntegrat2.monoame));
            }
        });

        butonInmultire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                p1.splitPolinom(pol1Text.getText());
                p2.splitPolinom(pol2Text.getText());
                o1.inmultire();
                status1.setText(o1.polinomInmultire.afisarePolinom(o1.polinomInmultire.monoame));
            }
        });

    }

}
