package com.project.actions;

import com.project.DAO.TableDAO;
import com.project.DB.HibernateUtil;
import com.project.components.MainWindow;
import com.project.models.Worker;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveUpdateAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JTable table= (JTable) MainWindow.components.get("table");
            JTextField sifra= (JTextField) MainWindow.components.get("sifra");
            JTextField imeRadnika = (JTextField) MainWindow.components.get("textIme");
            JTextField prezime = (JTextField) MainWindow.components.get("textPrezime");
            JTextField pozicija = (JTextField) MainWindow.components.get("textPozicija");
            JDialog updatePanel= (JDialog) MainWindow.components.get("updatePanel");


            if(sifra.getText().equals("") || imeRadnika.getText().equals("") || prezime.getText().equals("")|| pozicija.getText().equals("")){
                JOptionPane.showMessageDialog(updatePanel, "Sva polja moraju biti popunjena");
                return;
            }

            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Worker> query = session.createQuery("FROM Worker WHERE workerId=:workerId", Worker.class);

            int workerId= Integer.parseInt(sifra.getText());
            query.setParameter("workerId",workerId);
            Worker worker=query.getSingleResult();
            worker.setWorkerId(Integer.parseInt(sifra.getText()));
            worker.setFirstName(imeRadnika.getText());
            worker.setLastName(prezime.getText());
            worker.setPosition(pozicija.getText());

            Transaction transaction= session.beginTransaction();
            session.merge(worker);
            transaction.commit();

            table.setModel(new TableDAO());

            JOptionPane.showMessageDialog(updatePanel,"Uspešno ste ažurirali radnika");



            session.close();
            updatePanel.setVisible(false);


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

