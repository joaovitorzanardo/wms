/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author joaov
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Products
     */
    public Inicio() {
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

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuItemProdutos = new javax.swing.JMenuItem();
        menuItemClientes = new javax.swing.JMenuItem();
        menuItemEnderecos = new javax.swing.JMenuItem();
        menuItemMarca = new javax.swing.JMenuItem();
        menuItemPedido = new javax.swing.JMenuItem();
        menuEstoque = new javax.swing.JMenu();
        menuItemAjuste = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        jLabel1.setText("WMS");

        menuCadastros.setText("Cadastros");
        menuCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrosActionPerformed(evt);
            }
        });

        menuItemProdutos.setText("Produtos");
        menuItemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProdutosActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemProdutos);

        menuItemClientes.setText("Clientes");
        menuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClientesActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemClientes);

        menuItemEnderecos.setText("Endereços");
        menuItemEnderecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEnderecosActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemEnderecos);

        menuItemMarca.setText("Marcas");
        menuItemMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMarcaActionPerformed(evt);
            }
        });
        menuCadastros.add(menuItemMarca);

        menuItemPedido.setText("Pedidos");
        menuCadastros.add(menuItemPedido);

        jMenuBar1.add(menuCadastros);

        menuEstoque.setText("Estoque");

        menuItemAjuste.setText("Ajuste");
        menuItemAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAjusteActionPerformed(evt);
            }
        });
        menuEstoque.add(menuItemAjuste);

        jMenuBar1.add(menuEstoque);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(233, 233, 233))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrosActionPerformed
        
    }//GEN-LAST:event_menuCadastrosActionPerformed

    private void menuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClientesActionPerformed
        Clientes clientes;
        try {
            clientes = new Clientes();
            clientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            clientes.setLocationRelativeTo(null);
            clientes.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemClientesActionPerformed

    private void menuItemMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMarcaActionPerformed
        try {
            Marcas marcas = new Marcas();
            marcas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            marcas.setLocationRelativeTo(null);
            marcas.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemMarcaActionPerformed

    private void menuItemProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProdutosActionPerformed
        try {
            Produtos produtos = new Produtos();
            produtos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            produtos.setLocationRelativeTo(null);
            produtos.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemProdutosActionPerformed

    private void menuItemAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAjusteActionPerformed
        try {
            AjustarEstoque ajustarEstoque = new AjustarEstoque();
            ajustarEstoque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ajustarEstoque.setLocationRelativeTo(null);
            ajustarEstoque.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemAjusteActionPerformed

    private void menuItemEnderecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEnderecosActionPerformed
        try {
            Enderecos enderecos = new Enderecos();
            enderecos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            enderecos.setLocationRelativeTo(null);
            enderecos.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemEnderecosActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuEstoque;
    private javax.swing.JMenuItem menuItemAjuste;
    private javax.swing.JMenuItem menuItemClientes;
    private javax.swing.JMenuItem menuItemEnderecos;
    private javax.swing.JMenuItem menuItemMarca;
    private javax.swing.JMenuItem menuItemPedido;
    private javax.swing.JMenuItem menuItemProdutos;
    // End of variables declaration//GEN-END:variables
}
