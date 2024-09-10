package com.project.components;

import com.project.DAO.TableDAO;
import com.project.actions.SaveEarning;
import com.project.models.Worker;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ImportEarningsPanel extends JDialog {

    public ImportEarningsPanel(JFrame frame){
        super();
        this.setSize(new Dimension(500, 400));
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        setModalityType(ModalityType.APPLICATION_MODAL);
        this.setTitle("Unos zarade");

        JLabel sifra=new JLabel("Šifra radnika");
        layout.putConstraint(SpringLayout.NORTH,sifra,10,SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST,sifra,10,SpringLayout.WEST,this);
        sifra.setPreferredSize(new Dimension(100,20));

        JTextField txtSifra=new JTextField();
        txtSifra.setEnabled(false);
        layout.putConstraint(SpringLayout.NORTH,txtSifra,10,SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST,txtSifra,10,SpringLayout.EAST,sifra);
        txtSifra.setPreferredSize(new Dimension(100,20));
        MainWindow.components.put("txtSifraEarnings",txtSifra);

        JLabel lblDatum=new JLabel("Datum");
        layout.putConstraint(SpringLayout.NORTH,lblDatum,30,SpringLayout.SOUTH,sifra);
        layout.putConstraint(SpringLayout.WEST,lblDatum,10,SpringLayout.WEST,this);
        lblDatum.setPreferredSize(new Dimension(100,20));

        JTextField txtDatum=new JTextField();
        txtDatum.setText(String.valueOf(LocalDate.now()));
        layout.putConstraint(SpringLayout.NORTH,txtDatum,30,SpringLayout.SOUTH,txtSifra);
        layout.putConstraint(SpringLayout.WEST,txtDatum,10,SpringLayout.EAST,lblDatum);
        txtDatum.setPreferredSize(new Dimension(200,20));
        MainWindow.components.put("txtDatum",txtDatum);

        JLabel lblZarada=new JLabel("Unesite zaradu");
        layout.putConstraint(SpringLayout.NORTH,lblZarada,30,SpringLayout.SOUTH,lblDatum);
        layout.putConstraint(SpringLayout.WEST,lblZarada,10,SpringLayout.WEST,this);
        lblZarada.setPreferredSize(new Dimension(100,20));

        JTextField txtZarada=new JTextField();
        layout.putConstraint(SpringLayout.NORTH,txtZarada,30,SpringLayout.SOUTH,txtDatum);
        layout.putConstraint(SpringLayout.WEST,txtZarada,10,SpringLayout.EAST,lblZarada);
        txtZarada.setPreferredSize(new Dimension(200,20));
        MainWindow.components.put("txtZarada",txtZarada);

        JLabel lblOpis=new JLabel("Unesite opis");
        layout.putConstraint(SpringLayout.NORTH,lblOpis,30,SpringLayout.SOUTH,lblZarada);
        layout.putConstraint(SpringLayout.WEST,lblOpis,10,SpringLayout.WEST,this);
        lblOpis.setPreferredSize(new Dimension(100,20));

        JTextField txtOpis=new JTextField();
        layout.putConstraint(SpringLayout.NORTH,txtOpis,30,SpringLayout.SOUTH,txtZarada);
        layout.putConstraint(SpringLayout.WEST,txtOpis,10,SpringLayout.EAST,lblOpis);
        txtOpis.setPreferredSize(new Dimension(300,20));
        MainWindow.components.put("txtOpisEarnings",txtOpis);


        JButton btnSnimi=new JButton("Snimi");
        layout.putConstraint(SpringLayout.SOUTH,btnSnimi,300,SpringLayout.SOUTH,this);
        layout.putConstraint(SpringLayout.EAST,btnSnimi,450,SpringLayout.EAST,this);
        btnSnimi.setPreferredSize(new Dimension(100,20));
        btnSnimi.addActionListener(new SaveEarning());

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
        MainWindow.components.put("ImportEarningsPanel",this);
        this.add(txtOpis);
        this.add(lblOpis);
        this.add(btnSnimi);
        this.add(sifra);
        this.add(txtSifra);
        this.add(lblDatum);
        this.add(txtDatum);
        this.add(lblZarada);
        this.add(txtZarada);


        this.setVisible(true);
    }
}
