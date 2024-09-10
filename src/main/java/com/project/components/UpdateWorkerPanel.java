package com.project.components;

import com.project.DAO.TableDAO;
import com.project.actions.SaveAction;
import com.project.actions.SaveUpdateAction;
import com.project.models.Worker;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;


public class UpdateWorkerPanel extends JDialog {

    public UpdateWorkerPanel(JFrame frame) {
        super();
        this.setSize(new Dimension(500, 400));
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        setModalityType(ModalityType.APPLICATION_MODAL);
        this.setTitle("Ažuriraj radnika");

        JLabel sifraRadnika= new JLabel("Šifra radnika");
        layout.putConstraint(SpringLayout.NORTH,sifraRadnika,10,SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST,sifraRadnika,10,SpringLayout.WEST,this);
        sifraRadnika.setPreferredSize(new Dimension(100,20));

        JTextField sifra=new JTextField();
        sifra.setEnabled(false);
        layout.putConstraint(SpringLayout.NORTH,sifra,10,SpringLayout.NORTH,this);
        layout.putConstraint(SpringLayout.WEST,sifra,10,SpringLayout.EAST,sifraRadnika);
        sifra.setPreferredSize(new Dimension(100,20));


        JLabel ime=new JLabel("Unesite ime");
        layout.putConstraint(SpringLayout.NORTH,ime,30,SpringLayout.NORTH,sifraRadnika);
        layout.putConstraint(SpringLayout.WEST,ime,10,SpringLayout.WEST,this);
        ime.setPreferredSize(new Dimension(100,20));

        JTextField textIme=new JTextField();
        layout.putConstraint(SpringLayout.NORTH,textIme,30,SpringLayout.NORTH,sifra);
        layout.putConstraint(SpringLayout.WEST,textIme,10,SpringLayout.EAST,ime);
        textIme.setPreferredSize(new Dimension(200,20));


        JLabel prezime=new JLabel("Unesite prezime");
        layout.putConstraint(SpringLayout.NORTH,prezime,30,SpringLayout.SOUTH,ime);
        layout.putConstraint(SpringLayout.WEST,prezime,10,SpringLayout.WEST,this);
        prezime.setPreferredSize(new Dimension(100,20));

        JTextField textPrezime=new JTextField();
        layout.putConstraint(SpringLayout.NORTH,textPrezime,30,SpringLayout.SOUTH,textIme);
        layout.putConstraint(SpringLayout.WEST,textPrezime,10,SpringLayout.EAST,prezime);
        textPrezime.setPreferredSize(new Dimension(200,20));


        JLabel pozicija=new JLabel("Unesite poziciju");
        layout.putConstraint(SpringLayout.NORTH,pozicija,30,SpringLayout.SOUTH,prezime);
        layout.putConstraint(SpringLayout.WEST,pozicija,10,SpringLayout.WEST,this);
        pozicija.setPreferredSize(new Dimension(100,20));

        JTextField textPozicija=new JTextField();
        layout.putConstraint(SpringLayout.NORTH,textPozicija,30,SpringLayout.SOUTH,textPrezime);
        layout.putConstraint(SpringLayout.WEST,textPozicija,10,SpringLayout.EAST,pozicija);
        textPozicija.setPreferredSize(new Dimension(200,20));


        JButton snimi=new JButton("Snimi");
        layout.putConstraint(SpringLayout.SOUTH,snimi,300,SpringLayout.SOUTH,this);
        layout.putConstraint(SpringLayout.EAST,snimi,450,SpringLayout.EAST,this);
        snimi.setPreferredSize(new Dimension(100,20));

        snimi.addActionListener(new SaveUpdateAction());


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
                sifra.setText(String.valueOf(w.getWorkerId()));
                textIme.setText(w.getFirstName());
                textPrezime.setText(w.getLastName());
                textPozicija.setText(w.getPosition());


            }







        MainWindow.components.put("sifra",sifra);
        MainWindow.components.put("textIme",textIme);
        MainWindow.components.put("textPrezime",textPrezime);
        MainWindow.components.put("textPozicija",textPozicija);
        MainWindow.components.put("updatePanel",this);


        this.add(snimi);
        this.add(textPozicija);
        this.add(pozicija);
        this.add(textPrezime);
        this.add(prezime);
        this.add(textIme);
        this.add(ime);
        this.add(sifra);
        this.add(sifraRadnika);
        this.setVisible(true);
    }
}
