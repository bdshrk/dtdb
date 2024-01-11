/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtdb.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     * @throws java.io.IOException
     */
    public Menu() throws IOException {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("icon2.png"));
        setIconImage(img.getImage());
        
        copyDefaultCSV();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonView = new javax.swing.JButton();
        jButtonAddItem = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jLabelMainMenu = new javax.swing.JLabel();
        jButtonRemoveItem = new javax.swing.JButton();
        jDesktopPane = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DTDB");

        jButtonView.setText("View");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });

        jButtonAddItem.setText("Add Item");
        jButtonAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddItemActionPerformed(evt);
            }
        });

        jButtonPrint.setText("Print");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jLabelMainMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelMainMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMainMenu.setText("Main Menu");
        jLabelMainMenu.setToolTipText("");

        jButtonRemoveItem.setText("Remove Item");
        jButtonRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAddItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRemoveItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonView)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddItem)
                .addGap(18, 18, 18)
                .addComponent(jButtonRemoveItem)
                .addGap(18, 18, 18)
                .addComponent(jButtonPrint)
                .addGap(18, 18, 18)
                .addComponent(jButtonExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
        JInternalFrame View = null;
        try {
            View = new View();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //View.setSize(600, 500);
        View.setVisible(true);
        jDesktopPane.add(View);
        View.toFront();
    }//GEN-LAST:event_jButtonViewActionPerformed

    private void jButtonAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddItemActionPerformed
        JInternalFrame Edit = null;
        try {
            Edit = new AddItem();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //View.setSize(600, 500);
        Edit.setVisible(true);
        jDesktopPane.add(Edit);
        Edit.toFront();
    }//GEN-LAST:event_jButtonAddItemActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        JInternalFrame Print = null;
        try {
            Print = new Print();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //View.setSize(600, 500);
        Print.setVisible(true);
        jDesktopPane.add(Print);
        Print.toFront();
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void jButtonRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveItemActionPerformed
        JInternalFrame RemoveItem = null;
        try {
            RemoveItem = new RemoveItem(new DefaultTableModel(),-1);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //View.setSize(600, 500);
        RemoveItem.setVisible(true);
        jDesktopPane.add(RemoveItem);
        RemoveItem.toFront();
    }//GEN-LAST:event_jButtonRemoveItemActionPerformed

    // copy the default csv to appdata folder
    private void copyDefaultCSV () throws IOException {
        // if the db already exists
        if (new File("H:/dtdb/db.csv").exists()) {
            System.out.println("db file already exists");
        } else {
            // if it doesnt exist
            // make a new folder/directory
            new File("H:/dtdb").mkdirs();
            // make an empty db file
            new File("H:/dtdb/db.csv").createNewFile();
            
            // open the db resource included in build
            InputStream copyInputStream = getClass().getClassLoader().getResourceAsStream("db.csv");
            // get destination
            String copyDst = "H:/dtdb/db.csv";
            // copy the resource to the destination
            Files.copy(copyInputStream, Paths.get(copyDst), StandardCopyOption.REPLACE_EXISTING);
        }
        
        // create an export folder for prints
        new File("H:/dtdb/export").mkdirs();
    }
    
    public static JDesktopPane getDesktop() {
        JDesktopPane pane = jDesktopPane;
        return pane;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddItem;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonRemoveItem;
    private javax.swing.JButton jButtonView;
    public static javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabelMainMenu;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
