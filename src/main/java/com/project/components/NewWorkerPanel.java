package com.project.components;

import com.project.actions.SaveAction;

import javax.swing.*;
import java.awt.*;

public class NewWorkerPanel extends JDialog {

    public NewWorkerPanel(JFrame frame){
        super();
        this.setSize(new Dimension(500,400));
        SpringLayout layout=new SpringLayout();
        this.setLayout(layout);
        setModalityType(ModalityType.APPLICATION_MODAL);
        this.setTitle("Novi radnik");

        JLabel lblIme=new JLabel("Unesite ime");
        layout.putConstraint(SpringLayout.NORTH,lblIme,30,SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST,lblIme,30,SpringLayout.WEST,this);
        lblIme.setPreferredSize(new Dimension(80,20));

        JTextField txtIme=new JTextField();
        layout.putConstraint(SpringLayout.NORTH,txtIme,30,SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST,txtIme,30,SpringLayout.EAST,lblIme);
        txtIme.setPreferredSize(new Dimension(200,20));

        JLabel lblPrezime=new JLabel("Unesite prezime");
        layout.putConstraint(SpringLayout.NORTH,lblPrezime,30,SpringLayout.SOUTH,lblIme);
        layout.putConstraint(SpringLayout.WEST,lblPrezime,30,SpringLayout.WEST,this);
        lblIme.setPreferredSize(new Dimension(100,20));

        JTextField txtPrezime=new JTextField();
        layout.putConstraint(SpringLayout.NORTH,txtPrezime,30,SpringLayout.SOUTH,txtIme);
        layout.putConstraint(SpringLayout.WEST,txtPrezime,30,SpringLayout.EAST,lblPrezime);
        txtPrezime.setPreferredSize(new Dimension(200,20));

        JLabel lblPozicija=new JLabel("Unesite poziciju");
        layout.putConstraint(SpringLayout.NORTH,lblPozicija,30,SpringLayout.SOUTH,lblPrezime);
        layout.putConstraint(SpringLayout.WEST,lblPozicija,30,SpringLayout.WEST,this);
        lblIme.setPreferredSize(new Dimension(100,20));

       /* JTextField txtPozicija=new JTextField();
        layout.putConstraint(SpringLayout.NORTH,txtPozicija,30,SpringLayout.SOUTH,txtPrezime);
        layout.putConstraint(SpringLayout.WEST,txtPozicija,30,SpringLayout.EAST,lblPozicija);
        txtPozicija.setPreferredSize(new Dimension(200,20));*/

        String[] pozicije=new String[] {"Pekar","Direktor","Pakeraj","Paraćin","Administracija","Prodaja","Vozač"};
        JComboBox<String> position=new JComboBox<>(pozicije);
        layout.putConstraint(SpringLayout.NORTH,position,30,SpringLayout.SOUTH,txtPrezime);
        layout.putConstraint(SpringLayout.WEST,position,30,SpringLayout.EAST,lblPozicija);
        position.setPreferredSize(new Dimension(200,20));

        JButton btnSnimi=new JButton("Snimi");
        layout.putConstraint(SpringLayout.SOUTH,btnSnimi,300,SpringLayout.SOUTH,this);
        layout.putConstraint(SpringLayout.EAST,btnSnimi,450,SpringLayout.EAST,this);
        btnSnimi.setPreferredSize(new Dimension(100,20));
        btnSnimi.addActionListener(new SaveAction());

        MainWindow.components.put("txtIme",txtIme);
        MainWindow.components.put("txtPrezime",txtPrezime);
       // MainWindow.components.put("txtPozicija",txtPozicija);
        MainWindow.components.put("newWorkerPanel",this);
        MainWindow.components.put("comboPosition",position);



        this.add(btnSnimi);
       // this.add(txtPozicija);
        this.add(position);
        this.add(lblPozicija);
        this.add(txtPrezime);
        this.add(lblPrezime);
        this.add(txtIme);
        this.add(lblIme);
        this.setVisible(true);
    }
}
