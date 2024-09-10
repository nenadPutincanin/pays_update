package com.project.DAO;

import com.project.models.Worker;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class TableDAO implements TableModel {

    private String[] naslov=new String[]{"Šifra","Ime","Prezime","Pozicija","Ukupno"};
    private ArrayList<Worker> data=WorkerDAO.all();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return naslov.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return naslov[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex){
            case 0-> Integer.class;
            case 1-> String.class;
            case 2-> String.class;
            case 3-> String.class;
            case 4-> Object.class;
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
            case 0-> data.get(rowIndex).getWorkerId();
            case 1->data.get(rowIndex).getFirstName();
            case 2->data.get(rowIndex).getLastName();
            case 3->data.get(rowIndex).getPosition();
            case 4->WorkerDAO.allSaldo(data.get(rowIndex).getWorkerId());
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

    public Worker getWorker(int rowIndex){
        return data.get(rowIndex);
    }



}
