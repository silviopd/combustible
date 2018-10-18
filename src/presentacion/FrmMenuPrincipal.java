
package presentacion;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import util.Funciones;


public class FrmMenuPrincipal extends javax.swing.JFrame {

   
    public FrmMenuPrincipal() {
        initComponents();
        this.setExtendedState( JFrame.MAXIMIZED_BOTH );
        this.setTitle( Funciones.NOMBRE_SOFTWARE +  " [ Menú Principal ]" );
        this.lblFecha.setText("Fecha: " + Funciones.obtenerFechaActual());
        this.lblUsuario.setText("Usuario: " + Funciones.NOMBRE_USUARIO_LOGUEADO);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator7 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        lblFecha = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        lblUsuario = new javax.swing.JLabel();
        dpContenedor = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuCategorias = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnuClientes = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuCompras = new javax.swing.JMenuItem();
        mnuComanda = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/articulos.png"))); // NOI18N
        jButton1.setToolTipText("Mantenimiento de artículos");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        jButton2.setToolTipText("Mantenimiento de clientes");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator9);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor.png"))); // NOI18N
        jButton3.setToolTipText("Mantenimiento de proveedores");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator8);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/compra2.png"))); // NOI18N
        jButton4.setToolTipText("registro de compras");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas2.png"))); // NOI18N
        jButton5.setToolTipText("Registro de ventas");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator10);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        jButton6.setToolTipText("Salir del sistema");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);

        jToolBar2.setRollover(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bienvenido.png"))); // NOI18N
        jLabel1.setText("Bienvenido  ");
        jToolBar2.add(jLabel1);
        jToolBar2.add(jSeparator11);

        lblFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.png"))); // NOI18N
        lblFecha.setText("jLabel2");
        jToolBar2.add(lblFecha);
        jToolBar2.add(jSeparator12);

        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N
        lblUsuario.setText("jLabel2");
        jToolBar2.add(lblUsuario);

        javax.swing.GroupLayout dpContenedorLayout = new javax.swing.GroupLayout(dpContenedor);
        dpContenedor.setLayout(dpContenedorLayout);
        dpContenedorLayout.setHorizontalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dpContenedorLayout.setVerticalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lineas.png"))); // NOI18N
        jMenuItem1.setText("Lineas");
        jMenu1.add(jMenuItem1);

        mnuCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categorias.png"))); // NOI18N
        mnuCategorias.setText("Categorías");
        mnuCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCategoriasActionPerformed(evt);
            }
        });
        jMenu1.add(mnuCategorias);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bienvenido.png"))); // NOI18N
        jMenuItem3.setText("Marcas");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/articulos.png"))); // NOI18N
        jMenuItem4.setText("Artículos");
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator2);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zonas.png"))); // NOI18N
        jMenuItem5.setText("Zonas");
        jMenu1.add(jMenuItem5);

        mnuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        mnuClientes.setText("Clientes");
        mnuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClientesActionPerformed(evt);
            }
        });
        jMenu1.add(mnuClientes);
        jMenu1.add(jSeparator1);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor.png"))); // NOI18N
        jMenuItem7.setText("Proveedores");
        jMenu1.add(jMenuItem7);
        jMenu1.add(jSeparator3);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/areas.png"))); // NOI18N
        jMenuItem8.setText("Áreas");
        jMenu1.add(jMenuItem8);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargos.png"))); // NOI18N
        jMenuItem9.setText("Cargos");
        jMenu1.add(jMenuItem9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario2.png"))); // NOI18N
        jMenuItem10.setText("Personal");
        jMenu1.add(jMenuItem10);
        jMenu1.add(jSeparator4);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sucursales.png"))); // NOI18N
        jMenuItem11.setText("Sucursales");
        jMenu1.add(jMenuItem11);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/almacen.png"))); // NOI18N
        jMenuItem12.setText("Almacenes");
        jMenu1.add(jMenuItem12);
        jMenu1.add(jSeparator5);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas.png"))); // NOI18N
        jMenuItem13.setText("Tipos de comprobante de pago");
        jMenu1.add(jMenuItem13);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas2.png"))); // NOI18N
        jMenuItem14.setText("Series y Correlativos");
        jMenu1.add(jMenuItem14);
        jMenu1.add(jSeparator6);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        jMenuItem15.setText("Salir");
        jMenu1.add(jMenuItem15);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Transacciones");

        mnuCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/compra2.png"))); // NOI18N
        mnuCompras.setText("Compras");
        mnuCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuComprasActionPerformed(evt);
            }
        });
        jMenu2.add(mnuCompras);

        mnuComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas2.png"))); // NOI18N
        mnuComanda.setText("Ventas");
        mnuComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuComandaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuComanda);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Administración del Sistema");

        jMenuItem18.setText("Usuarios");
        jMenu4.add(jMenuItem18);

        jMenuItem19.setText("Cambiar contraseña");
        jMenu4.add(jMenuItem19);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ayuda");

        jMenuItem20.setText("Manuales de usuario");
        jMenu5.add(jMenuItem20);

        jMenuItem21.setText("Acerca de...");
        jMenu5.add(jMenuItem21);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
            .addComponent(dpContenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpContenedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCategoriasActionPerformed
       
    }//GEN-LAST:event_mnuCategoriasActionPerformed

    private void mnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClientesActionPerformed
        
    }//GEN-LAST:event_mnuClientesActionPerformed

    private void mnuComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuComprasActionPerformed
        
    }//GEN-LAST:event_mnuComprasActionPerformed

    private void mnuComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuComandaActionPerformed
        FrmVentaListado objFrm = new FrmVentaListado();
        this.dpContenedor.add(objFrm);
        objFrm.setVisible(true);
    }//GEN-LAST:event_mnuComandaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpContenedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem mnuCategorias;
    private javax.swing.JMenuItem mnuClientes;
    private javax.swing.JMenuItem mnuComanda;
    private javax.swing.JMenuItem mnuCompras;
    // End of variables declaration//GEN-END:variables
}
