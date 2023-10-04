/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.BrandDAO;
import dao.ProductDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Brand;
import model.Product;

/**
 *
 * @author joaov
 */
public class Produtos extends javax.swing.JFrame {
    
    private ProductDAO productDAO;
    private BrandDAO brandDAO;

    /**
     * Creates new form Produtos
     */
    public Produtos() throws SQLException {
        initComponents();
        Connection con = ConnectionFactory.getConnection();
        this.productDAO = new ProductDAO(con);
        this.brandDAO = new BrandDAO(con);
        fillBrandsComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtInputBarCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtInputName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtInputPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        btnShowProducts = new javax.swing.JButton();
        btnUpdateProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        cbxBrands = new javax.swing.JComboBox<>();
        btnSaveProduct = new javax.swing.JButton();
        txtInputParam = new javax.swing.JTextField();
        cbxParam = new javax.swing.JComboBox<>();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Cadastro de Produtos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Produtos");

        jLabel2.setText("Código de Barras");

        txtInputBarCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputBarCodeActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome");

        txtInputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputNameActionPerformed(evt);
            }
        });

        jLabel5.setText("Preço");

        txtInputPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputPriceActionPerformed(evt);
            }
        });

        jLabel6.setText("Marca");

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Código de Barras", "Nome", "Marca", "Preço", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProducts);

        btnShowProducts.setText("Pesquisar");
        btnShowProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowProductsActionPerformed(evt);
            }
        });

        btnUpdateProduct.setText("Atualizar");
        btnUpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProductActionPerformed(evt);
            }
        });

        btnDeleteProduct.setText("Excluir");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        btnSaveProduct.setText("Salvar");
        btnSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProductActionPerformed(evt);
            }
        });

        cbxParam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Código Barras", "Nome", "Marca" }));

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
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(121, 121, 121)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(txtInputBarCode)
                                    .addComponent(cbxBrands, 0, 186, Short.MAX_VALUE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtInputName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSaveProduct)
                                .addGap(638, 638, 638)))
                        .addGap(0, 355, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateProduct))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDeleteProduct)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxParam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtInputParam, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnShowProducts)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInputBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInputPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBrands, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSaveProduct)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtInputParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowProducts))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateProduct)
                    .addComponent(btnDeleteProduct))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtInputBarCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputBarCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputBarCodeActionPerformed

    private void txtInputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputNameActionPerformed

    private void txtInputPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputPriceActionPerformed

    private void btnShowProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowProductsActionPerformed
        String paramType = cbxParam.getSelectedItem().toString();
        List<Product> products = new ArrayList<>();
        
        switch (paramType) {
            case "Todos": 
                products = productDAO.getAllProducts();
                break;
            case "Código Barras":
                Product product = productDAO.getProductByBarCode(txtInputParam.getText().trim());
                products.add(product);
                break;
            case "Nome":
                products = productDAO.getProductsByName(txtInputParam.getText().trim());
                break;
            case "Marca":
                products = productDAO.getProductsByBrandName(txtInputParam.getText().trim());
                break;
        }   
        
        DefaultTableModel tblModel = (DefaultTableModel) tblProducts.getModel();
        tblModel.setRowCount(0);
        for (Product product : products) {
            String data[] = {product.getProductId().toString(), product.getBarCode(), product.getName(), product.getBrand().getName(), product.getPrice().toString(), product.getQuantity().toString()};
            tblModel.addRow(data);            
        }
    }//GEN-LAST:event_btnShowProductsActionPerformed

    private void btnUpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProductActionPerformed
        int row = tblProducts.getSelectedRow();
        
        Integer productId = Integer.parseInt(tblProducts.getModel().getValueAt(row, 0).toString());
        String barCode = tblProducts.getModel().getValueAt(row, 1).toString();
        String name = tblProducts.getModel().getValueAt(row, 2).toString();
        Double price = Double.parseDouble(tblProducts.getModel().getValueAt(row, 4).toString());
        
        Product product = new Product();
        product.setProductId(productId);
        product.setBarCode(barCode);
        product.setName(name);
        Brand b = new Brand();
        b.setName(cbxBrands.getSelectedItem().toString());
        product.setBrand(b);
        product.setPrice(price);
        
        String msg = productDAO.saveProduct(product);
        JOptionPane.showMessageDialog(this, msg);
    }//GEN-LAST:event_btnUpdateProductActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        int row = tblProducts.getSelectedRow();
        String productIdString = tblProducts.getModel().getValueAt(row, 0).toString();
        Integer productIdInt = Integer.parseInt(productIdString);
        String msg = productDAO.deleteProduct(productIdInt);
        JOptionPane.showMessageDialog(this, msg);
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void fillBrandsComboBox() {
        List<Brand> brands = brandDAO.getAllBrands();
        ArrayList<Map.Entry<Integer, String>> a = new ArrayList<Map.Entry<Integer, String>>();
        for (Brand b : brands) {
            cbxBrands.addItem(b.getName());
        }    
    }
    
    private void btnSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductActionPerformed
        Product product = new Product();
        product.setBarCode(txtInputBarCode.getText());
        product.setName(txtInputName.getText());
        Brand brand = new Brand();
        brand.setName(cbxBrands.getSelectedItem().toString());
        product.setBrand(brand);
        product.setPrice(Double.parseDouble(txtInputPrice.getText()));
        String msg = productDAO.saveProduct(product);
        JOptionPane.showMessageDialog(this, msg);
        limparCampos();
    }//GEN-LAST:event_btnSaveProductActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        limparCampos();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed
    
    public void limparCampos() {
        txtInputBarCode.setText("");
        txtInputName.setText("");
        txtInputPrice.setText("");
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
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Produtos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSaveProduct;
    private javax.swing.JButton btnShowProducts;
    private javax.swing.JButton btnUpdateProduct;
    private javax.swing.JComboBox<String> cbxBrands;
    private javax.swing.JComboBox<String> cbxParam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtInputBarCode;
    private javax.swing.JTextField txtInputName;
    private javax.swing.JTextField txtInputParam;
    private javax.swing.JTextField txtInputPrice;
    // End of variables declaration//GEN-END:variables
}