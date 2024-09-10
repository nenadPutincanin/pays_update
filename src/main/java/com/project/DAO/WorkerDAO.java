package com.project.DAO;

import com.project.DB.HibernateUtil;
import com.project.components.MainWindow;
import com.project.models.Pays;
import com.project.models.Worker;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.util.ArrayList;

public class WorkerDAO {

    public static ArrayList<Worker> all(){

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query<Worker> query = session.createQuery("FROM Worker", Worker.class);
            ArrayList<Worker> workers = (ArrayList<Worker>) query.getResultList();
            session.close();
            return workers;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static double allSaldo(int workerId){
        Session session= HibernateUtil.getSessionFactory().openSession();
        Query<Pays> query=session.createQuery("FROM Pays WHERE workerId=:workerId", Pays.class);
        query.setParameter("workerId",workerId);
        ArrayList<Pays> saldoList= (ArrayList<Pays>) query.getResultList();
        double saldo=0;
        for(var s:saldoList){
            saldo+=s.getEarnings()-s.getPayments();
        }
        session.close();
        return saldo;
    }




}
