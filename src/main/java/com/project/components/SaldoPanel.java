package com.project.components;

import com.project.DAO.PaysDAO;
import com.project.DAO.PrintDAO;
import com.project.DAO.SaldoTableDAO;
import com.project.DAO.TableDAO;
import com.project.actions.ExcellAction;
import com.project.models.Worker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

public class SaldoPanel extends JDialog {

    public SaldoPanel(JFrame frame){
        super();
        this.setTitle("Saldo radnika");
        this.setSize(700,500);
        this.setLayout(new BorderLayout());
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JTable tableSaldo=new JTable(new SaldoTableDAO());
        JScrollPane paneSaldo=new JScrollPane(tableSaldo);

        JPanel panelSaldo=new JPanel();
        SpringLayout layout=new SpringLayout();
        panelSaldo.setLayout(layout);
        panelSaldo.setSize(700,200);
        panelSaldo.setPreferredSize(new Dimension(700,50));
        panelSaldo.setMinimumSize(new Dimension(500,50));
        panelSaldo.setMaximumSize(new Dimension(700,50));

        JLabel lblUkupnoZaradio=new JLabel("Ukupno zaradjeno:");
        lblUkupnoZaradio.setSize(200,100);
        layout.putConstraint(SpringLayout.SOUTH,lblUkupnoZaradio,-30,SpringLayout.SOUTH,panelSaldo);
        layout.putConstraint(SpringLayout.WEST,lblUkupnoZaradio,10,SpringLayout.WEST,panelSaldo);
        int workerId=PaysDAO.WorkerId();
        double zaradjeno=PaysDAO.zaradjeno(workerId);
        lblUkupnoZaradio.setText("Ukupno zaradjeno: " + String.valueOf(zaradjeno));
        lblUkupnoZaradio.setForeground(Color.red);
        panelSaldo.add(lblUkupnoZaradio);

        JLabel lblUkupnoIsplaceno=new JLabel("Ukupno isplaceno:");
        lblUkupnoIsplaceno.setSize(200,100);
        layout.putConstraint(SpringLayout.NORTH,lblUkupnoIsplaceno,5,SpringLayout.SOUTH,lblUkupnoZaradio);
        layout.putConstraint(SpringLayout.WEST,lblUkupnoIsplaceno,10,SpringLayout.WEST,panelSaldo);
        double isplaceno=PaysDAO.isplaceno(workerId);
        lblUkupnoIsplaceno.setText("Ukupno isplaceno: " + String.valueOf(isplaceno));
        lblUkupnoIsplaceno.setForeground(Color.red);
        panelSaldo.add(lblUkupnoIsplaceno);




        MainWindow.components.put("tableSaldo",tableSaldo);

        JMenuBar menuBar=new JMenuBar();
        JMenu fileMenu=new JMenu("File");
        JMenuItem printItem=new JMenuItem("Print");
        JMenuItem excelItem=new JMenuItem("Excel");
        excelItem.addActionListener(new ExcellAction());
        MainWindow.components.put("excel",excelItem);
        printItem.addActionListener((e)->{
          try {
              tableSaldo.print();

          }catch (PrinterException ex){
              ex.printStackTrace();
          }
        });
        //printItem.addActionListener(new PrintDAO());
        MainWindow.components.put("saldoPanel",this);
        fileMenu.add(printItem);
        fileMenu.add(excelItem);
        menuBar.add(fileMenu);





        this.add(panelSaldo,BorderLayout.SOUTH);
        this.setJMenuBar(menuBar);
        this.add(paneSaldo,BorderLayout.CENTER);
        this.setVisible(true);
    }

}
