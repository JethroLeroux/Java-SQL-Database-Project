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
public class InsertEmployee extends javax.swing.JFrame {

    /**
     * Creates new form InsertEmployee
     */
    public InsertEmployee() {
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

        lblTradeUnion = new javax.swing.JLabel();
        txfTradeUnion = new javax.swing.JTextField();
        txfEmployeeName = new javax.swing.JTextField();
        lblEmployeeName = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblQualification = new javax.swing.JLabel();
        txfQualification = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTradeUnion.setForeground(new java.awt.Color(255, 255, 255));
        lblTradeUnion.setText("Trade Union:");
        getContentPane().add(lblTradeUnion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 100, 30));
        getContentPane().add(txfTradeUnion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 180, 30));
        getContentPane().add(txfEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 180, 30));

        lblEmployeeName.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployeeName.setText("Employee Name:");
        getContentPane().add(lblEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 100, 30));

        lblTitle.setFont(new java.awt.Font("Aharoni", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Insert Into Employees Table");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        lblQualification.setForeground(new java.awt.Color(255, 255, 255));
        lblQualification.setText("Qualification:");
        getContentPane().add(lblQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 100, 30));

        txfQualification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfQualificationActionPerformed(evt);
            }
        });
        getContentPane().add(txfQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 180, 30));

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

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JethroLeroux/background.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfQualificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfQualificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfQualificationActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false); //close this JFrame
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        boolean performed = false; //boolean variable to say if a insert function has been performed
        EmployeeDBM EmployeeDB = new EmployeeDBM();    //create a new manager class object
        EmployeeObject newEmployee = new EmployeeObject(0,txfEmployeeName.getText(),txfTradeUnion.getText(),txfQualification.getText());//create a Employee object to be parsed
        EmployeeDB.addEmployee(newEmployee);//parses Employee object
        performed = true;
        
        if(performed)//if a insertion has been performed
        {
            ActionPerformed ap = new ActionPerformed(); //loads action performed screen to show user a insertion has occurred
            ap.setVisible(true);
            txfEmployeeName.setText("");//clear the text fields so user can start a new insertion
            txfQualification.setText("");
            txfTradeUnion.setText("");
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
            java.util.logging.Logger.getLogger(InsertEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnInsert;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblQualification;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTradeUnion;
    private javax.swing.JTextField txfEmployeeName;
    private javax.swing.JTextField txfQualification;
    private javax.swing.JTextField txfTradeUnion;
    // End of variables declaration//GEN-END:variables
}
