package com.stevenprogramming.cracking.arraysandstrings.learn.cristel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CristelSwing extends JFrame implements ActionListener {


    private JTextField textfield1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textfield2;
    private JButton boton1;
    private JButton boton2;
    private JPanel jPanel;
    private JPanel jPanel2;
    private JPanel jPanelContainer;

    public CristelSwing() {

        setTitle("Cristel Sistema contable");
        setFont(new Font(Font.SERIF, Font.BOLD, 20));

        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 2));
        jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayout(3, 1));
        jPanelContainer = new JPanel();
        jPanelContainer.setLayout(new GridLayout(2, 2));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 200));

        label1 = new JLabel("Numero 1: ");
        label1.setForeground(new Color(180, 70, 30));
        label1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jPanel.add(label1);

        textfield1 = new JTextField();
        textfield1.setBackground(new Color(180, 70, 30));
        textfield1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jPanel.add(textfield1);

        label2 = new JLabel("Numero 2: ");
        label2.setForeground(new Color(30, 135, 30));
        label2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jPanel.add(label2);

        textfield2 = new JTextField();
        textfield2.setBackground(new Color(30, 135, 30));
        textfield2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        jPanel.add(textfield2);
        jPanelContainer.add(jPanel);

        label3 = new JLabel();
        jPanel2.add(label3);

        boton1 = new JButton("Aceptar");
        boton1.addActionListener(this);
        jPanel2.add(boton1);

        boton2 = new JButton("Sumar");
        boton2.addActionListener(this);
        jPanel2.add(boton2);

        jPanelContainer.add(jPanel2);

        add(jPanelContainer);

        //Display the window.
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton1) {
            int numero1 = Integer.parseInt(textfield1.getText());
            int numero2 = Integer.parseInt(textfield2.getText());
            label3.setText("Numero 1 = " + numero1 + ", Numero 2 = " + numero2);
            label3.setFont(new Font(Font.SERIF, Font.BOLD, 18));
            }
        if (e.getSource() == boton2) {
            int numero1 = Integer.parseInt(textfield1.getText());
            int numero2 = Integer.parseInt(textfield2.getText());
            int resultado = (numero1 + numero2);
            label3.setText(" Numero 1= " + numero1  + " + " + " Numero 2= " + numero2 + " es " + resultado);


        }
    }

    public static void main(String[] args) {
        new CristelSwing();
    }
}
