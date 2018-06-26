package gui;

import exception.MotorNoSoportadoException;
import factories.DAOFactory;
import factories.MySQL_VendedorDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Vendedor;

public class InicioSesion extends javax.swing.JFrame {

    Vendedor vendedor;
    private MySQL_VendedorDAO ven;
    public  String rut = "";

    public InicioSesion() {

        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txt_Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inicio Sesion"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido al Sistema de Pasajes");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Contraseña:");

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txt_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PasswordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(73, 73, 73))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(btnIngresar))
                    .addComponent(txtUsuario)
                    .addComponent(txt_Password))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnLimpiar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try {
            rut = txtUsuario.getText();
            String password = new String(txt_Password.getPassword());

            password = md5(password);
            App ap = new App();
            
            System.out.println("Rut Vendedor: "+rut);

            if (rut.equals("") || !rut.equals(DAOFactory.getInstance().getVendedorDAO(DAOFactory.Motor.MY_SQL).getByRut(rut))) {
                JOptionPane.showMessageDialog(null, "Usuario Invalido", "ERROR", JOptionPane.OK_OPTION);
                txtUsuario.select(0, txtUsuario.getText().length());
                txtUsuario.requestFocus();
                txt_Password.setText(null);
            } else if (!password.equals(DAOFactory.getInstance().getVendedorDAO(DAOFactory.Motor.MY_SQL).search(rut).get(0).getPass()) || (password.equals(""))) {
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "ERROR", JOptionPane.OK_OPTION);
                txt_Password.setText(null);
                txt_Password.requestFocus();
            } else {
                vendedor = DAOFactory.getInstance().getVendedorDAO(DAOFactory.Motor.MY_SQL).search(rut).get(0);
                System.out.println(vendedor.getId());
            
                String nombre = DAOFactory.getInstance().getVendedorDAO(DAOFactory.Motor.MY_SQL).getNombre(rut);
                System.out.println("Nombre Vendedor: "+nombre);
                JOptionPane.showMessageDialog(this, "Bienvenido Vendedor "+nombre, "VENDIDO", HEIGHT);

                switch (vendedor.getId()) {
                    case 1:
                        ap.setLocationRelativeTo(null);
                        ap.setVisible(true);

//                        menuProfesor.getRutjFrame(rut);//hacer para todos
                        this.setVisible(false);
                        txt_Password.setText(null);
                        break;

                }
            }
        } catch (MotorNoSoportadoException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.getKeyCode()== evt.VK_ENTER) {
            try {
            rut = txtUsuario.getText();
            String password = new String(txt_Password.getPassword());

            password = md5(password);
            App ap = new App();

            if (rut.equals("") || !rut.equals(DAOFactory.getInstance().getVendedorDAO(DAOFactory.Motor.MY_SQL).getByRut(rut))) {
                JOptionPane.showMessageDialog(null, "Usuario Invalido", "ERROR", JOptionPane.OK_OPTION);
                txtUsuario.select(0, txtUsuario.getText().length());
                txtUsuario.requestFocus();
                txt_Password.setText(null);
            } else if (!password.equals(DAOFactory.getInstance().getVendedorDAO(DAOFactory.Motor.MY_SQL).search(rut).get(0).getPass()) || (password.equals(""))) {
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "ERROR", JOptionPane.OK_OPTION);
                txt_Password.setText(null);
                txt_Password.requestFocus();
            } else {
                vendedor = DAOFactory.getInstance().getVendedorDAO(DAOFactory.Motor.MY_SQL).search(rut).get(0);
                System.out.println(vendedor.getId());
                switch (vendedor.getId()) {
                    case 1:
                        ap.setLocationRelativeTo(null);
                        ap.setVisible(true);

//                        menuProfesor.getRutjFrame(rut);//hacer para todos
                        this.setVisible(false);
                        txt_Password.setText(null);
                        break;

                }
            }
        } catch (MotorNoSoportadoException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txt_PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PasswordKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            try {
            rut = txtUsuario.getText();
            String password = new String(txt_Password.getPassword());

            password = md5(password);
            App ap = new App();

            if (rut.equals("") || !rut.equals(DAOFactory.getInstance().getVendedorDAO(DAOFactory.Motor.MY_SQL).getByRut(rut))) {
                JOptionPane.showMessageDialog(null, "Usuario Invalido", "ERROR", JOptionPane.OK_OPTION);
                txtUsuario.select(0, txtUsuario.getText().length());
                txtUsuario.requestFocus();
                txt_Password.setText(null);
            } else if (!password.equals(DAOFactory.getInstance().getVendedorDAO(DAOFactory.Motor.MY_SQL).search(rut).get(0).getPass()) || (password.equals(""))) {
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "ERROR", JOptionPane.OK_OPTION);
                txt_Password.setText(null);
                txt_Password.requestFocus();
            } else {
                vendedor = DAOFactory.getInstance().getVendedorDAO(DAOFactory.Motor.MY_SQL).search(rut).get(0);
                System.out.println(vendedor.getId());
                switch (vendedor.getId()) {
                    case 1:
                        ap.setLocationRelativeTo(null);
                        ap.setVisible(true);

//                        menuProfesor.getRutjFrame(rut);//hacer para todos
                        this.setVisible(false);
                        txt_Password.setText(null);
                        break;

                }
            }
        } catch (MotorNoSoportadoException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_txt_PasswordKeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtUsuario.setText("");
        txt_Password.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPasswordField txt_Password;
    // End of variables declaration//GEN-END:variables

    private static String getHash(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String md5(String txt) {
        return getHash(txt, "MD5");
    }

}
