package Formularios;
import Util.Controlador;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
public class Menu extends javax.swing.JFrame {
    

    private int a=0;
    Controlador objControl = new Controlador();
    
    public void AsignaMenu(String codCargo){
        if(codCargo.equals("Cajera"))
            mnuArchivo.setVisible(false);
        if(codCargo.equals("Secretaria")){
            mnuArchivo.setVisible(false);
            mnuProceso.setVisible(false);
        }

    }

    public Menu() {
        initComponents();
        
        this.setSize(new Dimension(600, 300));
        
        
        this.setMinimumSize(new Dimension(200, 200));
        
        ImageIcon icoCliente=new ImageIcon(getClass().getResource("/imagen/cliente.png"));
        icoCliente=new ImageIcon(icoCliente.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        mnuClientes.setIcon(icoCliente);
        
        ImageIcon icoEmpleado=new ImageIcon(getClass().getResource("/imagen/empleado.jpg"));
        icoEmpleado=new ImageIcon(icoEmpleado.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        mnuEmpleados.setIcon(icoEmpleado);
        
        ImageIcon icoDistrito=new ImageIcon(getClass().getResource("/imagen/distrito.png"));
        icoDistrito=new ImageIcon(icoDistrito.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        mnuDistrito.setIcon(icoDistrito);
        
        ImageIcon icoMarcas=new ImageIcon(getClass().getResource("/imagen/marcas.jpg"));
        icoMarcas=new ImageIcon(icoMarcas.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        mnuMarca.setIcon(icoMarcas);
        
        ImageIcon icoBoleta=new ImageIcon(getClass().getResource("/imagen/boleta.png"));
        icoBoleta=new ImageIcon(icoBoleta.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        Venta.setIcon(icoBoleta);
        
        ImageIcon icoSalir=new ImageIcon(getClass().getResource("/imagen/salir.jpg"));
        icoSalir=new ImageIcon(icoSalir.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        mnuSalir.setIcon(icoSalir);
        
        ImageIcon icoGrafico=new ImageIcon(getClass().getResource("/imagen/grafico.jpg"));
        icoGrafico=new ImageIcon(icoGrafico.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        mnuGrafico.setIcon(icoGrafico);
        
        ImageIcon icoGrafico2=new ImageIcon(getClass().getResource("/imagen/grafico2.jpeg"));
        icoGrafico=new ImageIcon(icoGrafico2.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        mnuGrafico2.setIcon(icoGrafico);
        
        ImageIcon icoCon=new ImageIcon(getClass().getResource("/imagen/consul.jpeg"));
        icoGrafico=new ImageIcon(icoCon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        mnConsulta.setIcon(icoGrafico);
        
        ImageIcon icoPro=new ImageIcon(getClass().getResource("/imagen/produc.jpg"));
        icoPro=new ImageIcon(icoCon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        mnProducto.setIcon(icoPro);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuClientes = new javax.swing.JMenu();
        mnuEmpleados = new javax.swing.JMenu();
        mnuDistrito = new javax.swing.JMenuItem();
        mnuMarca = new javax.swing.JMenuItem();
        mnProducto = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        mnConsulta = new javax.swing.JMenu();
        mnuProceso = new javax.swing.JMenu();
        Venta = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        mnuGrafico = new javax.swing.JMenuItem();
        mnuGrafico2 = new javax.swing.JMenu();
        mnuUtilitarios = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu3.setText("File");
        jMenuBar3.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar3.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar4.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar4.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Facturación");

        jMenuBar1.setBackground(new java.awt.Color(102, 204, 0));
        jMenuBar1.setForeground(new java.awt.Color(0, 204, 51));
        jMenuBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenuBar1MouseExited(evt);
            }
        });

        mnuArchivo.setText("Archivos");
        mnuArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuArchivoMouseClicked(evt);
            }
        });
        mnuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoActionPerformed(evt);
            }
        });

        mnuClientes.setText("Clientes");
        mnuClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuClientesMouseClicked(evt);
            }
        });
        mnuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClientesActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuClientes);

        mnuEmpleados.setText("Empleados");
        mnuEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuEmpleadosMouseClicked(evt);
            }
        });
        mnuEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEmpleadosActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuEmpleados);

        mnuDistrito.setText("Distritos");
        mnuDistrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuDistritoMouseClicked(evt);
            }
        });
        mnuDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDistritoActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuDistrito);

        mnuMarca.setText("Marca");
        mnuMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMarcaActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuMarca);

        mnProducto.setText("Productos");
        mnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnProductoActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnProducto);

        jMenuBar1.add(mnuArchivo);

        mnuConsultas.setText("Consultas");
        mnuConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultasActionPerformed(evt);
            }
        });

        mnConsulta.setText("Consulta de facturas");
        mnConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnConsultaMouseClicked(evt);
            }
        });
        mnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConsultaActionPerformed(evt);
            }
        });
        mnuConsultas.add(mnConsulta);

        jMenuBar1.add(mnuConsultas);

        mnuProceso.setText("Procesos");

        Venta.setText("Venta");
        Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentaActionPerformed(evt);
            }
        });
        mnuProceso.add(Venta);

        jMenuBar1.add(mnuProceso);

        mnuReportes.setText("Reportes");

        mnuGrafico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mnuGrafico.setText("Graficos Ventas");
        mnuGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGraficoActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuGrafico);

        mnuGrafico2.setText("Graficos Compras");
        mnuGrafico2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuGrafico2MouseClicked(evt);
            }
        });
        mnuGrafico2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGrafico2ActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuGrafico2);

        jMenuBar1.add(mnuReportes);

        mnuUtilitarios.setText("Utilitarios");

        mnuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuUtilitarios.add(mnuSalir);

        jMenuBar1.add(mnuUtilitarios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEmpleadosActionPerformed
        
    }//GEN-LAST:event_mnuEmpleadosActionPerformed

    private void mnuEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuEmpleadosMouseClicked
         new FEmpleado().setVisible(true);
    }//GEN-LAST:event_mnuEmpleadosMouseClicked

    private void mnuDistritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuDistritoMouseClicked
        new frmDistrito().setVisible(true);
    }//GEN-LAST:event_mnuDistritoMouseClicked

    private void mnuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoActionPerformed
        
    }//GEN-LAST:event_mnuArchivoActionPerformed

    private void mnuDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDistritoActionPerformed
        new frmDistrito().setVisible(true);
    }//GEN-LAST:event_mnuDistritoActionPerformed

    private void mnuMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMarcaActionPerformed
         new frmMarca().setVisible(true);
    }//GEN-LAST:event_mnuMarcaActionPerformed

    private void VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentaActionPerformed
        new frmVenta().setVisible(true);
    }//GEN-LAST:event_VentaActionPerformed

    private void jMenuBar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1MouseExited

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGraficoActionPerformed
        new frmReporteVentas().setVisible(true);
    }//GEN-LAST:event_mnuGraficoActionPerformed

    private void mnuGrafico2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGrafico2ActionPerformed
        new frmReporteCompras().setVisible(true);
    }//GEN-LAST:event_mnuGrafico2ActionPerformed

    private void mnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConsultaActionPerformed
        
    }//GEN-LAST:event_mnConsultaActionPerformed

    private void mnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClientesActionPerformed
        
    }//GEN-LAST:event_mnuClientesActionPerformed

    private void mnuConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultasActionPerformed
        
    }//GEN-LAST:event_mnuConsultasActionPerformed

    private void mnuGrafico2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuGrafico2MouseClicked
        new frmReporteCompras().setVisible(true);
    }//GEN-LAST:event_mnuGrafico2MouseClicked

    private void mnuArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuArchivoMouseClicked
       
    }//GEN-LAST:event_mnuArchivoMouseClicked

    private void mnConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnConsultaMouseClicked
        new ClienteFactura().setVisible(true);
    }//GEN-LAST:event_mnConsultaMouseClicked

    private void mnuClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuClientesMouseClicked
        new FCliente().setVisible(true);
    }//GEN-LAST:event_mnuClientesMouseClicked

    private void mnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnProductoActionPerformed
        new FProducto().setVisible(true);
    }//GEN-LAST:event_mnProductoActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Venta;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JMenu mnConsulta;
    private javax.swing.JMenuItem mnProducto;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuClientes;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenuItem mnuDistrito;
    private javax.swing.JMenu mnuEmpleados;
    private javax.swing.JMenuItem mnuGrafico;
    private javax.swing.JMenu mnuGrafico2;
    private javax.swing.JMenuItem mnuMarca;
    private javax.swing.JMenu mnuProceso;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenu mnuUtilitarios;
    // End of variables declaration//GEN-END:variables
}
