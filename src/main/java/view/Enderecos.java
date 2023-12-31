/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.AddressDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Address;
import model.Product;

/**
 *
 * @author joaov
 */
public class Enderecos extends javax.swing.JFrame {
    
    private AddressDAO addressDAO;

    /**
     * Creates new form Enderecos
     */
    public Enderecos() throws SQLException {
        initComponents();
        Connection con = ConnectionFactory.getConnection();
        this.addressDAO = new AddressDAO(con);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtInputCity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtInputCep = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtInputRua = new javax.swing.JTextField();
        txtInputNumero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtInputUf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtInputBairro = new javax.swing.JTextField();
        btnSalvarEndereco = new javax.swing.JButton();
        cbxParam = new javax.swing.JComboBox<>();
        txtInputParam = new javax.swing.JTextField();
        btnSearchAddress = new javax.swing.JButton();
        btnUpdateAddress = new javax.swing.JButton();
        btnDeleteAddress = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEnderecos = new javax.swing.JTable();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Cadastro de Endereços");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Endereços");

        jLabel1.setText("Cidade");

        jLabel2.setText("CEP");

        jLabel4.setText("UF");

        jLabel5.setText("Bairro");

        jLabel6.setText("Rua");

        jLabel8.setText("Número");

        btnSalvarEndereco.setText("Salvar");
        btnSalvarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarEnderecoActionPerformed(evt);
            }
        });

        cbxParam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "CEP", "Cidade", "UF", "Rua", "Bairro", "Número" }));

        btnSearchAddress.setText("Pesquisar");
        btnSearchAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAddressActionPerformed(evt);
            }
        });

        btnUpdateAddress.setText("Atualizar");
        btnUpdateAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAddressActionPerformed(evt);
            }
        });

        btnDeleteAddress.setText("Excluir");
        btnDeleteAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAddressActionPerformed(evt);
            }
        });

        tblEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "CEP", "Cidade", "UF", "Rua", "Bairro", "Número"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEnderecos);

        btnExit.setText("Sair");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(254, 254, 254))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvarEndereco)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxParam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtInputParam, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchAddress)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtInputCep, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtInputUf, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtInputBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtInputCity, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtInputRua, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(btnExit)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdateAddress)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteAddress))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInputCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInputCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInputRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInputUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtInputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInputBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnSalvarEndereco)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtInputParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchAddress))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateAddress)
                    .addComponent(btnDeleteAddress))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAddressActionPerformed
        String paramType = cbxParam.getSelectedItem().toString();
        List<Address> addresses = new ArrayList<>();
        
        switch (paramType) {
            case "Todos": 
                addresses = addressDAO.getAllAdresses();
                break;
            case "Cidade":
               addresses = addressDAO.getAdressesByCity(txtInputParam.getText().trim()); 
                break;
        }   
        
        DefaultTableModel tblModel = (DefaultTableModel) tblEnderecos.getModel();
        tblModel.setRowCount(0);
        for (Address ad : addresses) {
            String data[] = {ad.getAddressId().toString(), ad.getCep(), ad.getCity(), ad.getUf(), ad.getStreet(), ad.getDistrict(), ad.getNumber().toString()};
            tblModel.addRow(data);            
        }
    }//GEN-LAST:event_btnSearchAddressActionPerformed

    private void btnUpdateAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAddressActionPerformed
        int row = tblEnderecos.getSelectedRow();
        
        Address address = new Address();
        address.setAddressId(Integer.parseInt(tblEnderecos.getModel().getValueAt(row, 0).toString()));
        address.setCep(tblEnderecos.getModel().getValueAt(row, 1).toString());
        address.setCity(tblEnderecos.getModel().getValueAt(row, 2).toString());
        address.setUf(tblEnderecos.getModel().getValueAt(row, 3).toString());
        address.setStreet(tblEnderecos.getModel().getValueAt(row, 4).toString());
        address.setDistrict(tblEnderecos.getModel().getValueAt(row, 5).toString());
        address.setNumber(Integer.parseInt(tblEnderecos.getModel().getValueAt(row, 6).toString()));
        
        String msg = addressDAO.saveAddress(address);
        
        JOptionPane.showMessageDialog(this, msg);
        limparCampos();
    }//GEN-LAST:event_btnUpdateAddressActionPerformed

    private void btnDeleteAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAddressActionPerformed
        int row = tblEnderecos.getSelectedRow();
        Integer addressId = Integer.parseInt(tblEnderecos.getModel().getValueAt(row, 0).toString());
        String msg = addressDAO.deleteAddress(addressId);
        JOptionPane.showMessageDialog(this, msg);
    }//GEN-LAST:event_btnDeleteAddressActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        limparCampos();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSalvarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarEnderecoActionPerformed
        Address address = new Address();
        address.setCep(txtInputCep.getText());
        address.setCity(txtInputCity.getText());
        address.setUf(txtInputUf.getText());
        address.setStreet(txtInputRua.getText());
        address.setDistrict(txtInputBairro.getText());
        address.setNumber(Integer.parseInt(txtInputNumero.getText()));
        String msg = addressDAO.saveAddress(address);
        JOptionPane.showMessageDialog(this, msg);
        limparCampos();
    }//GEN-LAST:event_btnSalvarEnderecoActionPerformed

    public void limparCampos() {
        txtInputCep.setText("");
        txtInputCity.setText("");
        txtInputUf.setText("");
        txtInputRua.setText("");
        txtInputBairro.setText("");
        txtInputNumero.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(Enderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Enderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Enderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Enderecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Enderecos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Enderecos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteAddress;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSalvarEndereco;
    private javax.swing.JButton btnSearchAddress;
    private javax.swing.JButton btnUpdateAddress;
    private javax.swing.JComboBox<String> cbxParam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEnderecos;
    private javax.swing.JTextField txtInputBairro;
    private javax.swing.JTextField txtInputCep;
    private javax.swing.JTextField txtInputCity;
    private javax.swing.JTextField txtInputNumero;
    private javax.swing.JTextField txtInputParam;
    private javax.swing.JTextField txtInputRua;
    private javax.swing.JTextField txtInputUf;
    // End of variables declaration//GEN-END:variables
}
