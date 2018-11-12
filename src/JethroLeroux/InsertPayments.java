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
public class InsertPayments extends javax.swing.JFrame {

    /**
     * Creates new form InsertPayments
     */
    public InsertPayments() {
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

        btnCancel = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        txfPaid = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblFee = new javax.swing.JLabel();
        txfFee = new javax.swing.JTextField();
        txfRepairID = new javax.swing.JTextField();
        lblRepairID = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 70, -1));

        txfPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPaidActionPerformed(evt);
            }
        });
        getContentPane().add(txfPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 180, 30));

        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Paid(true/false):");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 100, 30));

        lblFee.setForeground(new java.awt.Color(255, 255, 255));
        lblFee.setText("Fee:");
        getContentPane().add(lblFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 100, 30));
        getContentPane().add(txfFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 180, 30));
        getContentPane().add(txfRepairID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 180, 30));

        lblRepairID.setForeground(new java.awt.Color(255, 255, 255));
        lblRepairID.setText("RepairID:");
        getContentPane().add(lblRepairID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, 30));

        lblTitle.setFont(new java.awt.Font("Aharoni", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Insert Into Payments Table");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JethroLeroux/background.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPaidActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
       this.setVisible(false); //close this JFrame
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        boolean performed = false; //boolean variable to say if a insert function has been performed
        PaymentDBM PaymentDB = new PaymentDBM();    //create a new manager class object
        PaymentObject newPayment = new PaymentObject(0,Integer.parseInt(txfRepairID.getText()),Integer.parseInt(txfFee.getText()),Boolean.parseBoolean(txfPaid.getText()));//create a Payment object to be parsed
        PaymentDB.addPayment(newPayment);//parses Payment object
        performed = true;
        
        if(performed)//if a insertion has been performed
        {
            ActionPerformed ap = new ActionPerformed(); //loads action performed screen to show user a insertion has occurred
            ap.setVisible(true);
            txfFee.setText("");//clear the text fields so user can start a new insertion
            txfPaid.setText("");
            txfRepairID.setText("");
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
            java.util.logging.Logger.getLogger(InsertPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertPayments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnInsert;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFee;
    private javax.swing.JLabel lblRepairID;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txfFee;
    private javax.swing.JTextField txfPaid;
    private javax.swing.JTextField txfRepairID;
    // End of variables declaration//GEN-END:variables
}
