package com.project.actions;

import com.project.DAO.PaysDAO;
import com.project.DAO.TableDAO;
import com.project.DB.HibernateUtil;
import com.project.components.MainWindow;
import com.project.models.Pays;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class SavePayments implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table= (JTable) MainWindow.components.get("table");
        JLabel lblDuguje= (JLabel) MainWindow.components.get("lblDuguje");
        JLabel lblSaldo= (JLabel) MainWindow.components.get("saldo");
        JTextField sifra= (JTextField) MainWindow.components.get("sifraPayments");
        JTextField datum= (JTextField) MainWindow.components.get("datumaPayments");
        JTextField isplata= (JTextField) MainWindow.components.get("txtIsplata");
        JTextField opis= (JTextField) MainWindow.components.get("txtOpisIsplata");
        JDialog ipp= (JDialog) MainWindow.components.get("ImportPaymentPanel");

        if(sifra.getText().equals("") || datum.getText().equals("") || isplata.getText().equals("")|| opis.getText().equals("")){
            JOptionPane.showMessageDialog(ipp, "Sva polja moraju biti popunjena");
            return;
        }

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Pays> query = session.createQuery("FROM Pays", Pays.class);

            Pays pay=new Pays();
            pay.setWorkerId(Integer.parseInt(sifra.getText()));
            pay.setDate(LocalDate.parse(datum.getText()));
            pay.setPayments(Double.parseDouble(isplata.getText()));
            pay.setDescription(opis.getText());

            Transaction transaction= session.beginTransaction();
            session.persist(pay);
            transaction.commit();
            session.close();



            table.setModel(new TableDAO());
            lblDuguje.setText("Ukupno isplaćeno: "+ PaysDAO.duguje());
            lblSaldo.setText("Saldo: "+ (PaysDAO.potrazuje()-PaysDAO.duguje()));

            ipp.setVisible(false);


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
