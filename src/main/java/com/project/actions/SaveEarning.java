package com.project.actions;

import com.project.DAO.PaysDAO;
import com.project.DAO.TableDAO;
import com.project.DB.HibernateUtil;
import com.project.components.ImportEarningsPanel;
import com.project.components.MainWindow;
import com.project.models.Pays;

import org.hibernate.*;
import org.hibernate.query.Query;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class SaveEarning implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table= (JTable) MainWindow.components.get("table");
        JLabel lblPotrazuje= (JLabel) MainWindow.components.get("lblPotrazuje");
        JTextField sifra= (JTextField) MainWindow.components.get("txtSifraEarnings");
        JLabel lblSaldo= (JLabel) MainWindow.components.get("saldo");
        JTextField datum= (JTextField) MainWindow.components.get("txtDatum");
        JTextField zarada= (JTextField) MainWindow.components.get("txtZarada");
        JTextField opis= (JTextField) MainWindow.components.get("txtOpisEarnings");
        JDialog iep= (JDialog) MainWindow.components.get("ImportEarningsPanel");
        JDialog earningPanel = (JDialog) MainWindow.components.get("ImportEarningsPanel");

        if(sifra.getText().equals("") || datum.getText().equals("") || zarada.getText().equals("")|| opis.getText().equals("")){
            JOptionPane.showMessageDialog(earningPanel, "Sva polja moraju biti popunjena");
            return;
        }
try {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Pays> query = session.createQuery("FROM Pays", Pays.class);

    Pays pay=new Pays();
    pay.setWorkerId(Integer.parseInt(sifra.getText()));
    pay.setDate(LocalDate.parse(datum.getText()));
    pay.setEarnings(Double.parseDouble(zarada.getText()));
    pay.setDescription(opis.getText());

    Transaction transaction= session.beginTransaction();
    session.persist(pay);
    transaction.commit();
    session.close();



    table.setModel(new TableDAO());
    lblPotrazuje.setText("Ukupno zarađeno: "+ PaysDAO.potrazuje());
    lblSaldo.setText("Saldo: "+ (PaysDAO.potrazuje()-PaysDAO.duguje()));



    iep.setVisible(false);


}catch (Exception ex){
    ex.printStackTrace();
}
    }
}
