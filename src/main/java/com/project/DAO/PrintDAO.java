package com.project.DAO;

import com.project.components.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintDAO implements Printable, ActionListener {

    JTable tableSaldo= (JTable) MainWindow.components.get("tableSaldo");

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if(pageIndex>0){
            return NO_SUCH_PAGE;}

            Graphics2D gp= (Graphics2D) graphics;
            gp.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
           tableSaldo.print();

            return PAGE_EXISTS;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob job=PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok=job.printDialog();
        if(ok){
            try{
                job.print();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
