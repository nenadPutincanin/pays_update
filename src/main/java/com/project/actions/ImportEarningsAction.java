package com.project.actions;

import com.project.components.ImportEarningsPanel;
import com.project.components.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportEarningsAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame= (JFrame) MainWindow.components.get("frame");
        ImportEarningsPanel panel=new ImportEarningsPanel(frame);
    }
}
