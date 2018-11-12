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
public class AdminTools extends javax.swing.JFrame {

    /**
     * Creates new form AdminTools
     */
    public AdminTools() {//constructor method of the JFrame, initializes components
       initComponents();
        javax.swing.ImageIcon pic = new javax.swing.ImageIcon("background.jpg");//loads the background image
        javax.swing.ImageIcon scaledPic = new javax.swing.ImageIcon(pic.getImage().getScaledInstance(500, 330, 0));//resizies the image to the JFrames dimensions
        lblBackground.setIcon(scaledPic);//sets the labels icon to the background
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
        btnBack = new javax.swing.JButton();
        btnDiscount = new javax.swing.JButton();
        btnIncomeSummary = new javax.swing.JButton();
        btnUnrepaired = new javax.swing.JButton();
        btnReleasable = new javax.swing.JButton();
        btnSStats = new javax.swing.JButton();
        btnOStats = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Aharoni", 0, 36)); // NOI18N
        lblTitle.setText("Admin Tools");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 230, 70));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 80, -1));

        btnDiscount.setText("Give a Discount");
        btnDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscountActionPerformed(evt);
            }
        });
        getContentPane().add(btnDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 150, 30));

        btnIncomeSummary.setText("Income summary");
        btnIncomeSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncomeSummaryActionPerformed(evt);
            }
        });
        getContentPane().add(btnIncomeSummary, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 150, 30));

        btnUnrepaired.setText("Unrepaired Vehicles");
        btnUnrepaired.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnrepairedActionPerformed(evt);
            }
        });
        getContentPane().add(btnUnrepaired, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 150, 30));

        btnReleasable.setText("Releasable Vehicles");
        btnReleasable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReleasableActionPerformed(evt);
            }
        });
        getContentPane().add(btnReleasable, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 150, 30));

        btnSStats.setText("Specific Stats");
        btnSStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSStatsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 150, 30));

        btnOStats.setText("Overall Stats");
        btnOStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOStatsActionPerformed(evt);
            }
        });
        getContentPane().add(btnOStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 150, 30));

        btnAddUser.setText("Add User");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 150, 30));

        btnDeleteUser.setText("Delete User");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 150, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JethroLeroux/background.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncomeSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncomeSummaryActionPerformed
             IncomeSummary is = new IncomeSummary(); //opens the IncomeSummary screen/JFrame to let the user see the businesses income summary
             is.setVisible(true);
    }//GEN-LAST:event_btnIncomeSummaryActionPerformed

    private void btnDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscountActionPerformed
        Discount d = new Discount(); //Opens the discount screen/JFrame to lets the user make a discount
        d.setVisible(true);
    }//GEN-LAST:event_btnDiscountActionPerformed

    private void btnReleasableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReleasableActionPerformed
        ReleasableVehicles rv = new ReleasableVehicles(); //opens the releasable vehicles screen/JFrame to show all the vehicles which can be realeased
        rv.setVisible(true);
    }//GEN-LAST:event_btnReleasableActionPerformed

    private void btnUnrepairedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnrepairedActionPerformed
        UnrepairedVehicles uv = new UnrepairedVehicles(); //opens the unrepaired vehicles screen/JFrame to show all the vehicles to still be repaired
        uv.setVisible(true);
    }//GEN-LAST:event_btnUnrepairedActionPerformed

    private void btnSStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSStatsActionPerformed
        SpecificStats ss = new SpecificStats(); //opens the specific stats screen/JFrame to show specific stats
        ss.setVisible(true);
    }//GEN-LAST:event_btnSStatsActionPerformed

    private void btnOStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOStatsActionPerformed
        OverallStats os = new OverallStats();   //opens the overall stats screen/JFrame to show overall stats
        os.setVisible(true);
    }//GEN-LAST:event_btnOStatsActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        AddUser au = new AddUser(); //opens the add user screen/JFrame where a user for the program can be input to the textfile
        au.setVisible(true);
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
       DeleteUser du = new DeleteUser();//opens the delete user screen/JFrame where a user for the program can be deleted from the textfile
       du.setVisible(true);
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false); //closes this JFrame
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(AdminTools.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminTools.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminTools.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminTools.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminTools().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnDiscount;
    private javax.swing.JButton btnIncomeSummary;
    private javax.swing.JButton btnOStats;
    private javax.swing.JButton btnReleasable;
    private javax.swing.JButton btnSStats;
    private javax.swing.JButton btnUnrepaired;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}