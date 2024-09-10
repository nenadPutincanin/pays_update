package com.project.actions;

import com.project.components.MainWindow;
import com.project.components.NewWorkerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewWorkerActions implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame= (JFrame) MainWindow.components.get("frame");
        NewWorkerPanel panel=new NewWorkerPanel(frame);
    }
}
