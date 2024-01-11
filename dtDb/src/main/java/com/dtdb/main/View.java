/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtdb.main;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static com.dtdb.main.Menu.jDesktopPane;
import static com.dtdb.main.Print.jCategoryCombo;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
public final class View extends javax.swing.JInternalFrame {

    /**
     * Creates new form View
     * @throws java.io.IOException
     */
       
    public String dbLocation = "H:/dtdb/db.csv";
    
    public int selectedRow;
    public int editedCol;
    public int editedRow;
    public TableModel selectedTableModel;
      
    public String[] dbColumns = {"Key","Name","Stock","Desired Stock","Stock Difference","Price","Category"};
    
    public View() throws IOException {
        initComponents();
        
        updateTable();
    }
    
    
    
    public void updateTable() throws IOException {
        String dbLine;
        BufferedReader dbBR = null;
        
        // new table model for all
        DefaultTableModel dbTableAll = new DefaultTableModel(dbColumns,0);
        
        // arraylist that will contain all unique categories
        ArrayList<String> dbCategoryList = new ArrayList<>();
        
        // remove default tab(s)
        jTabbedPane.removeAll();
        
        try {
            // create reader that reads line by line
            dbBR = new BufferedReader(new FileReader(dbLocation));
            while ((dbLine = dbBR.readLine()) != null) {
                String [] dbCategoryRow = dbLine.split(",");
                // if category is already in the list
                // dbCategoryRow[5] is the category
                if (dbCategoryList.contains(dbCategoryRow[5])) {
                    // adds new category to list if it is
                    // unique and isnt already added
                } else {
                    dbCategoryList.add(dbCategoryRow[5]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close buffered reader
            if (dbBR != null) {
                dbBR.close();
            }
        }
        
        createTable(dbTableAll, "Show All");
        
        
        // for each category
        for (int i = 0; i < dbCategoryList.size(); i++) {
            // new empty temp table model
            DefaultTableModel dbTempTable = new DefaultTableModel(dbColumns,0);
            try {
                // open csv
                dbBR = new BufferedReader(new FileReader(dbLocation));
                while ((dbLine = dbBR.readLine()) != null) {
                    // split row into array
                    String [] dbRow = dbLine.split(",");
                    // if the current row's category is the same as the
                    // category we are currently processing
                    if (dbRow[5].equalsIgnoreCase(dbCategoryList.get(i))) {
                        // convert array to vector object
                        Vector<String> dbRowVector = new Vector<String>(Arrays.asList(dbRow));

                        // calculate percentage
                        double dbStockCurrent = Integer.parseInt(dbRowVector.get(1));
                        double dbStockMax = Integer.parseInt(dbRowVector.get(2));
                        double dbStockPercentage = dbStockCurrent / dbStockMax;
                        double dbStockPercentageFormat = Math.round(dbStockPercentage * 100);
                        // add percentage to vector
                        dbRowVector.set(3, String.valueOf(dbStockPercentageFormat)+"%");
                        // add pound sign
                        dbRowVector.set(4, "£" + dbRowVector.get(4));
                        // move primary key to front
                        dbRowVector.add(0, dbRow[11]);
                        // add to the temp table model
                        dbTempTable.addRow(dbRowVector);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // close reader
                if (dbBR != null) {
                    dbBR.close();
                }
            }
            
            // pass into createtable method
            createTable(dbTempTable, dbCategoryList.get(i));
        }
        
        
        try {
            dbBR = new BufferedReader(new FileReader(dbLocation));
            while ((dbLine = dbBR.readLine()) != null) {
                String [] dbRow = dbLine.split(",");
                Vector<String> dbRowVector = new Vector<String>(Arrays.asList(dbRow));
                try {
                    double dbStockCurrent = Integer.parseInt(dbRowVector.get(1));
                    double dbStockMax = Integer.parseInt(dbRowVector.get(2));
                    //System.out.println(dbStockCurrent+"   "+dbStockMax);
                    double dbStockPercentage = dbStockCurrent / dbStockMax;
                    double dbStockPercentageFormat = Math.round(dbStockPercentage * 100);
                    //System.out.println(String.valueOf(dbStockPercentage));
                    dbRowVector.set(3, String.valueOf(dbStockPercentageFormat)+"%");
                    dbRowVector.set(4, "£" + dbRowVector.get(4));
                    dbRowVector.add(0, dbRow[11]);
                    
                    //colour
                    if (dbStockCurrent > dbStockMax) {
                        Color customColor = new Color(0,255,0);
                        //jTable1.getCellRenderer(0, 0).getTableCellRendererComponent(jTable1, dbLine, isSelected, isIcon, ERROR, WIDTH)t(jTable1, dbLine, isSelected, isIcon, ERROR, WIDTH).setFsetForeground(customColor);
                    } else {
                        int addColorGreen = (int) Math.round(dbStockPercentage*255);
                        int addColorRed = (int) Math.round(255-(dbStockPercentage*255));
                        //System.out.println("red: "+addColorRed+", green: "+addColorGreen);
                        Color customColor = new Color(addColorRed,addColorGreen,0);
                        jTable1.setForeground(customColor);
                    }
                } catch (Exception ex) {
                    System.out.println("exception on "+dbRow[0]);
                    dbRowVector.set(3, "0");
                }
                
                dbTableAll.addRow(dbRowVector);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (dbBR != null) {
                dbBR.close();
            }
        }
        
        //TableColumn col = jTable1.getColumnModel().getColumn(3);
        //DefaultTableModel model3 = (DefaultTableModel)jTable1.getModel();
        //col.setCellRenderer(new TableRenderer());
        
        
        
        //jTable1.setModel(model3);
        
        //model3.getDataVector().removeAllElements();
        //model3.fireTableDataChanged();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane.addTab("tab1", jScrollPane1);

        jButtonUpdate.setText("Force Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete Selected Row");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDelete)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        int dbCurrentTab = jTabbedPane.getSelectedIndex();
        try {
            updateTable();
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTabbedPane.setSelectedIndex(dbCurrentTab);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        JInternalFrame RemoveItem = null;
        try {
            RemoveItem = new RemoveItem(selectedTableModel, selectedRow);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //View.setSize(600, 500);
        RemoveItem.setVisible(true);
        jDesktopPane.add(RemoveItem);
        RemoveItem.toFront();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        //System.out.println(evt.toString());
    }//GEN-LAST:event_jTable1PropertyChange

    // creates tab and table
    private void createTable(DefaultTableModel tableModel, String name) {
                
        // create table from model
        JTable table = new JTable(tableModel);
    
        // add listener
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // set col and row to global variables
                editedCol = e.getColumn();
                editedRow = e.getLastRow();
                try {
                    // get what was edited
                    String edit = (String) table.getValueAt(editedRow, editedCol);
                    // get the key of the row that was changed
                    String key = (String) table.getValueAt(editedRow, 0);
                    // pass to edit method
                    editValueInDB(key, edit, editedCol);
                } catch (Exception ex) {
                    // if nothing was edited
                }
            }
        });
        
        // add tab with name
        // JScrollPane is used otherwise headings won't show
        jTabbedPane.addTab(name, new JScrollPane(table));
    }
    
    // edits db value
    public void editValueInDB(String key, String value, int col) throws IOException {
        
        //read file to variable
        Path pathTemp = Paths.get(dbLocation);
        String tempContent = new String(Files.readAllBytes(pathTemp));
        
        // set up reader
        String dbLine;
        BufferedReader dbBR = null;
        
        try {
            // init reader
            dbBR = new BufferedReader(new FileReader(dbLocation));
            while ((dbLine = dbBR.readLine()) != null) {
                // split line by ,
                String [] dbRow = dbLine.split(",");
                // if the key matches
                if (dbRow[11].equals(key)) {
                    // init modline
                    String modLine;
                    // switch for col number
                    switch (col) {
                        case 0:
                            // changed key
                            // nothing happens as this is not allowed
                            break;
                        case 1:
                            // changed name
                            dbRow[0] = value;
                            break;
                        case 2:
                            // changed stock
                            dbRow[1] = value;
                            break;
                        case 3:
                            // changed desired stock
                            dbRow[2] = value;
                            break;
                        case 4:
                            // changed percent
                            // do not allow
                            break;
                        case 5:
                            // changed price
                            if (value.startsWith("£")) {
                                // remove £ if it is present
                                System.out.println("removed pound sign");
                                value = value.replaceAll("£", "");
                            }
                            dbRow[4] = value;
                            break;
                        case 6:
                            // changed category
                            dbRow[5] = value;
                            break;
                    }
                    // modline set to rejoined array
                    modLine = String.join(",", dbRow);
                    // replace in csv
                    tempContent = tempContent.replaceFirst(dbLine, modLine);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (dbBR != null) {
                // close reader
                dbBR.close();
            }
        }
        
        // write to file
        Files.write(pathTemp, tempContent.getBytes());
        
        // call table update
        // this is important
        updateTable();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}