package com.project.actions;


import com.project.components.ImportPaymentPanel;
import com.project.components.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportPaymentAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame= (JFrame) MainWindow.components.get("frame");
        ImportPaymentPanel panel=new ImportPaymentPanel(frame);
    }
}
