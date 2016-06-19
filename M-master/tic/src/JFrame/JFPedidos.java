/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;
import GoodsandServices.Packages;
import IODades.DB.IOjdbc;
import IODades.DB.Interfaces.MYSQLjdbc;
import IODades.XMLParsers.Dom.DomPedido;
import Operation.Bill;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class JFPedidos extends javax.swing.JFrame {

    /**
     * Creates new form JFPedidos
     */
    public JFPedidos() {
        initComponents();
        io.open("mysql;92.222.38.97;ticemocionat_negocio;ticemocionat_tic;19E7aWzMTS;",0);
    }

    ArrayList<String> iop = new ArrayList<>();
    ArrayList<Packages> npackage = new ArrayList<>(); 
    int cont = 0;
    int error = 0;
    String[] info;
    
    protected MYSQLjdbc base = new MYSQLjdbc();
    protected IOjdbc io = new IOjdbc(base);
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        paquete_field = new javax.swing.JTextField();
        nombre_field = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        codigo_field = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        cantidad_field = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        fecha_field = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        licencias_field = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        precio_field = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel15.setBackground(new java.awt.Color(0, 102, 51));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 38)); // NOI18N
        jLabel3.setText("TICEMOCIONAT");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(204, 204, 204));

        paquete_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paquete_fieldActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("Nombre cliente");

        jLabel38.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setText("Paquete");

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Codigo");

        jPanel8.setBackground(new java.awt.Color(0, 102, 51));

        jButton13.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jButton13.setText("Export to XML");
        jButton13.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(8, 8, 8), new java.awt.Color(22, 22, 22)));
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton17.setText("Sig.");
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
        });
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Ant.");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton18MouseClicked(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jButton22.setText("Charge Database");
        jButton22.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(8, 8, 8), new java.awt.Color(22, 22, 22)));
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton22MouseClicked(evt);
            }
        });
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton18)
                .addGap(18, 18, 18)
                .addComponent(jButton17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(jButton18)
                    .addComponent(jButton13)
                    .addComponent(jButton22))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        cantidad_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad_fieldActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 51));
        jLabel43.setText("Cantidad");

        fecha_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha_fieldActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(51, 51, 51));
        jLabel44.setText("Fecha");

        licencias_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licencias_fieldActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(51, 51, 51));
        jLabel45.setText("Num. Licencias");

        precio_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio_fieldActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setText("Precio");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel38))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(codigo_field, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(56, 56, 56)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel36)))
                        .addGap(29, 29, 29)
                        .addComponent(paquete_field, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(0, 240, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel45))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(licencias_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(29, 29, 29)
                                .addComponent(fecha_field, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(29, 29, 29)
                                .addComponent(cantidad_field, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombre_field, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(159, 159, 159))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel36))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(nombre_field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigo_field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paquete_field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(precio_field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel46))
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cantidad_field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel43)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha_field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(licencias_field, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked

    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        DomPedido fn = new DomPedido();
        fn.exportdades(npackage, "C:\\factura.txt", 0);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
            if(iop.size() > cont + 1){
                cont += 1;
                update_sql();
            }
    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked
            if(iop.size() != 0 &&  cont > 0){
                cont -= 1;
                update_sql();
            }
    }//GEN-LAST:event_jButton18MouseClicked

    private void paquete_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paquete_fieldActionPerformed
        
    }//GEN-LAST:event_paquete_fieldActionPerformed

    private void jButton22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22MouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        update_sql();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void cantidad_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidad_fieldActionPerformed

    private void fecha_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecha_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha_fieldActionPerformed

    private void licencias_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licencias_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_licencias_fieldActionPerformed

    private void precio_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precio_fieldActionPerformed

    private void update_sql(){
        io.importdades(null,"pedidos INNER JOIN clientes ON pedidos.Clientes_idClientes=clientes.idClientes INNER JOIN pedido_linea ON pedidos.idPedidos=pedido_linea.Pedidos_idPedidos INNER JOIN paquetes ON pedido_linea.Paquetes_idPaquetes=paquetes.idPaquetes;SELECT *;");  
        
        iop = io.getline();
        info = iop.get(cont).split(";");
        
        fecha_field.setText(info[1]);
            
        io.importdades(null,"pedido_linea INNER JOIN pedidos ON pedido_linea.Pedidos_idPedidos=pedidos.idPedidos INNER JOIN clientes ON pedidos.Clientes_idClientes=clientes.idClientes INNER JOIN paquetes ON pedido_linea.Paquetes_idPaquetes=paquetes.idPaquetes;SELECT *;");   
        
        iop = io.getline();
        info = iop.get(cont).split(";");
            
        cantidad_field.setText(info[1]);
        
        io.importdades(null,"paquetes INNER JOIN pedido_linea ON paquetes.idPaquetes=pedido_linea.Paquetes_idPaquetes INNER JOIN pedidos ON pedido_linea.Pedidos_idPedidos=pedidos.idPedidos INNER JOIN clientes ON pedidos.Clientes_idClientes=clientes.idClientes;SELECT *;");   
        
        iop = io.getline();
        info = iop.get(cont).split(";");
        
        paquete_field.setText(info[1]);
        precio_field.setText(info[2]);
        licencias_field.setText(info[3]);
        
        npackage.add(new Packages(info[0],info[1],Float.parseFloat(info[2]),Integer.parseInt(info[3])));
        
        io.importdades(null,"clientes INNER JOIN pedidos ON clientes.idClientes=pedidos.Clientes_idClientes INNER JOIN pedido_linea ON pedidos.idPedidos=pedido_linea.Pedidos_idPedidos INNER JOIN paquetes ON pedido_linea.Paquetes_idPaquetes=paquetes.idPaquetes;SELECT *;");   
        
        iop = io.getline();
        info = iop.get(cont).split(";");
        
        nombre_field.setText(info[1]);
                
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
            java.util.logging.Logger.getLogger(JFPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantidad_field;
    private javax.swing.JTextField codigo_field;
    private javax.swing.JTextField fecha_field;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField licencias_field;
    private javax.swing.JTextField nombre_field;
    private javax.swing.JTextField paquete_field;
    private javax.swing.JTextField precio_field;
    // End of variables declaration//GEN-END:variables
}