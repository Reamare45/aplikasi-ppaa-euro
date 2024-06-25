/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package applicationview;

import applicationserverdb.DBConnection;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author raja
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
        
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    
    public Login() {
        initComponents();
        con = DBConnection.connectDB();
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
        right = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        signUPButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN PENGAJAR TAMU");
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        right.setBackground(new java.awt.Color(0, 102, 102));
        right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logosm-removebg-preview.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Snap ITC", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 51));
        jLabel6.setText("APLIKASI PPAA");

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jPanel1.add(right);
        right.setBounds(0, 0, 400, 500);

        left.setBackground(new java.awt.Color(255, 255, 255));
        left.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("LOGIN GUEST");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Password");

        loginButton.setBackground(new java.awt.Color(0, 102, 102));
        loginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("I don't have an account");

        signUPButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signUPButton.setText("Sign up");
        signUPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUPButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signUPButton))
                    .addComponent(usernameTextField))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(62, 62, 62))
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(signUPButton))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jPanel1.add(left);
        left.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
         String sql = "SELECT * from DataDiri WHERE username LIKE ? AND Password LIKE ?; ";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, usernameTextField.getText());
            pst.setString(2, passwordField.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Login Successful!");
                Home home = new Home(true);
                home.setVisible(true);
                home.pack();
                home.setLocationRelativeTo(null);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed!");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void signUPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUPButtonActionPerformed
        // TODO add your handling code here:
        SignUp SignUpFrame = new SignUp(this);
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_signUPButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel left;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPanel right;
    private javax.swing.JButton signUPButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}