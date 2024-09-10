package com.project.components;

import com.project.DAO.TableDAO;
import com.project.actions.SavePayments;
import com.project.models.Worker;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ImportPaymentPanel extends JDialog {

    public ImportPaymentPanel (JFrame frame){
        super();
        this.setSize(new Dimension(500, 400));
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        setModalityType(ModalityType.APPLICATION_MODAL);
        this.setTitle("Unos isplate");

        JLabel sifra=new JLabel("Šifra radnika");
        layout.putConstraint(SpringLayout.NORTH,sifra,10,SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST,sifra,10,SpringLayout.WEST,this);
        sifra.setPreferredSize(new Dimension(100,20));


        JTextField txtSifra=new JTextField();
        txtSifra.setEnabled(false);
        layout.putConstraint(SpringLayout.NORTH,txtSifra,10,SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST,txtSifra,10,SpringLayout.EAST,sifra);
        txtSifra.setPreferredSize(new Dimension(100,20));
        MainWindow.components.put("sifraPayments",txtSifra);

        JLabel lblDatum=new JLabel("Datum");
        layout.putConstraint(SpringLayout.NORTH,lblDatum,30,SpringLayout.SOUTH,sifra);
        layout.putConstraint(SpringLayout.WEST,lblDatum,10,SpringLayout.WEST,this);
        lblDatum.setPreferredSize(new Dimension(100,20));

        JTextField txtDatum=new JTextField();
        txtDatum.setText(String.valueOf(LocalDate.now()));
        layout.putConstraint(SpringLayout.NORTH,txtDatum,30,SpringLayout.SOUTH,txtSifra);
        layout.putConstraint(SpringLayout.WEST,txtDatum,10,SpringLayout.EAST,lblDatum);
        txtDatum.setPreferredSize(new Dimension(200,20));
        MainWindow.components.put("datumaPayments",txtDatum);

        JLabel lblIsplata=new JLabel("Unesite isplata");
        layout.putConstraint(SpringLayout.NORTH,lblIsplata,30,SpringLayout.SOUTH,lblDatum);
        layout.putConstraint(SpringLayout.WEST,lblIsplata,10,SpringLayout.WEST,this);
        lblIsplata.setPreferredSize(new Dimension(100,20));

        JTextField txtIsplata=new JTextField();
        layout.putConstraint(SpringLayout.NORTH,txtIsplata,30,SpringLayout.SOUTH,txtDatum);
        layout.putConstraint(SpringLayout.WEST,txtIsplata,10,SpringLayout.EAST,lblIsplata);
        txtIsplata.setPreferredSize(new Dimension(200,20));
        MainWindow.components.put("txtIsplata",txtIsplata);


        JLabel lblOpisIsplata=new JLabel("Unesite opis");
        layout.putConstraint(SpringLayout.NORTH,lblOpisIsplata,30,SpringLayout.SOUTH,lblIsplata);
        layout.putConstraint(SpringLayout.WEST,lblOpisIsplata,10,SpringLayout.WEST,this);
        lblIsplata.setPreferredSize(new Dimension(100,20));

        JTextField txtOpisIsplata=new JTextField();
        layout.putConstraint(SpringLayout.NORTH,txtOpisIsplata,30,SpringLayout.SOUTH,txtIsplata);
        layout.putConstraint(SpringLayout.WEST,txtOpisIsplata,40,SpringLayout.EAST,lblOpisIsplata);
        txtOpisIsplata.setPreferredSize(new Dimension(300,20));
        MainWindow.components.put("txtOpisIsplata",txtOpisIsplata);

        JButton btnSnimi=new JButton("Snimi");
        layout.putConstraint(SpringLayout.SOUTH,btnSnimi,300,SpringLayout.SOUTH,this);
        layout.putConstraint(SpringLayout.EAST,btnSnimi,450,SpringLayout.EAST,this);
        btnSnimi.setPreferredSize(new Dimension(100,20));
        btnSnimi.addActionListener(new SavePayments());

        JTable table = (JTable) MainWindow.components.get("table");
        int row = table.getSelectedRow();
        if(row<0){
            JFrame fr= (JFrame) MainWindow.components.get("frame");
            String message="Morate izabrati radnika";
            JOptionPane.showMessageDialog(fr,message);
            return;
        }else {
            TableDAO model = (TableDAO) table.getModel();
            Worker w = model.getWorker(row);
            txtSifra.setText(String.valueOf(w.getWorkerId()));

        }
        MainWindow.components.put("ImportPaymentPanel",this);
        this.add(lblOpisIsplata);
        this.add(txtOpisIsplata);
        this.add(btnSnimi);
        this.add(sifra);
        this.add(txtSifra);
        this.add(lblDatum);
        this.add(txtDatum);
        this.add(lblIsplata);
        this.add(txtIsplata);


        this.setVisible(true);
    }
}
