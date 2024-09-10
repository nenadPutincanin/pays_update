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

import static javax.swing.JOptionPane.*;

public class SaveAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

            JTextField ime = (JTextField) MainWindow.components.get("txtIme");
            JTextField prezime = (JTextField) MainWindow.components.get("txtPrezime");
            JComboBox<String> pozicija = (JComboBox<String>) MainWindow.components.get("comboPosition");
            JDialog workerPanel = (JDialog) MainWindow.components.get("newWorkerPanel");
            JTable table = (JTable) MainWindow.components.get("table");

        try {




            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Worker> query = session.createQuery("FROM Worker", Worker.class);


                Worker worker = new Worker();
                worker.setFirstName(ime.getText());
                worker.setLastName(prezime.getText());
                worker.setPosition((String) pozicija.getSelectedItem());

                if(ime.getText().equals("") || prezime.getText().equals("") || pozicija.getSelectedItem().equals("")){
                    JOptionPane.showMessageDialog(workerPanel, "Sva polja moraju biti popunjena");
                    return;
                }

                Transaction transaction = session.beginTransaction();
                session.persist(worker);
                transaction.commit();
                session.close();
                table.setModel(new TableDAO());


                workerPanel.setVisible(false);

                JFrame fr = (JFrame) MainWindow.components.get("frame");
                String message = "Uspesno ste snimili radnika";
                showMessageDialog(fr, message);



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

