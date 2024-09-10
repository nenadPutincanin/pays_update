package com.project.actions;

import com.project.DAO.PaysDAO;
import com.project.components.MainWindow;
import com.project.components.SaldoPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaldoAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame fr= (JFrame) MainWindow.components.get("frame");
        JTable table= (JTable) MainWindow.components.get("table");

      try {
          int row = table.getSelectedRow();

          if (row < 0) {
              String message = "Morate izabrati radnika";
              JOptionPane.showMessageDialog(fr, message);

              return;

          } else {
              SaldoPanel saldoPanel = new SaldoPanel(fr);
          }
      }catch (Exception ex){
          ex.printStackTrace();
      }






    }
}
