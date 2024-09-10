package com.project.actions;

import com.project.DAO.TableDAO;
import com.project.DB.HibernateUtil;
import com.project.components.MainWindow;
import com.project.components.UpdateWorkerPanel;
import com.project.models.Worker;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class UpdateWorkerAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame= (JFrame) MainWindow.components.get("frame");

        UpdateWorkerPanel panel=new UpdateWorkerPanel(frame);

      /*  JFrame fr = (JFrame) MainWindow.components.get("frame");
        String message = "Uspesno ste ažurirali radnika";
        showMessageDialog(fr, message);*/







    }
}
