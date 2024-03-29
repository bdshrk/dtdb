/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dtdb.main;

//import com.sun.javafx.scene.control.skin.Utils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    int loginTimeout = 0;
    int loginTimeoutCounter = 0;
    
    public Login() {
        initComponents();
        getRootPane().setDefaultButton(jLogin);
        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("icon2.png"));
        setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jUsernameField = new javax.swing.JTextField();
        jLabelUsername = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLogin = new javax.swing.JButton();
        jQuit = new javax.swing.JButton();
        jErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new java.awt.Dimension(313, 121));
        setResizable(false);

        jLabelUsername.setText("Username");

        jLabelPassword.setText("Password");

        jLogin.setText("Login");
        jLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginActionPerformed(evt);
            }
        });

        jQuit.setText("Quit");
        jQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQuitActionPerformed(evt);
            }
        });

        jErrorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelUsername)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPassword)
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUsernameField)
                            .addComponent(jPasswordField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addGap(65, 65, 65)
                        .addComponent(jLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsername)
                    .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jQuit)
                    .addComponent(jLogin)
                    .addComponent(jErrorLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jQuitActionPerformed

    // when the user clicks the confirm or presses 
    private void jLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginActionPerformed
        // saves the current values to variables
        String loginUsername = jUsernameField.getText();
        char[] loginPasswordChar = jPasswordField.getPassword();
        String loginPassword = new String(loginPasswordChar);
        // logincorrect is set to false by default
        boolean loginCorrect = false;
        
        // if both the username and password are correct
        if (loginUsername.equals("admin") && loginPassword.equals("password")) {
            // timeoutcheck will return 0 as code has been commented
            if (timeoutCheck() == 0) {
                // sets login to correct so if statement later can run
                loginCorrect = true;
            }
        } else {
            // else show error
            JOptionPane.showMessageDialog(this, "Username/Password incorrect!", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        
        // if login correct, open the menu
        if (loginCorrect) {
            try {
                new Menu().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            // and close login window
            this.dispose();
        }
    }//GEN-LAST:event_jLoginActionPerformed

    public int timeoutCheck() {
        int timeout = 0;
        long loginTimeMillis = System.currentTimeMillis();
                
        long loginTimeMillisDif = System.currentTimeMillis() - loginTimeMillis;
        
        if (loginTimeMillisDif > 60000) {
            loginTimeout = 0;
        }
        
        if (loginTimeoutCounter == 3 && loginTimeout == 0) {
            loginTimeout = 60;
            jErrorLabel.setText("Timeout: "+loginTimeout);
            JOptionPane.showMessageDialog(this, "Username/Password incorrect!\nTimeout of "+loginTimeout+" applied.", "Login Error", JOptionPane.ERROR_MESSAGE);
            //loginTimeMillis = System.currentTimeMillis();
            timeout = 60;
        }
        
        if (loginTimeout > 0) {
            jErrorLabel.setText("Timeout: "+loginTimeout);
            JOptionPane.showMessageDialog(this, "You are still on a timeout!\nTime remaining: "+loginTimeout+".", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        return timeout;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            /* Set the Nimbus look and feel */
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jErrorLabel;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JButton jLogin;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JButton jQuit;
    private javax.swing.JTextField jUsernameField;
    // End of variables declaration//GEN-END:variables
}
