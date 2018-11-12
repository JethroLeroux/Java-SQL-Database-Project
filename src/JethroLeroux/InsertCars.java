/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JethroLeroux;

/**
 *
 * @author Jethro
 */
public class InsertCars extends javax.swing.JFrame {

    /**
     * Creates new form CarsInsert
     */
    public InsertCars() {
        initComponents(); //initializes JFrames components
        javax.swing.ImageIcon pic = new javax.swing.ImageIcon("background.jpg");//loads in the background image
        javax.swing.ImageIcon scaledPic = new javax.swing.ImageIcon(pic.getImage().getScaledInstance(500, 330, 0));//resizes the image
        lblBackground.setIcon(scaledPic);//sets the background labels icon to the resized image
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfRegistration = new javax.swing.JTextField();
        txfModel = new javax.swing.JTextField();
        txfColour = new javax.swing.JTextField();
        txfCustomerID = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        lblColour = new javax.swing.JLabel();
        lblCustomerID = new javax.swing.JLabel();
        lblRegistration = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txfRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfRegistrationActionPerformed(evt);
            }
        });
        getContentPane().add(txfRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 180, 30));
        getContentPane().add(txfModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 180, 30));
        getContentPane().add(txfColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 180, 30));

        txfCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCustomerIDActionPerformed(evt);
            }
        });
        getContentPane().add(txfCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 180, 30));

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 70, -1));

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        lblTitle.setFont(new java.awt.Font("Aharoni", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Insert Into Cars Table");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        lblModel.setForeground(new java.awt.Color(255, 255, 255));
        lblModel.setText("Model:");
        getContentPane().add(lblModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, 30));

        lblColour.setForeground(new java.awt.Color(255, 255, 255));
        lblColour.setText("Colour:");
        getContentPane().add(lblColour, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, 30));

        lblCustomerID.setForeground(new java.awt.Color(255, 255, 255));
        lblCustomerID.setText("CustomerID:");
        getContentPane().add(lblCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 30));

        lblRegistration.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistration.setText("Registration:");
        getContentPane().add(lblRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JethroLeroux/background.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfRegistrationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfRegistrationActionPerformed

    private void txfCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCustomerIDActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false); //close this JFrame
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        boolean performed = false; //boolean variable to say if a delete function has been performed
        CarDBM carDB = new CarDBM();    //create a new manager class object
        CarObject newCar = new CarObject(0,txfRegistration.getText(),txfModel.getText(), txfColour.getText(), Integer.parseInt(txfCustomerID.getText()));//create a car object to be parsed
        carDB.addCar(newCar);//parses car object
        performed = true;
        
        if(performed)//if a insertion has been performed
        {
            ActionPerformed ap = new ActionPerformed(); //loads action performed screen to show user a insertion has occurred
            ap.setVisible(true);
            txfColour.setText("");//clear the text fields so user can start a new insertion
            txfCustomerID.setText("");
            txfModel.setText("");
            txfRegistration.setText("");
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InsertCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertCars().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnInsert;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblColour;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblRegistration;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txfColour;
    private javax.swing.JTextField txfCustomerID;
    private javax.swing.JTextField txfModel;
    private javax.swing.JTextField txfRegistration;
    // End of variables declaration//GEN-END:variables
}