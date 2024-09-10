package com.project.components;

import com.project.DAO.PaysDAO;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ReportPanel extends JDialog {

    public ReportPanel(JFrame frame){
        super();
        this.setTitle("Izveštaj po sektorima");
        this.setSize(700,500);
        SpringLayout layout=new SpringLayout();
        this.setLayout(layout);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Border border=BorderFactory.createLineBorder(Color.BLACK);


        JLabel ukupnoProdaja=new JLabel("Prodaja saldo: ");
        ukupnoProdaja.setPreferredSize(new Dimension(300,30));
        layout.putConstraint(SpringLayout.NORTH, ukupnoProdaja, 15,SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST, ukupnoProdaja, 30,SpringLayout.WEST,this);
        double prodSaldo=PaysDAO.sektorSum("Prodaja");
        ukupnoProdaja.setText(String.format("Prodaja saldo: %,.2f",prodSaldo));
        ukupnoProdaja.setFont(new Font("Calibri",Font.BOLD,18));
        ukupnoProdaja.setBorder(border);
        ukupnoProdaja.setBackground(Color.WHITE);
        ukupnoProdaja.setOpaque(true);

        JLabel ukupnoPakeraj=new JLabel("Pakeraj saldo: ");
        ukupnoPakeraj.setPreferredSize(new Dimension(300,30));
        layout.putConstraint(SpringLayout.NORTH, ukupnoPakeraj, 15,SpringLayout.SOUTH,ukupnoProdaja);
        layout.putConstraint(SpringLayout.WEST, ukupnoPakeraj, 30,SpringLayout.WEST,this);
        double pakSaldo=PaysDAO.sektorSum("Pakeraj");
        ukupnoPakeraj.setText(String.format("Pakeraj saldo: %,.2f",pakSaldo));
        ukupnoPakeraj.setFont(new Font("Calibri",Font.BOLD,18));
        ukupnoPakeraj.setBorder(border);
        ukupnoPakeraj.setBackground(Color.WHITE);
        ukupnoPakeraj.setOpaque(true);

        JLabel ukupnoDirektori=new JLabel("Direktori saldo: ");
        ukupnoDirektori.setPreferredSize(new Dimension(300,30));
        layout.putConstraint(SpringLayout.NORTH, ukupnoDirektori, 15,SpringLayout.SOUTH,ukupnoPakeraj);
        layout.putConstraint(SpringLayout.WEST, ukupnoDirektori, 30,SpringLayout.WEST,this);
        double dirSaldo=PaysDAO.sektorSum("Direktor");
        ukupnoDirektori.setText(String.format("Direktori saldo: %,.2f",dirSaldo));
        ukupnoDirektori.setFont(new Font("Calibri",Font.BOLD,18));
        ukupnoDirektori.setBorder(border);
        ukupnoDirektori.setBackground(Color.WHITE);
        ukupnoDirektori.setOpaque(true);

        JLabel ukupnoPekari=new JLabel("Pekari saldo: ");
        ukupnoPekari.setPreferredSize(new Dimension(300,30));
        layout.putConstraint(SpringLayout.NORTH, ukupnoPekari, 15,SpringLayout.SOUTH,ukupnoDirektori);
        layout.putConstraint(SpringLayout.WEST, ukupnoPekari, 30,SpringLayout.WEST,this);
        double pekSaldo=PaysDAO.sektorSum("Pekar");
        ukupnoPekari.setText(String.format("Pekari saldo: %,.2f",pekSaldo));
        ukupnoPekari.setFont(new Font("Calibri",Font.BOLD,18));
        ukupnoPekari.setBorder(border);
        ukupnoPekari.setBackground(Color.WHITE);
        ukupnoPekari.setOpaque(true);

        JLabel ukupnoAdmn=new JLabel("Administracija saldo: ");
        ukupnoAdmn.setPreferredSize(new Dimension(300,30));
        layout.putConstraint(SpringLayout.NORTH, ukupnoAdmn, 15,SpringLayout.SOUTH,ukupnoPekari);
        layout.putConstraint(SpringLayout.WEST, ukupnoAdmn, 30,SpringLayout.WEST,this);
        double admSaldo=PaysDAO.sektorSum("Administracija");
        ukupnoAdmn.setText(String.format("Administracija saldo: %,.2f",admSaldo));
        ukupnoAdmn.setFont(new Font("Calibri",Font.BOLD,18));
        ukupnoAdmn.setBorder(border);
        ukupnoAdmn.setBackground(Color.WHITE);
        ukupnoAdmn.setOpaque(true);

        JLabel ukupnoVozaci=new JLabel("Vozači saldo: ");
        ukupnoVozaci.setPreferredSize(new Dimension(300,30));
        layout.putConstraint(SpringLayout.NORTH, ukupnoVozaci, 15,SpringLayout.SOUTH,ukupnoAdmn);
        layout.putConstraint(SpringLayout.WEST, ukupnoVozaci, 30,SpringLayout.WEST,this);
        double vozSaldo=PaysDAO.sektorSum("Vozač");
        ukupnoVozaci.setText(String.format("Vozači saldo: %,.2f",vozSaldo));
        ukupnoVozaci.setFont(new Font("Calibri",Font.BOLD,18));
        ukupnoVozaci.setBorder(border);
        ukupnoVozaci.setBackground(Color.WHITE);
        ukupnoVozaci.setOpaque(true);

        JLabel ukupnoParacin=new JLabel("Paraćin saldo: ");
        ukupnoParacin.setPreferredSize(new Dimension(300,30));
        layout.putConstraint(SpringLayout.NORTH, ukupnoParacin, 15,SpringLayout.SOUTH,ukupnoVozaci);
        layout.putConstraint(SpringLayout.WEST, ukupnoParacin, 30,SpringLayout.WEST,this);
        double parSaldo=PaysDAO.sektorSum("Paraćin");
        ukupnoParacin.setText(String.format("Paraćin saldo: %,.2f",parSaldo));
        ukupnoParacin.setFont(new Font("Calibri",Font.BOLD,18));
        ukupnoParacin.setBorder(border);
        ukupnoParacin.setBackground(Color.WHITE);
        ukupnoParacin.setOpaque(true);




        this.add(ukupnoProdaja);
        this.add(ukupnoParacin);
        this.add(ukupnoVozaci);
        this.add(ukupnoAdmn);
        this.add(ukupnoPekari);
        this.add(ukupnoDirektori);
        this.add(ukupnoPakeraj);
        this.setVisible(true);
    }
}
