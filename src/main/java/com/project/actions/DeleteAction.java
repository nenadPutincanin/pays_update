package com.project.actions;

import com.project.DAO.PaysDAO;
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

import static javax.swing.JOptionPane.showMessageDialog;

public class DeleteAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table= (JTable) MainWindow.components.get("table");
        JLabel lblPotrazuje= (JLabel) MainWindow.components.get("lblPotrazuje");
        JLabel lblDuguje= (JLabel) MainWindow.components.get("lblDuguje");
        JLabel lblSaldo= (JLabel) MainWindow.components.get("saldo");

        int row= table.getSelectedRow();
        TableDAO model= (TableDAO) table.getModel();
        Worker w=model.getWorker(row);
        int workerId=w.getWorkerId();

        Session session= HibernateUtil.getSessionFactory().openSession();
        Query<Worker> query=session.createQuery("FROM Worker WHERE workerId=:workerId ", Worker.class);
        query.setParameter("workerId",workerId);
        Worker worker=query.getSingleResult();
        Transaction transaction=session.beginTransaction();
        session.remove(worker);
        transaction.commit();
        session.close();

        table.setModel(new TableDAO());

        lblPotrazuje.setText("Ukupno zarađeno: "+ PaysDAO.potrazuje());
        lblDuguje.setText("Ukupno isplaćeno: "+ PaysDAO.duguje());
        lblSaldo.setText("Saldo: " + (PaysDAO.potrazuje()-PaysDAO.duguje()));


        JFrame fr = (JFrame) MainWindow.components.get("frame");
        String message = "Uspesno ste obrisali radnika";
        showMessageDialog(fr, message);


    }
}
