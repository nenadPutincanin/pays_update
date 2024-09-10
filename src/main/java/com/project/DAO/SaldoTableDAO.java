package com.project.DAO;


import com.project.models.Pays;


import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaldoTableDAO implements TableModel {

    String[] header=new String[]{"Šifra radnika","Datum","Zarada","Isplata","Saldo","Opis"};

    int workerId=PaysDAO.WorkerId();
    ArrayList<Pays> data=PaysDAO.allSaldo(workerId);




    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return header[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex){
            case 0-> Integer.class;
            case 1-> Object.class;
            case 2->Double.class;
            case 3->Double.class;
            case 4-> Double.class;
            case 5->String.class;

            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return switch (columnIndex){
            case 0 ->data.get(rowIndex).getWorkerId();
            case 1 ->data.get(rowIndex).getDate();
            case 2->data.get(rowIndex).getEarnings();
            case 3->data.get(rowIndex).getPayments();
            case 4 ->PaysDAO.sumSaldo(this,rowIndex,data.get(rowIndex).getEarnings(),data.get(rowIndex).getPayments());
            case 5->data.get(rowIndex).getDescription();
            default -> null;

        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public Pays getPays(int rowIndex){
        return data.get(rowIndex);
    }




}
