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
public class MainInsertScreen extends javax.swing.JFrame {
private boolean admin =false;
    /**
     * Creates new form MainInsertScreen
     */
    public MainInsertScreen(boolean authorisation) {    //if the user is an admin or not is parsed through the parameters
        initComponents();   //initialize the JFrames components
        javax.swing.ImageIcon pic = new javax.swing.ImageIcon("background.jpg");//load in the background image
        javax.swing.ImageIcon scaledPic = new javax.swing.ImageIcon(pic.getImage().getScaledInstance(410, 320, 0)); //resize the image
        lblBackground.setIcon(scaledPic);//make the background labels icon the resized image
        admin = authorisation;
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
        btnCars = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnEmployees = new javax.swing.JButton();
        btnPayments = new javax.swing.JButton();
        btnRepairs = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Aharoni", 0, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Which table would you like to insert into?");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 390, 50));

        btnCars.setText("Cars");
        btnCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarsActionPerformed(evt);
            }
        });
        getContentPane().add(btnCars, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 90, -1));

        btnCustomers.setText("Customers");
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });
        getContentPane().add(btnCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 100, -1));

        btnEmployees.setText("Employees");
        btnEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 100, -1));

        btnPayments.setText("Payments");
        btnPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentsActionPerformed(evt);
            }
        });
        getContentPane().add(btnPayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 100, -1));

        btnRepairs.setText("Repairs");
        btnRepairs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepairsActionPerformed(evt);
            }
        });
        getContentPane().add(btnRepairs, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 90, -1));

        btnBack.setText("Cancel");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JethroLeroux/background.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarsActionPerformed
        InsertCars ic = new InsertCars();   //loads screen to insert a car into the database
        ic.setVisible(true);
        this.setVisible(false); //close this JFrame
    }//GEN-LAST:event_btnCarsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false); //close this JFrame
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        InsertCustomer ic = new InsertCustomer();//loads screen to insert a customer into the database
        ic.setVisible(true);
        this.setVisible(false); //close this JFrame
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesActionPerformed
        if(admin) //only an admin can delete from the payments/employees table
        {
            InsertEmployee ie = new InsertEmployee();//loads screen to insert a employee into the database
            ie.setVisible(true);
            this.setVisible(false); //close this JFrame
        }else //user is not an admin
          {
             AuthorisationError ae = new AuthorisationError(); //explains why access has been denied
             ae.setVisible(true);
          }
    }//GEN-LAST:event_btnEmployeesActionPerformed

    private void btnRepairsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairsActionPerformed
        InsertRepair ir = new InsertRepair();   //loads screen to insert a repair into the database
        ir.setVisible(true);
        this.setVisible(false); //close this JFrame
    }//GEN-LAST:event_btnRepairsActionPerformed

    private void btnPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentsActionPerformed
        if(admin) //only an admin can delete from the payments/employees table
        {
            InsertPayments ip = new InsertPayments();//loads screen to insert a payment into the database
            ip.setVisible(true);
            this.setVisible(false); //close this JFrame
        }else //user is not an admin
          {
             AuthorisationError ae = new AuthorisationError(); //explains why access has been denied
             ae.setVisible(true);
          }
    }//GEN-LAST:event_btnPaymentsActionPerformed

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
            java.util.logging.Logger.getLogger(MainInsertScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInsertScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInsertScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInsertScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               MainInsertScreen mis = new MainInsertScreen(false);
               mis.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCars;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnEmployees;
    private javax.swing.JButton btnPayments;
    private javax.swing.JButton btnRepairs;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
