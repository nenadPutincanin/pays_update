package com.project.DAO;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ExcellDAO {

    public static void writeToExcell(JTable table, File file) {

            try {
                TableModel m = table.getModel();
                FileWriter fw = new FileWriter(file);
                for (int i = 0; i < m.getColumnCount(); i++) {
                    fw.write(m.getColumnName(i) + "\t");
                }
                fw.write("\n");
                for (int i = 0; i < m.getRowCount(); i++) {
                    for (int j = 0; j < m.getColumnCount(); j++) {
                        fw.write(m.getValueAt(i, j).toString() + "\t");
                    }
                    fw.write("\n");
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }



}