package com.project.DAO;

import com.project.DB.HibernateUtil;
import com.project.components.MainWindow;
import com.project.models.Pays;
import com.project.models.Worker;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PaysDAO {


    public static ArrayList<Pays> allSaldo(int workerId){
        Session session= HibernateUtil.getSessionFactory().openSession();
        Query<Pays> query=session.createQuery("FROM Pays WHERE workerId=:workerId", Pays.class);
        query.setParameter("workerId",workerId);
        ArrayList<Pays> saldo= (ArrayList<Pays>) query.getResultList();


        session.close();
        return saldo;
    }

    public static int WorkerId(){
        JTable table= (JTable) MainWindow.components.get("table");
        int row=table.getSelectedRow();
        TableDAO model= (TableDAO) table.getModel();
        Worker w=model.getWorker(row);
        int workId=w.getWorkerId();

        return workId;

    }

    public static String workerPosition(){
        JTable table= (JTable) MainWindow.components.get("table");
        int row=table.getSelectedRow();
        TableDAO model= (TableDAO) table.getModel();
        Worker w=model.getWorker(row);
        String position=w.getPosition();

        return position;

    }

    public static double potrazuje(){

        Session session= HibernateUtil.getSessionFactory().openSession();

        Query<Pays> query=session.createQuery("FROM Pays WHERE", Pays.class);
        ArrayList<Pays> saldo= (ArrayList<Pays>) query.getResultList();
       double sum=0;
      for(var s:saldo){
          sum+=s.getEarnings();
      }
        session.close();
      return sum;

    }

    public static double duguje(){

        Session session= HibernateUtil.getSessionFactory().openSession();
        Query<Pays> query=session.createQuery("FROM Pays WHERE", Pays.class);
        ArrayList<Pays> saldo= (ArrayList<Pays>) query.getResultList();
        double sum=0;
        for(var s:saldo){
            sum+=s.getPayments();
        }

        return sum;


    }

    public static Object sumSaldo(SaldoTableDAO table,int rowIndex,double earnings,double payments){

        if(rowIndex==0){
            return earnings-payments;
        }

        double saldo=(double) table.getValueAt(rowIndex-1,4);

        return saldo+earnings-payments;
    }

    public static double zaradjeno(int workerId){

        Session session= HibernateUtil.getSessionFactory().openSession();
        Query<Pays> query=session.createQuery("FROM Pays WHERE workerId=:workerId", Pays.class);
        query.setParameter("workerId",workerId);
        ArrayList<Pays> saldo= (ArrayList<Pays>) query.getResultList();
        double sum=0;
        for(var s:saldo){
            sum+=s.getEarnings();
        }

        session.close();

        return sum;


    }

    public static double isplaceno(int workerId){

        Session session= HibernateUtil.getSessionFactory().openSession();
        Query<Pays> query=session.createQuery("FROM Pays WHERE workerId=:workerId", Pays.class);
        query.setParameter("workerId",workerId);
        ArrayList<Pays> saldo= (ArrayList<Pays>) query.getResultList();
        double sum=0;
        for(var s:saldo){
            sum+=s.getPayments();
        }

        session.close();

        return sum;


    }

    public static double sektorSum(String pozicija){
       JTable table= (JTable) MainWindow.components.get("table");
       double sum=0;


       for(int i=0;i<table.getRowCount();i++){
           if(table.getValueAt(i,3).equals(pozicija)){
               sum += (double) table.getValueAt(i,4);
           }
       }
       return sum;
    }


}
