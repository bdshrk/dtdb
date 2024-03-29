/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtdb.main;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Print extends javax.swing.JInternalFrame {

    /**
     * Creates new form Print
     */
    
    public Path recentFilePath;
    
    public Print() throws IOException {
        initComponents();
        
        // sets up dbline and reader
        String dbLine;
        BufferedReader dbBR = null;
        
        // add custom categories
        
        ArrayList<String> dbCategoryList = new ArrayList<>();
        jCategoryCombo.removeAllItems();
        
        try {
            // load csv
            dbBR = new BufferedReader(new FileReader("H:/dtdb/db.csv"));
            while ((dbLine = dbBR.readLine()) != null) {
                // split current line into string seperated by ","
                String [] dbCategoryRow = dbLine.split(",");
                
                // checks if the category is in the category list
                // category is stored at dbCategoryRow[5]
                if (dbCategoryList.contains(dbCategoryRow[5])) {
                    // if it already contains the category
                } else {
                    // if it is not, add it to the list and combo box
                    dbCategoryList.add(dbCategoryRow[5]);
                    jCategoryCombo.addItem(dbCategoryRow[5]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (dbBR != null) {
                dbBR.close();
                // at the end of the file, add the all item
                jCategoryCombo.addItem("All");
                // and set the combo box to have it selected
                jCategoryCombo.setSelectedIndex(jCategoryCombo.getItemCount()-1);
            }
        }
        
        // add custom catalogues
        
        ArrayList<String> dbCatalogueList = new ArrayList<>();
        jCatalogueCombo.removeAllItems();
        
        try {
            // opens file
            dbBR = new BufferedReader(new FileReader("H:/dtdb/db.csv"));
            while ((dbLine = dbBR.readLine()) != null) {
                // splits line
                String [] dbCatalogueRow = dbLine.split(",");
                
                // this does the same thing as the previous loop, but with the catalogues
                if (dbCatalogueList.contains(dbCatalogueRow[8])) {
                    // contains the catalogue
                } else {
                    dbCatalogueList.add(dbCatalogueRow[8]);
                    jCatalogueCombo.addItem(dbCatalogueRow[8]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (dbBR != null) {
                // close at end of file
                dbBR.close();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jUrgency = new javax.swing.JComboBox<>();
        jLabelUrgency = new javax.swing.JLabel();
        jLabelCatalogue = new javax.swing.JLabel();
        jCatalogueCombo = new javax.swing.JComboBox<>();
        jLabelCategory = new javax.swing.JLabel();
        jCategoryCombo = new javax.swing.JComboBox<>();
        jButtonGenerate = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        jUrgency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Low", "Medium", "High" }));

        jLabelUrgency.setText("Urgency");

        jLabelCatalogue.setText("Catalogue");

        jCatalogueCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelCategory.setText("Category");

        jCategoryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCategoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCategoryComboActionPerformed(evt);
            }
        });

        jButtonGenerate.setText("Generate File");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUrgency)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jUrgency, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCatalogue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCatalogueCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCategoryCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(jButtonGenerate)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCatalogue)
                    .addComponent(jCatalogueCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategory)
                    .addComponent(jCategoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUrgency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUrgency))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGenerate)
                    .addComponent(jButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCategoryComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCategoryComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCategoryComboActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        
        //generate file
        try {
            copyTemplateFile();
            populateFile();
            renameFile();
            
            // open the file with default app
            Desktop.getDesktop().open(new File(recentFilePath.toString()));
        } catch (Exception ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // close window
        this.dispose();
    }//GEN-LAST:event_jButtonGenerateActionPerformed

    private void copyTemplateFile () throws IOException {
        // get temp.rtf file from build
        InputStream copyInputStream = getClass().getClassLoader().getResourceAsStream("temp.rtf");
        String copyDst = "H:/dtdb/export/temp.rtf";
        
        // output file to directory
        Files.copy(copyInputStream, Paths.get(copyDst), StandardCopyOption.REPLACE_EXISTING);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JComboBox<String> jCatalogueCombo;
    public static javax.swing.JComboBox<String> jCategoryCombo;
    private javax.swing.JLabel jLabelCatalogue;
    private javax.swing.JLabel jLabelCategory;
    private javax.swing.JLabel jLabelUrgency;
    private javax.swing.JComboBox<String> jUrgency;
    // End of variables declaration//GEN-END:variables

    private void renameFile() throws FileNotFoundException {
        // gets date in correct format
        String renameDate = new SimpleDateFormat("yyyy-MM-dd-_-HH-mm-ss").format(Calendar.getInstance().getTime());
        
        // gets input and output file rename
        File renameInput = new File("H:/dtdb/export/temp.rtf");
        File renameOutput = new File("H:/dtdb/export/" + renameDate + ".rtf");
        
        // performs the rename
        renameInput.renameTo(renameOutput);
        recentFilePath = renameOutput.toPath();
    }

    private void populateFile() throws IOException {
        // get values from boxes
        String filterCatalogueCombo = (String) jCatalogueCombo.getSelectedItem();
        String filterCategoryCombo = (String) jCategoryCombo.getSelectedItem();
        String filterUrgency = (String) jUrgency.getSelectedItem();
        
        // create arraylist of items
        
        String dbLine;
        BufferedReader dbBR = null;
        
        ArrayList<String> popItems = new ArrayList<>();
        
        try {
            dbBR = new BufferedReader(new FileReader("H:/dtdb/db.csv"));
            while ((dbLine = dbBR.readLine()) != null) {
                String [] popItemRow = dbLine.split(",");
                
                if (filterCatalogueCombo.equals(popItemRow[8])) { // first check catalogue
                    if (filterCategoryCombo.equals("All")) { // if category is all
                        if (filterUrgency.equals("All")) {
                            popItems.add(Arrays.toString(popItemRow)); // add if both equal all
                        } else if (filterUrgency.equals(popItemRow[7])) {
                            popItems.add(Arrays.toString(popItemRow));
                        }
                    } else if (filterCategoryCombo.equals(popItemRow[5])) {
                        if (filterUrgency.equals("All")) {
                            // if all is selected
                            popItems.add(Arrays.toString(popItemRow));
                        } else if (filterUrgency.equals(popItemRow[7])) {
                            popItems.add(Arrays.toString(popItemRow));
                        }
                    }
                }
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainProgram.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (dbBR != null) {
                dbBR.close();
            }
        }
        
        // initialise variables as big decimal
        BigDecimal runningTotal = new BigDecimal(0);
        BigDecimal total = new BigDecimal(0);
        int done = 10;
        
        // get path of copied temp file
        Path pathTemp = Paths.get("H:/dtdb/export/temp.rtf");
        // read to string
        String tempContent = new String(Files.readAllBytes(pathTemp));
        
        // loop through array of items to include
        for (int i = 0; i < popItems.size(); i++) {
            // get current item in array
            String popItem = popItems.get(i);
            
            // expand array
            String [] popItemsArray = popItem.replace("[", "").replace("]", "").split(", ");
            
            // get temp.rtf
            tempContent = tempContent.replaceAll("DEPARTMENT", "DT");
            tempContent = tempContent.replaceAll("SUPPLIER", popItemsArray[8]);
            
            // replace fields
            int quantToOrder = Integer.valueOf(popItemsArray[2]) - Integer.valueOf(popItemsArray[1]);
            tempContent = tempContent.replaceFirst("CPN", popItemsArray[9]);
            tempContent = tempContent.replaceFirst("PCISBN", popItemsArray[10]);
            tempContent = tempContent.replaceFirst("QUANT", String.valueOf(quantToOrder));
            tempContent = tempContent.replaceFirst("DESCITEM", popItemsArray[0]);
            tempContent = tempContent.replaceFirst("PRCEA", "£" + popItemsArray[4]);
            total = new BigDecimal(popItemsArray[4]).multiply(new BigDecimal(quantToOrder));
            
            // calculate total
            runningTotal = runningTotal.add(total);
            tempContent = tempContent.replaceFirst("PRCTOT", "£" + total.toString());
            
            done -= 1;
        }
        
        // remaining empty rows in order form are set to empty
        for (int i = 0; i < done; i++) {
            tempContent = tempContent.replaceFirst("CPN", "");
            tempContent = tempContent.replaceFirst("PCISBN", "");
            tempContent = tempContent.replaceFirst("QUANT", "");
            tempContent = tempContent.replaceFirst("DESCITEM", "");
            tempContent = tempContent.replaceFirst("PRCEA", "");
            tempContent = tempContent.replaceFirst("PRCTOT", "");
        }
        
        // add combined total
        tempContent = tempContent.replaceFirst("TOTALT", "£" + runningTotal.toString());
        tempContent = tempContent.replaceFirst("TOTALE", "");
        
        //write to file
        Files.write(pathTemp, tempContent.getBytes());
    }
}
