package com.project.components;

import com.project.DAO.PaysDAO;
import com.project.DAO.TableDAO;
import com.project.actions.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MainWindow extends JFrame {
    public static HashMap<String,Object> components=new HashMap<>();
    public MainWindow(){

        super("Plate");
        this.setSize(800,600);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        JPanel panelTable=new JPanel();
        panelTable.setMinimumSize(new Dimension(400,400));
        panelTable.setMaximumSize(new Dimension(600,400));
        panelTable.setPreferredSize(new Dimension(500,400));
        panelTable.setLayout(new BoxLayout(panelTable,BoxLayout.X_AXIS));

        JPanel panelButtons=new JPanel();
        SpringLayout layout=new SpringLayout();
        panelButtons.setLayout(layout);

        JPanel panelInfo=new JPanel();

        panelInfo.setLayout(new BoxLayout(panelInfo,BoxLayout.Y_AXIS));
        panelInfo.setPreferredSize(new Dimension(100,100));

        JTable table=new JTable(new TableDAO());
        table.getColumnModel().getColumn(0).setPreferredWidth(3);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(55);
        table.setFont(new Font("Arial",Font.PLAIN,14));
        JScrollPane pane=new JScrollPane(table);
        panelTable.add(pane);

        JButton btnNew=new JButton("Novi radnik");
        layout.putConstraint(SpringLayout.NORTH,btnNew,10,SpringLayout.NORTH,panelButtons);
        layout.putConstraint(SpringLayout.WEST,btnNew,50,SpringLayout.WEST,panelButtons);
        btnNew.setPreferredSize(new Dimension(100,20));
        panelButtons.add(btnNew);
        btnNew.addActionListener(new NewWorkerActions());

        JButton btnUpdate=new JButton("Azuriraj ");
        layout.putConstraint(SpringLayout.NORTH,btnUpdate,10,SpringLayout.SOUTH,btnNew);
        layout.putConstraint(SpringLayout.WEST,btnUpdate,50,SpringLayout.WEST,panelButtons);
        btnUpdate.setPreferredSize(new Dimension(100,20));
        panelButtons.add(btnUpdate);
        btnUpdate.addActionListener(new UpdateWorkerAction());

        JButton btnDelete=new JButton("Obrisi  ");
        layout.putConstraint(SpringLayout.NORTH,btnDelete,10,SpringLayout.SOUTH,btnUpdate);
        layout.putConstraint(SpringLayout.WEST,btnDelete,50,SpringLayout.WEST,panelButtons);
        btnDelete.setPreferredSize(new Dimension(100,20));
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(new DeleteAction());

        JButton btnZarada=new JButton("Unesi zaradu  ");
        layout.putConstraint(SpringLayout.NORTH,btnZarada,50,SpringLayout.SOUTH,btnDelete);
        layout.putConstraint(SpringLayout.WEST,btnZarada,50,SpringLayout.WEST,panelButtons);
        btnZarada.setPreferredSize(new Dimension(200,20));
        panelButtons.add(btnZarada);
        btnZarada.addActionListener(new ImportEarningsAction());

        JButton btnIsplata=new JButton("Unesi isplatu  ");
        layout.putConstraint(SpringLayout.NORTH,btnIsplata,10,SpringLayout.SOUTH,btnZarada);
        layout.putConstraint(SpringLayout.WEST,btnIsplata,50,SpringLayout.WEST,panelButtons);
        btnIsplata.setPreferredSize(new Dimension(200,20));
        panelButtons.add(btnIsplata);
        btnIsplata.addActionListener(new ImportPaymentAction());

        JButton btnSaldo=new JButton("Prikaži saldo ");
        layout.putConstraint(SpringLayout.NORTH,btnSaldo,10,SpringLayout.SOUTH,btnIsplata);
        layout.putConstraint(SpringLayout.WEST,btnSaldo,50,SpringLayout.WEST,panelButtons);
        btnSaldo.setPreferredSize(new Dimension(200,20));
        panelButtons.add(btnSaldo);
        btnSaldo.addActionListener(new SaldoAction());

        JButton izvSektor=new JButton("Izveštaj ");
        layout.putConstraint(SpringLayout.NORTH,izvSektor,10,SpringLayout.SOUTH,btnSaldo);
        layout.putConstraint(SpringLayout.WEST,izvSektor,50,SpringLayout.WEST,panelButtons);
        izvSektor.setPreferredSize(new Dimension(200,20));
        panelButtons.add(izvSektor);
        izvSektor.addActionListener(new ReportAction());


        JLabel lblPotrazuje=new JLabel("Ukupno zarađeno: ");
        lblPotrazuje.setPreferredSize(new Dimension(200,20));
        panelInfo.add(lblPotrazuje);
        double potrayuje=PaysDAO.potrazuje();
        lblPotrazuje.setText(String.format("Ukupno zarađeno:  %,.2f",potrayuje));
        lblPotrazuje.setForeground(Color.BLUE);

        JLabel lblDuguje=new JLabel("Ukupno isplaćeno: ");
        lblDuguje.setPreferredSize(new Dimension(200,20));
        panelInfo.add(lblDuguje);
        double duguje=PaysDAO.duguje();
        lblDuguje.setText(String.format("Ukupno isplaćeno:  %,.2f",duguje));
        //lblDuguje.setText("Ukupno isplaćeno: " + PaysDAO.duguje());
        lblDuguje.setForeground(Color.BLUE);

        JLabel lblSaldo=new JLabel("Saldo: ");
        lblSaldo.setPreferredSize(new Dimension(200,20));
        panelInfo.add(lblSaldo);
        double saldo=PaysDAO.potrazuje()-PaysDAO.duguje();
        lblSaldo.setText(String.format("Ukupan saldo:  %,.2f",saldo));
       // lblSaldo.setText("Saldo: " + (PaysDAO.potrazuje()-PaysDAO.duguje()));
        lblSaldo.setForeground(Color.RED);

        MenuBar mainMenu=new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem closeItem = new MenuItem("Close");
        closeItem.addActionListener(e-> System.exit(0));

        fileMenu.add(closeItem);
        mainMenu.add(fileMenu);

        components.put("saldo",lblSaldo);
        components.put("lblPotrazuje",lblPotrazuje);
        components.put("lblDuguje",lblDuguje);
        components.put("frame",this);
        components.put("table",table);

        this.setMenuBar(mainMenu);
        this.add(panelInfo,BorderLayout.SOUTH);
        this.add(panelTable,BorderLayout.LINE_START);
        this.add(panelButtons,BorderLayout.CENTER);

    }
}
