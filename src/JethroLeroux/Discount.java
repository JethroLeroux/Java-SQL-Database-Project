/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JethroLeroux;

import javax.swing.JOptionPane;

/**
 *
 * @author Jethro
 */
public class Discount extends javax.swing.JFrame {
    PaymentDBM pdbm = new PaymentDBM();
    /**
     * Creates new form Discount
     */
    public Discount() {
        initComponents();   //initialize the JFrames components
        javax.swing.ImageIcon pic = new javax.swing.ImageIcon("background.jpg");    //load in the background image
        javax.swing.ImageIcon scaledPic = new javax.swing.ImageIcon(pic.getImage().getScaledInstance(500, 330, 0));//resize the image
        lblBackground.setIcon(scaledPic);//set the labels icon as the image
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblPayID = new javax.swing.JLabel();
        lblNewFee = new javax.swing.JLabel();
        txfPayID = new javax.swing.JTextField();
        txfNewFee = new javax.swing.JTextField();
        btnApplyDiscount = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Aharoni", 0, 36)); // NOI18N
        lblTitle.setText("Give a discount:");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 290, 80));

        lblPayID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPayID.setText("Payment ID:");
        getContentPane().add(lblPayID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        lblNewFee.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNewFee.setText("New Fee:");
        getContentPane().add(lblNewFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));
        getContentPane().add(txfPayID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 180, 30));
        getContentPane().add(txfNewFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 180, 30));

        btnApplyDiscount.setText("Apply Discount");
        btnApplyDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyDiscountActionPerformed(evt);
            }
        });
        getContentPane().add(btnApplyDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 120, 30));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 80, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JethroLeroux/background.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);        //close the Discount screen
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnApplyDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyDiscountActionPerformed
        //provide a simpler way than the edit screen to apply a discount
        PaymentObject[] payments =  pdbm.getPayments();
        
        if(payments[Integer.parseInt(txfPayID.getText())-1].isPaid() == false)//if the fee has not yet been paid
        {
            pdbm.editPayment(Integer.parseInt(txfPayID.getText()), "Fee", txfNewFee.getText());
            ActionPerformed ap = new ActionPerformed();
            ap.setVisible(true);
            txfPayID.setText("");       //clear the text fields so the user can give another discount
            txfNewFee.setText("");
        }else   //then the field has already been paid
        {
            JOptionPane.showMessageDialog(null, "You cant give a discount if the field has already been paid");
            txfPayID.setText("");       //clear the text fields so the user can correct the mistake
            txfNewFee.setText("");
        }
    }//GEN-LAST:event_btnApplyDiscountActionPerformed

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
            java.util.logging.Logger.getLogger(Discount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Discount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Discount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Discount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Discount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApplyDiscount;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblNewFee;
    private javax.swing.JLabel lblPayID;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txfNewFee;
    private javax.swing.JTextField txfPayID;
    // End of variables declaration//GEN-END:variables
}