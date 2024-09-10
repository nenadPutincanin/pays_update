package com.project.actions;

import com.project.components.MainWindow;
import com.project.components.ReportPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame= (JFrame) MainWindow.components.get("frame");
        ReportPanel panel=new ReportPanel(frame);
    }
}
