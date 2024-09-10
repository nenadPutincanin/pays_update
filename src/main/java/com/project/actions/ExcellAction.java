package com.project.actions;

import com.project.DAO.ExcellDAO;
import com.project.components.MainWindow;
import com.project.components.SaldoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ExcellAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table= (JTable) MainWindow.components.get("tableSaldo");
        JMenuItem exItem= (JMenuItem) MainWindow.components.get("excel");
        JDialog saldoPanel= (JDialog) MainWindow.components.get("saldoPanel");

        if(e.getSource() == exItem){
            JFileChooser fchoose = new JFileChooser();
            fchoose.setDialogTitle("Excell export");
            fchoose.setBackground( Color.BLUE);
            fchoose.setFont(Font.getFont("Calibri"));
            int option = fchoose.showSaveDialog(saldoPanel);
            if(option == JFileChooser.APPROVE_OPTION){
                String name = fchoose.getSelectedFile().getName();
                String path = fchoose.getSelectedFile().getParentFile().getPath();
                String file = path + "\\" + name + ".xls";
               ExcellDAO.writeToExcell(table, new File(file));
            }
        }
    }
}
