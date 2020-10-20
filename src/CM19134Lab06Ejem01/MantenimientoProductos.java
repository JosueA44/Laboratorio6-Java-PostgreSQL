
package CM19134Lab06Ejem01;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MantenimientoProductos extends javax.swing.JFrame {

    public ProductoTableModel productoTModel=new ProductoTableModel();
    private Connection conexion;
    boolean guardar;
    Producto productoActual;

    public MantenimientoProductos() {
        initComponents();
        inicializarColumnas();
        conectar();
        consultaInicial();
        
        setTitle("Mantenimiento de Productos");
        Toolkit resolucion=Toolkit.getDefaultToolkit();
        Dimension tamaño=resolucion.getScreenSize();
        int alto=tamaño.height;
        int ancho=tamaño.width;
        setLocation(ancho/4,alto/4);
        Image icono=resolucion.getImage("icono-herramienta.png");
        setIconImage(icono);
    }
    
    private void inicializarColumnas() {
        TableColumnModel tColumnModel = new DefaultTableColumnModel();
        for (int i = 0; i < 4; i++) {
            TableColumn col = new TableColumn(i);
            switch (i){
                case 0:
                    col.setHeaderValue("Código");
                    break;
                case 1:
                    col.setHeaderValue("Nombre");
                    break;
                case 2:
                    col.setHeaderValue("Existencia");
                    break;
                case 3:
                    col.setHeaderValue("Precio");
            }      
            tColumnModel.addColumn(col);
        }
        tablaProductos.setColumnModel(tColumnModel);
    }
    
    private void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cm19134","cm19134","prn315CM19134");
        }
        catch (SQLException ex) {
            //Logger.getLogger(MantenimientoProductos.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    private void consultaInicial() {
       try {
           String sentenciaSql = "SELECT * FROM producto";
           Statement statement = this.conexion.createStatement();
           ResultSet resultado = statement.executeQuery(sentenciaSql);
           while (resultado.next()) {
               Producto producto = new Producto();
               producto.codigo = resultado.getString("idproducto");
               producto.nombre = resultado.getString("nomproducto");
               producto.cantidadExistencia = resultado.getDouble("exisproducto");
               producto.precioUnitario = resultado.getDouble("precproducto");
               this.productoTModel.productos.add(producto);
           }
           
           tablaProductos.repaint();

       }
       catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Error al recuperar los productos de la base de datos");

       }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBusqCodigo = new javax.swing.JTextField();
        txtBusqNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnElimina = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCantidadExistencia = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JFormattedTextField();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel1.setText("Criterios de busqueda");

        jPanel1.setBackground(new java.awt.Color(255, 226, 226));

        jLabel2.setText("Código:");

        jLabel3.setText("Nombre:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtBusqCodigo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBusqNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBusqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtBusqNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnBuscar)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tablaProductos.setModel(productoTModel);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        btnElimina.setText("Eliminar Seleccionados");
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 226, 226));

        jLabel4.setText("Código:");

        jLabel5.setText("Nombre:");

        jLabel6.setText("Cantidad de Existe...");

        jLabel7.setText("Precio Unitario:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnGuardar)
                        .addGap(119, 119, 119)
                        .addComponent(btnNuevo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel8.setText("Matenimiento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnElimina))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnElimina)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         productoTModel.productos.clear();
         try {
            PreparedStatement statement = null;
            String codigo = txtBusqCodigo.getText().toString();
            String nombre = txtBusqNombre.getText().toString();
            
            String sentenciaSql = "SELECT*FROM producto ";
            if (!codigo.isEmpty()){
                 if (!nombre.isEmpty()){
                    sentenciaSql += "WHERE idproducto ILIKE ? OR nomproducto ILIKE ?";
                    statement = this.conexion.prepareStatement(sentenciaSql);
                    statement.setString(1, codigo + "%");
                    statement.setString(2, "%" + nombre + "%");
                 }
                 else{
                    sentenciaSql += "WHERE idproducto ILIKE ?";
                    statement = this.conexion.prepareStatement(sentenciaSql);
                    statement.setString(1, codigo + "%");
                 }
            }
            else{
                 if (!nombre.isEmpty()){
                    sentenciaSql += "WHERE nomproducto ILIKE ?";
                    statement = this.conexion.prepareStatement(sentenciaSql);
                    statement.setString(1, "%" + nombre + "%");
                 }
                 else{
                     statement = this.conexion.prepareStatement(sentenciaSql);
                 }
            }
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()){
                Producto producto = new Producto();
                producto.codigo = resultado.getString("idproducto");
                producto.nombre = resultado.getString("nomproducto");
                producto.precioUnitario = resultado.getDouble("precproducto");
                producto.cantidadExistencia = resultado.getDouble("exisproducto");
                productoTModel.productos.add(producto);
            }
            tablaProductos.repaint();
         }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(this,"Error al recuperar los productos de la base de datos");
            ex.printStackTrace();
        }
             
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed
        
        //Indices de las filas seleccionadas
        int[] indices = tablaProductos.getSelectedRows();
        List<Producto> aEliminar = new ArrayList<Producto>();
        for (int i : indices) {
            Producto producto = productoTModel.productos.get(i);
            String sentenciaSql = "DELETE FROM producto WHERE idproducto = ?";
            aEliminar.add(producto);
            try {
                PreparedStatement prepStat = conexion.prepareStatement(sentenciaSql);
                prepStat.setString(1, producto.codigo);
                prepStat.executeUpdate();
                JOptionPane.showMessageDialog(this, "Elimino correctamente " + producto.codigo);
                UpdateJTable();
            }
             catch (SQLException ex) {
                 Logger.getLogger(MantenimientoProductos.class.getName()).log(Level.SEVERE, null, ex);
             }

        }
        tablaProductos.repaint();
    }//GEN-LAST:event_btnEliminaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       try{
           if(guardar){
               Producto producto = new Producto();
               producto.codigo = txtCodigo.getText();
               producto.nombre = txtNombre.getText();
               producto.cantidadExistencia = Double.parseDouble(txtCantidadExistencia.getText());
               producto.precioUnitario = Double.parseDouble(txtPrecioUnitario.getText());
               String sentenciaSql="INSERT INTO producto(idproducto,nomproducto,precproducto,exisproducto) VALUES"+"(?,?,?,?)";
               PreparedStatement preparedStatement=conexion.prepareStatement(sentenciaSql);
               preparedStatement.setString(1,producto.codigo);
               preparedStatement.setString(2,producto.nombre);
               preparedStatement.setDouble(3,producto.cantidadExistencia);
               preparedStatement.setDouble(4,producto.precioUnitario);
               preparedStatement.execute();
               productoTModel.productos.add(producto);
               
           }
           else{
               String sentenciaSql ="UPDATE producto SET nomproducto = ?,exisproducto=?,precproducto= ? WHERE idproducto = ?";
               PreparedStatement preparedStatement =conexion.prepareStatement(sentenciaSql);
               preparedStatement.setString(1,txtNombre.getText());
               preparedStatement.setDouble(2,Double.parseDouble(txtCantidadExistencia.getText()));
               preparedStatement.setDouble(3,Double.parseDouble(txtPrecioUnitario.getText()) );
               preparedStatement.setString(4,txtCodigo.getText());
               preparedStatement.executeUpdate();
               productoActual.cantidadExistencia=Double.parseDouble(txtCantidadExistencia.getText());
               productoActual.codigo=txtCodigo.getText();
               productoActual.nombre=txtNombre.getText();
               productoActual.precioUnitario=Double.parseDouble(txtPrecioUnitario.getText());
           }
           tablaProductos.repaint();;
       }
       catch(SQLException ex){
           JOptionPane.showMessageDialog(this,"Error al guardar el producto");
           ex.printStackTrace();
       }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtCodigo.setText("");
        guardar=true;
        productoActual=null;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            conexion.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Ocurrió un error al cerrar la conexión a la base de datos");
        }
        JOptionPane.showMessageDialog(this,"La conexion a la base de datos ha sido cerrada");       
    }//GEN-LAST:event_formWindowClosing

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        int clics =evt.getClickCount();
        int row = tablaProductos.rowAtPoint(evt.getPoint());
        if (clics == 2) {
            Producto p = productoTModel.productos.get(row);
            productoActual = p;
            txtCodigo.setText(p.codigo);
            txtNombre.setText(p.nombre);
            txtCantidadExistencia.setText(String.valueOf(p.cantidadExistencia.doubleValue()));
            txtPrecioUnitario.setText(String.valueOf(p.precioUnitario.doubleValue()));
            guardar = false;
        }
    }//GEN-LAST:event_tablaProductosMouseClicked
 
    private void UpdateJTable() {
        productoTModel.productos.clear();
        try{
            PreparedStatement statement = null;
            String sentenciaSql = "SELECT * FROM producto";
            statement = this.conexion.prepareStatement(sentenciaSql);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()){
                Producto producto = new Producto();
                producto.codigo = resultado.getString("idproducto");
                producto.nombre = resultado.getString("nomproducto");
                producto.precioUnitario = resultado.getDouble("precproducto");
                producto.cantidadExistencia = resultado.getDouble("exisproducto");
                productoTModel.productos.add(producto);
            }
            tablaProductos.repaint();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al recuperar los productos de la base de datos");
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnElimina;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBusqCodigo;
    private javax.swing.JTextField txtBusqNombre;
    private javax.swing.JFormattedTextField txtCantidadExistencia;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtPrecioUnitario;
    // End of variables declaration//GEN-END:variables
}
