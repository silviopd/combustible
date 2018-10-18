
package presentacion;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import negocio.Cliente;
import negocio.VentaDetalle;
import negocio.Caja;
import negocio.Venta;
import util.Funciones;

public class FrmVenta extends javax.swing.JDialog {

    public int valorRetorno = 0;
  
    public FrmVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //Centrar el formulario
        this.setLocationRelativeTo(null);
        //Para que se muestre los TC cuando cargue el formulario
        llenarComboC();
        
        
        /*Lamar aqui al método para configurar las columnas de la jtable tblCompraDetalle*/
        configurarCabeceradetalleComanda();
        
        
        
        //Asignar el modo de selección y el alto a cada fila del jtable tblCompraDetalle
        tblComandaDetalle.setCellSelectionEnabled(true);
        tblComandaDetalle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblComandaDetalle.setRowHeight(25);
        //Asignar el modo de selección y el alto a cada fila del jtable tblCompraDetalle
        
        

        //LLamar aqui al método para obtener la tasa de IGV
        
        
        obtenerFecha();
        
    }
    
    private void obtenerFecha(){
    java.util.Date objFecha = new java.util.Date();
    this.txtFecha.setDate(objFecha);
    }
    
    private boolean validarDatosDetalle(){
            for (int i = 0; i < this.tblComandaDetalle.getRowCount(); i++) {
            double cantidad = Double.parseDouble(this.tblComandaDetalle.getValueAt(i,2).toString() );
            
            String producto = this.tblComandaDetalle.getValueAt(i, 1).toString();
            if (cantidad <=0){
                Funciones.mensajeAdvertencia("Falta ingresar la cantidad para el producto : "+producto, "verifique");
                tblComandaDetalle.changeSelection(i, 2, false, false);
                tblComandaDetalle.requestFocus();
                return false;
            }
        }
            
           
            
            return true;
    }
    
    private boolean validarDatos(){
        
         if(this.txtFecha.getDate() == null){
            Funciones.mensajeAdvertencia("debe ingresar la fecha", "verifique");
            this.txtFecha.requestFocus();
            return false;
        }else if(this.cboCliente.getSelectedItem().toString().isEmpty()){
            Funciones.mensajeAdvertencia("debe seleccionar un cliente", "verifique");
            this.cboCliente.requestFocus();
            return false;
        }else if(this.tblComandaDetalle.getRowCount() <=0){
            Funciones.mensajeAdvertencia("debe agregar productos a la venta", "verifique");
            this.tblComandaDetalle.requestFocus();
            return false;
        }
       
        
        
        return true;
        
    }
    
    private void calcularTotales(){
        
        double neto =0;
        
        for (int i = 0; i < this.tblComandaDetalle.getRowCount(); i++) {
            double importe = Double.parseDouble( this.tblComandaDetalle.getValueAt(i,3).toString().replace(",", "") );
            neto = neto + importe;
        }
        
        this.lblTotal.setText(Funciones.formatearNumero(neto));
        
    }
    
    private void configurarCabeceradetalleComanda(){
        try {
            ResultSet resultado = new VentaDetalle().configurarDetalleVenta();
            int anchoCol[] = {70,400,70,70,70};
            String alineacionCol[] = {"C","I","D","D","D"};
            Funciones.llenarTabla(tblComandaDetalle, resultado,anchoCol,alineacionCol);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), "Error");
        }
    }
    

    
    private void llenarComboC(){
        try {
            new Cliente().llenarComboC(cboCliente);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), 
                    Funciones.NOMBRE_SOFTWARE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtNroCompra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cboCliente = new javax.swing.JComboBox<>();
        btnQuitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        /*parte 1*/
        final JTextField field = new JTextField("0");
        final DefaultCellEditor edit = new DefaultCellEditor(field);
        field.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
        field.setForeground(Color.blue);
        /*parte 1*/
        tblComandaDetalle = new javax.swing.JTable(){
            /*parte 2*/
            public boolean isCellEditable(int fila, int columna){
                if ( columna == 3 ){
                    return true;
                }
                return false;
            }

            public TableCellEditor getCellEditor(int row, int col) {
                if (col == 2){
                    field.setDocument(new util.ValidaNumeros());
                }else{
                    field.setDocument(new util.ValidaNumeros(util.ValidaNumeros.ACEPTA_DECIMAL));
                }
                edit.setClickCountToStart(2);
                field.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent e) {
                        field.select(0,0);
                    }
                });
                return edit;
            }
            /*parte 2*/

        };
        btnGrabar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rbTipoVenta = new javax.swing.JRadioButton();
        rbTipoVenta2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nº Venta");

        txtNroCompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNroCompra.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Tipo de venta");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Fecha Venta");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Seleccion al cliente");

        cboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btnQuitar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnQuitar.setText("Quitar artículo");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        tblComandaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblComandaDetalle.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                tblComandaDetalleMouseWheelMoved(evt);
            }
        });
        tblComandaDetalle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblComandaDetallePropertyChange(evt);
            }
        });
        tblComandaDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblComandaDetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblComandaDetalle);
        /*parte 3*/
        tblComandaDetalle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                field.setText("");
                field.requestFocus();
            }
        });

        field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode()==10){
                    if (field.getText().isEmpty()){
                        evt.consume();
                    }
                }
            }
        });
        /*parte 3*/

        btnGrabar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGrabar.setText("Grabar la venta");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setText("Artículos registrados en la compra");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(153, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0.00");
        lblTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTotal.setPreferredSize(new java.awt.Dimension(72, 20));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(391, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel17))
                .addContainerGap())
        );

        buttonGroup1.add(rbTipoVenta);
        rbTipoVenta.setText("CONTADO");

        buttonGroup1.add(rbTipoVenta2);
        rbTipoVenta2.setText("CREDITO");
        rbTipoVenta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTipoVenta2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuitar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNroCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbTipoVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbTipoVenta2))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGrabar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNroCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbTipoVenta)
                    .addComponent(rbTipoVenta2)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuitar)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabar)
                    .addComponent(btnSalir))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblComandaDetalleMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_tblComandaDetalleMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblComandaDetalleMouseWheelMoved

    private void tblComandaDetallePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblComandaDetallePropertyChange
        if(evt.getPropertyName().equalsIgnoreCase("tableCellEditor")){
            int columnaEditar= this.tblComandaDetalle.getEditingColumn();
            int filaEditar= this.tblComandaDetalle.getEditingRow();
            if( columnaEditar ==3){
                int importe = Integer.parseInt(this.tblComandaDetalle.getValueAt(filaEditar, 3).toString());
                double precio = Double.parseDouble(this.tblComandaDetalle.getValueAt(filaEditar, 2).toString());
                double galones = new VentaDetalle().calcularGalones(importe, precio);
                
                this.tblComandaDetalle.setValueAt(Funciones.formatearNumero(galones), filaEditar, 4);
                
                this.calcularTotales();
                        
            }
        }
    }//GEN-LAST:event_tblComandaDetallePropertyChange

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(this.validarDatosDetalle() == false){
            return;
        }
        
        if( this.validarDatos() == false){
            return;
        }
        
        int respuesta = Funciones.mensajeConfirmacion("Desea grabar la venta", "Confirme");
        if (respuesta == 1){
            return;
        }
      grabarVenta();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void grabarVenta(){
        try {
            
            String tipoVenta = "";
        if (rbTipoVenta.isSelected()){
            tipoVenta = "1";
        }else{
            tipoVenta = "2";
        }
            int codigoCliente = Cliente.listaC.get(cboCliente.getSelectedIndex()).getCodigo_cliente();
            java.sql.Date fecha = new java.sql.Date( this.txtFecha.getDate().getTime());
            double total = Double.parseDouble(this.lblTotal.getText().replace(",", ""));
            int codigoUsuario =1;
            
            Venta objComanda = new Venta();
            objComanda.setTipo_venta(tipoVenta);
            objComanda.setCodigo_cliente(codigoCliente);
            objComanda.setFecha(fecha);
            objComanda.setTotal(total);
            objComanda.setCodigo_usuario(codigoUsuario);
            
            //capturar datos para grabar en la tabla compra detalle
            ArrayList<VentaDetalle> productosDetalleVenta = new ArrayList<VentaDetalle>();
            for (int i = 0; i < this.tblComandaDetalle.getRowCount(); i++) {
                int codigoCombustible= Integer.parseInt(this.tblComandaDetalle.getValueAt(i, 0).toString());
                
                double precio = Double.parseDouble(this.tblComandaDetalle.getValueAt(i, 2).toString());
                double importe = Double.parseDouble(this.tblComandaDetalle.getValueAt(i, 3).toString());
                double cantidad = Double.parseDouble(this.tblComandaDetalle.getValueAt(i, 4).toString());
                
                VentaDetalle objFila = new VentaDetalle();
                objFila.setCodigo_combustible(codigoCombustible);
                objFila.setPrecio_galon(precio);
                objFila.setImporte_venta(importe);
                objFila.setCantidad_galones(cantidad);
                
                productosDetalleVenta.add(objFila);
            }
            
            if(tipoVenta == "1"){
                
                Caja objCaja = new Caja();
            objCaja.setImporte_venta(total);
            objCaja.setCodigo_usuario(codigoUsuario);
            
            }
            
            
            objComanda.setProductosDetalleVenta(productosDetalleVenta);
            
            
            if(objComanda.grabarVenta()){
                Funciones.mensajeInformacion("grabado correctamente", Funciones.NOMBRE_SOFTWARE);
                valorRetorno =1;
                this.dispose();
            }
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), "Error");
        }
    }
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.valorRetorno = 0;
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        DefaultTableModel tablaDetalle 
                = (DefaultTableModel)this.tblComandaDetalle.getModel();
        
        int fila = this.tblComandaDetalle.getSelectedRow();
        
        if (fila < 0) {
            Funciones.mensajeError("Debe seleccionar una fila", "Verifique");
            return;
        }
        
        String producto = tblComandaDetalle.getValueAt(fila, 1).toString();
        int respuesta = Funciones.mensajeConfirmacion
            (
                "Esta seguro de quitar el producto: " + producto, 
                "Confirme"
            );
        
        if (respuesta != 0){
            return;
        }
        
        tablaDetalle.removeRow( fila );
        this.tblComandaDetalle.setModel(tablaDetalle);
        
        this.calcularTotales();
        
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void tblComandaDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblComandaDetalleKeyPressed

            
    }//GEN-LAST:event_tblComandaDetalleKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void rbTipoVenta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTipoVenta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTipoVenta2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton rbTipoVenta;
    private javax.swing.JRadioButton rbTipoVenta2;
    public javax.swing.JTable tblComandaDetalle;
    public com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNroCompra;
    // End of variables declaration//GEN-END:variables
}
