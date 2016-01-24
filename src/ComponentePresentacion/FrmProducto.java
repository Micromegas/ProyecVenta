/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmProducto.java
 *
 * Created on 13/08/2010, 03:22:19 PM
 */
package ComponentePresentacion;

import ComponenteClase.*;
import ComponenteDatos.*;
import ComponenteOtros.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author RicharD!!
 */
public class FrmProducto extends javax.swing.JFrame {

    /** Creates new form FrmProducto */
    public FrmProducto() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();

        /*
         *Para carbar la lista de Categorias al combobox
         */
        try {
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bdsistema", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nombre FROM Categoria");
            while (rs.next()) {
                cboCategoriaP.addItem(rs.getObject(1));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
        /*
         *
         */
    }

    /*
     *
     */
    metodos m = new metodos() {
    };
    String ImagenURL;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    public void Mostrar(JPanel p) {
        try {
            //se asigna a "url" el archivo de imagen seleccionado
            URL url = m.getObtener();
            //se lo coloca en memoria
            m.cargar_imagen(url);
            //se aÃ±ade al contenedor
            p.add(new mipanel(m.Obtener_imagen_de_Buffer(), p.getSize()) {
            });
            p.setVisible(true);
            p.repaint();
        } catch (Exception ex) {
            Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
     *
     */

    public void buscarProducto() {
        Producto p = null;
        try {
            p = BDProducto.buscarProducto(Integer.parseInt(txtIdProducto.getText()));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (p != null) {
            try {
                txtIdProducto.setText(String.valueOf(p.getIdProducto()));
                txtNombreP.setText(p.getNombre());
                txtStockP.setText(String.valueOf(p.getStock()));
                txtUnidadMedP.setText(p.getUnidadMed());
                txtPrecioUP.setText(String.valueOf(p.getPreciounidad()));
                cboCategoriaP.setSelectedItem(p.getCategoria().getNomcateg());
                URL url = new URL(p.getImagen());
                m.setObtener(url);
                m.Mostrar(jpImageProd);
            } catch (MalformedURLException ex) {
                Logger.getLogger(FrmProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No exite");
        }
    }
    /*
     *
     */

    public void limpiarTextos() {
        txtIdProducto.setText("");
        txtNombreP.setText("");
        txtStockP.setText("");
        txtUnidadMedP.setText("");
        txtPrecioUP.setText("");
    }

    public void activarTextos(boolean b) {
        txtNombreP.setEditable(b);
        txtStockP.setEditable(b);
        txtUnidadMedP.setEditable(b);
        txtPrecioUP.setEditable(b);
        cboCategoriaP.setEnabled(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtPrecioUP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStockP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNombreP = new javax.swing.JTextArea();
        cboCategoriaP = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jpImageProd = new javax.swing.JPanel();
        btnExaminar = new javax.swing.JButton();
        btnSalirP = new javax.swing.JButton();
        btnAgregarP = new javax.swing.JButton();
        btnBuscarP = new javax.swing.JButton();
        btnNuevoP = new javax.swing.JButton();
        btnCancelarP = new javax.swing.JButton();
        btnEditarP = new javax.swing.JButton();
        btnEliminarP = new javax.swing.JButton();
        btnMostrarP = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtUnidadMedP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(70, 99, 138));

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));

        txtPrecioUP.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("ID Producto :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Categoria :");

        txtStockP.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Precio Und.:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Stock :");

        txtNombreP.setColumns(20);
        txtNombreP.setEditable(false);
        txtNombreP.setRows(5);
        txtNombreP.setText("\n");
        jScrollPane1.setViewportView(txtNombreP);

        cboCategoriaP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Eliga su Categoria" }));
        cboCategoriaP.setEnabled(false);

        jPanel3.setBackground(new java.awt.Color(247, 254, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpImageProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jpImageProdLayout = new javax.swing.GroupLayout(jpImageProd);
        jpImageProd.setLayout(jpImageProdLayout);
        jpImageProdLayout.setHorizontalGroup(
            jpImageProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
        );
        jpImageProdLayout.setVerticalGroup(
            jpImageProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpImageProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpImageProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnExaminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExaminar.setText("Examinar");
        btnExaminar.setEnabled(false);
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });

        btnSalirP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalirP.setText("Salir");
        btnSalirP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPActionPerformed(evt);
            }
        });

        btnAgregarP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregarP.setText("Agregar");
        btnAgregarP.setEnabled(false);
        btnAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPActionPerformed(evt);
            }
        });

        btnBuscarP.setText("...");
        btnBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPActionPerformed(evt);
            }
        });

        btnNuevoP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevoP.setText("Nuevo");
        btnNuevoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPActionPerformed(evt);
            }
        });

        btnCancelarP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelarP.setText("Cancelar");
        btnCancelarP.setEnabled(false);
        btnCancelarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPActionPerformed(evt);
            }
        });

        btnEditarP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditarP.setText("Editar");
        btnEditarP.setEnabled(false);
        btnEditarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPActionPerformed(evt);
            }
        });

        btnEliminarP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminarP.setText("Eliminar");
        btnEliminarP.setEnabled(false);
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });

        btnMostrarP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMostrarP.setText("Mostrar");
        btnMostrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Unid.Med:");

        txtUnidadMedP.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExaminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarP, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(cboCategoriaP, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPrecioUP, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStockP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUnidadMedP, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSalirP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(btnNuevoP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAgregarP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEditarP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEliminarP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnMostrarP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelarP, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarP)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStockP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtUnidadMedP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboCategoriaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExaminar)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoP)
                    .addComponent(btnAgregarP)
                    .addComponent(btnEditarP)
                    .addComponent(btnCancelarP)
                    .addComponent(btnEliminarP)
                    .addComponent(btnMostrarP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalirP)
                .addGap(34, 34, 34))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 22));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("REGISTRO DE PRODUCTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPActionPerformed
        // TODO add your handling code here:
        if (txtNombreP.getText().compareTo("") != 0 && txtStockP.getText().compareTo("") != 0 && txtPrecioUP.getText().compareTo("") != 0) {
            Producto p = new Producto() {
            };
            p.setNombre(txtNombreP.getText());
            p.setStock(Integer.parseInt(txtStockP.getText()));
            p.setUnidadMed(txtUnidadMedP.getText());
            p.setPreciounidad(Float.parseFloat(txtPrecioUP.getText()));
            p.setImagen(ImagenURL);
            try {
                Categoria c = BDCategoria.buscarCategoriaNom((String) cboCategoriaP.getSelectedItem());
                p.setCategoria(c);
                BDProducto.insertarProducto(p);
                JOptionPane.showMessageDialog(null, "[ Datos Registrados ]");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error BD: " + ex.getMessage());
            }
        }
        limpiarTextos();
    }//GEN-LAST:event_btnAgregarPActionPerformed

    private void btnBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPActionPerformed
        // TODO add your handling code here:
        if (txtIdProducto.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "Deseas Buscar el Producto para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                buscarProducto();
                btnNuevoP.setEnabled(false);
                btnMostrarP.setEnabled(false);
                btnCancelarP.setEnabled(true);
                btnExaminar.setEnabled(true);
                btnEditarP.setEnabled(true);
                activarTextos(true);
            }
            if (result == JOptionPane.NO_OPTION) {
                buscarProducto();
                btnEliminarP.setEnabled(true);
                btnNuevoP.setEnabled(false);
                btnCancelarP.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese IDProd que Desea Buscar");
        }

    }//GEN-LAST:event_btnBuscarPActionPerformed

    private void btnEditarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPActionPerformed
        // TODO add your handling code here:
        Producto p;
        try {
            p = BDProducto.buscarProductoSinIm(Integer.parseInt(txtIdProducto.getText()));
            p.setNombre(txtNombreP.getText());
            p.setStock(Integer.parseInt(txtStockP.getText()));
            p.setUnidadMed(txtUnidadMedP.getText());
            p.setPreciounidad(Float.parseFloat(txtPrecioUP.getText()));
            p.setImagen(ImagenURL);
            Categoria c = BDCategoria.buscarCategoriaNom((String) cboCategoriaP.getSelectedItem());
            p.setCategoria(c);
            BDProducto.actualizarProducto(p);
            JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
        }
        limpiarTextos();
    }//GEN-LAST:event_btnEditarPActionPerformed

    private void btnMostrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPActionPerformed
        // TODO add your handling code here:
        JDListaProductos LP = new JDListaProductos(this, true);
        LP.setVisible(true);
    }//GEN-LAST:event_btnMostrarPActionPerformed

    private void btnSalirPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirPActionPerformed

    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
        // TODO add your handling code here:
        try {
            Producto p = BDProducto.buscarProducto(Integer.parseInt(txtIdProducto.getText()));
            if (p == null) {
                JOptionPane.showMessageDialog(null, "El Producto no Existe.!!");
            } else {
                BDProducto.eliminarProducto(p.getIdProducto());
                JOptionPane.showMessageDialog(null, "Se Elimino Exitosamente..OKz!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
        limpiarTextos();
    }//GEN-LAST:event_btnEliminarPActionPerformed

    private void btnNuevoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPActionPerformed
        // TODO add your handling code here:
        limpiarTextos();
        activarTextos(true);
        txtIdProducto.setEditable(false);
        btnNuevoP.setEnabled(false);
        btnAgregarP.setEnabled(true);
        btnCancelarP.setEnabled(true);
        btnExaminar.setEnabled(true);
        btnBuscarP.setEnabled(false);
        btnMostrarP.setEnabled(false);

    }//GEN-LAST:event_btnNuevoPActionPerformed

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        // TODO add your handling code here:
        jpImageProd.removeAll();
        m.Abrir_Dialogo(jpImageProd);
        ImagenURL = m.ObtenerUrl();
    }//GEN-LAST:event_btnExaminarActionPerformed

    private void btnCancelarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPActionPerformed
        // TODO add your handling code here:
        limpiarTextos();
        activarTextos(false);
        txtIdProducto.setEditable(true);
        btnCancelarP.setEnabled(false);
        btnEliminarP.setEnabled(false);
        btnNuevoP.setEnabled(true);
        btnMostrarP.setEnabled(true);
        btnBuscarP.setEnabled(true);
        btnAgregarP.setEnabled(false);
        btnExaminar.setEnabled(false);
        btnEditarP.setEnabled(false);
    }//GEN-LAST:event_btnCancelarPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmProducto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarP;
    private javax.swing.JButton btnBuscarP;
    private javax.swing.JButton btnCancelarP;
    private javax.swing.JButton btnEditarP;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnMostrarP;
    private javax.swing.JButton btnNuevoP;
    private javax.swing.JButton btnSalirP;
    private javax.swing.JComboBox cboCategoriaP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpImageProd;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextArea txtNombreP;
    private javax.swing.JTextField txtPrecioUP;
    private javax.swing.JTextField txtStockP;
    private javax.swing.JTextField txtUnidadMedP;
    // End of variables declaration//GEN-END:variables
}
