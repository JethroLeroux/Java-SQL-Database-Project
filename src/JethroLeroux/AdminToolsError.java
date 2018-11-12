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
public class AdminToolsError extends javax.swing.JFrame {

    /**
     * Creates new form AdminToolsError
     */
    public AdminToolsError() {//constructor method of the JFrame, initializes components. Label resizing for the background is not needed or else it distorts the image
     
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblExplain = new javax.swing.JLabel();
        lblExplain1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblCrossBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(490, 320));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblExplain.setFont(new java.awt.Font("Aharoni", 0, 18)); // NOI18N
        lblExplain.setText("You are not authorised to use the Admin Tools!");
        getContentPane().add(lblExplain, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 430, 90));

        lblExplain1.setFont(new java.awt.Font("Aharoni", 0, 18)); // NOI18N
        lblExplain1.setText("Only a manager may use these tools!");
        getContentPane().add(lblExplain1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 330, 50));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        lblCrossBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JethroLeroux/error sign.png"))); // NOI18N
        getContentPane().add(lblCrossBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false); //closes this screen
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
            java.util.logging.Logger.getLogger(AdminToolsError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminToolsError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminToolsError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminToolsError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminToolsError().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblCrossBackground;
    private javax.swing.JLabel lblExplain;
    private javax.swing.JLabel lblExplain1;
    // End of variables declaration//GEN-END:variables
}
