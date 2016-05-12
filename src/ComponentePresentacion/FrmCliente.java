/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmCliente.java
 *
 * Created on 13/08/2010, 03:12:00 PM
 */
package ComponentePresentacion;

import java.awt.Toolkit;
import ComponenteClase.Cliente;
import ComponenteDatos.BDCliente;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author DANY
 */
public class FrmCliente extends javax.swing.JFrame {

    /** Creates new form FrmCliente */
    public FrmCliente() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    /*
     * Buscar Cliente
     */
    public void buscarCliente() {
        Cliente c = null;
        try {
            c = BDCliente.buscarCliente(txtCodigoCl.getText());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (c != null) {
            txtCodigoCl.setText(String.valueOf(c.getCodCliente()));
            txtNombreC.setText(c.getNombre());
            txtNomDocumentoC.setText(c.getNomDocumento());
            txtNumDocumentoC.setText(String.valueOf(c.getNumDocumento()));
            txtTelefonoC.setText(c.getTelefono());
            btnEditarC.setEnabled(true);
            btnCancelarC.setEnabled(true);
            if (txtNomDocumentoC.getText().equalsIgnoreCase("CUIT")) {
                rbCjuridico.setSelected(true);
            } else {
                rbCnatural.setSelected(true);
            }
        } else {
            btnEditarC.setEnabled(false);
            btnEliminarC.setEnabled(false);
            btnCancelarC.setEnabled(false);
            txtCodigoCl.setEditable(true);
            JOptionPane.showMessageDialog(null, "No exite");
        }
        btnMostrarC.setEnabled(true);
        btnCancelarC.setEnabled(true);
        txtCodigoCl.setEditable(false);
        btnBuscarC.setEnabled(false);
    }
    /*
     *
     */

    public void limpiarTextos() {
        txtCodigoCl.setText("");
        txtNombreC.setText("");
        txtNomDocumentoC.setText("Nombre del Documento");
        txtNumDocumentoC.setText("");
        txtTelefonoC.setText("");
        rbCjuridico.setSelected(false);
        rbCnatural.setSelected(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnTipoCliente = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rbCnatural = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rbCjuridico = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtNomDocumentoC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNumDocumentoC = new javax.swing.JTextField();
        btnBuscarC = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTelefonoC = new javax.swing.JFormattedTextField();
        btnNuevoC = new javax.swing.JButton();
        btnAgregarC = new javax.swing.JButton();
        btnEliminarC = new javax.swing.JButton();
        btnEditarC = new javax.swing.JButton();
        btnCancelarC = new javax.swing.JButton();
        btnMostrarC = new javax.swing.JButton();
        btnSalirC = new javax.swing.JButton();
        txtCodigoCl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(70, 99, 138));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(247, 254, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Codigo:");

        txtNombreC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        rbCnatural.setBackground(new java.awt.Color(247, 254, 255));
        BtnTipoCliente.add(rbCnatural);
        rbCnatural.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbCnatural.setText("P.Natural");
        rbCnatural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCnaturalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tipo de Cliente:");

        rbCjuridico.setBackground(new java.awt.Color(247, 254, 255));
        BtnTipoCliente.add(rbCjuridico);
        rbCjuridico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbCjuridico.setText("P.Juridica");
        rbCjuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCjuridicoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nombre del Documento:");

        txtNomDocumentoC.setEditable(false);
        txtNomDocumentoC.setBackground(new java.awt.Color(247, 254, 255));
        txtNomDocumentoC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNomDocumentoC.setText("Nombre del Documento");
        txtNomDocumentoC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Numero de Documento:");

        txtNumDocumentoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumDocumentoCActionPerformed(evt);
            }
        });

        btnBuscarC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarC.setText(".....");
        btnBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Telefono:");

        try {
            txtTelefonoC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###)-###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnNuevoC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevoC.setText("Nuevo");
        btnNuevoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCActionPerformed(evt);
            }
        });

        btnAgregarC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregarC.setText("Agregar");
        btnAgregarC.setEnabled(false);
        btnAgregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCActionPerformed(evt);
            }
        });

        btnEliminarC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminarC.setText("Eliminar");
        btnEliminarC.setEnabled(false);
        btnEliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCActionPerformed(evt);
            }
        });

        btnEditarC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditarC.setText("Editar");
        btnEditarC.setEnabled(false);
        btnEditarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCActionPerformed(evt);
            }
        });

        btnCancelarC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelarC.setText("Cancelar");
        btnCancelarC.setEnabled(false);
        btnCancelarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCActionPerformed(evt);
            }
        });

        btnMostrarC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMostrarC.setText("Mostrar");
        btnMostrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCActionPerformed(evt);
            }
        });

        btnSalirC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalirC.setText("Salir");
        btnSalirC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomDocumentoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(rbCjuridico)
                                .addGap(18, 18, 18)
                                .addComponent(rbCnatural))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnNuevoC, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarC, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditarC, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrarC, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreC))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNumDocumentoC, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTelefonoC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoCl, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalirC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbCjuridico)
                    .addComponent(rbCnatural))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNomDocumentoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefonoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumDocumentoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditarC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelarC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMostrarC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevoC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalirC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("REGISTRO DE CLIENTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumDocumentoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumDocumentoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumDocumentoCActionPerformed

    private void txtNombreCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCKeyTyped
        // TODO add your handling code here:
        if (!String.valueOf(evt.getKeyChar()).matches("[a-zA-Z]|\\s")) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreCKeyTyped

    private void btnBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCActionPerformed
        // TODO add your handling code here:
        if (txtCodigoCl.getText().compareTo("") != 0) {
            int result = JOptionPane.showConfirmDialog(
                    this, "Deseas Buscar al Cliente para Modificarlo?",
                    "Mensaje..!!",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                buscarCliente();
                btnEditarC.setEnabled(true);
            }
            if (result == JOptionPane.NO_OPTION) {
                buscarCliente();
                btnEliminarC.setEnabled(true);
                btnEditarC.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese Codigo del Cliente a Buscar");
        }
    }//GEN-LAST:event_btnBuscarCActionPerformed

    private void btnAgregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCActionPerformed
        // TODO add your handling code here:

        if (txtCodigoCl.getText().compareTo("") != 0 && txtNombreC.getText().compareTo("") != 0
                && (rbCjuridico.isSelected() == true || rbCnatural.isSelected() == true)
                && txtNumDocumentoC.getText().compareTo("") != 0 && txtTelefonoC.getText().compareTo("") != 0) {
            Cliente c = new Cliente() {
            };
            c.setCodCliente(txtCodigoCl.getText());
            c.setNombre(txtNombreC.getText());
            c.setNomDocumento(txtNomDocumentoC.getText());
            c.setNumDocumento(txtNumDocumentoC.getText());
            c.setTelefono(txtTelefonoC.getText());
            try {
                BDCliente.insertarCliente(c);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Datos Agregados Correctamente");
            limpiarTextos();
        } else {
            JOptionPane.showMessageDialog(null, "Llene Todos Los Campos..OKz");
        }
    }//GEN-LAST:event_btnAgregarCActionPerformed

    private void btnEliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCActionPerformed
        // TODO add your handling code here:
        try {
            Cliente d = BDCliente.buscarCliente(txtCodigoCl.getText());
            if (d == null) {
                JOptionPane.showMessageDialog(null, "No existe");
            } else {
                BDCliente.eliminarCliente(d.getCodCliente());
                JOptionPane.showMessageDialog(null, "Se elimino Exitosamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
        limpiarTextos();
    }//GEN-LAST:event_btnEliminarCActionPerformed

    private void btnEditarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCActionPerformed
        // TODO add your handling code here
        Cliente c;
        try {
            c = BDCliente.buscarCliente(txtCodigoCl.getText());
            c.setNombre(txtNombreC.getText());
            c.setNomDocumento(txtNomDocumentoC.getText());
            c.setNumDocumento(txtNumDocumentoC.getText());
            c.setTelefono(txtTelefonoC.getText());
            BDCliente.actualizarCliente(c);
            JOptionPane.showMessageDialog(null, " [ Datos Actualizados ]");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
        }
        limpiarTextos();
    }//GEN-LAST:event_btnEditarCActionPerformed

    private void btnCancelarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCActionPerformed
        // TODO add your handling code here:
        limpiarTextos();
        txtCodigoCl.setEditable(true);
        btnAgregarC.setEnabled(false);
        btnCancelarC.setEnabled(false);
        btnBuscarC.setEnabled(true);
        btnNuevoC.setEnabled(true);
    }//GEN-LAST:event_btnCancelarCActionPerformed

    private void btnMostrarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCActionPerformed
        // TODO add your handling code here:
        JDListaClientes lc = new JDListaClientes(this, true);
        lc.setVisible(true);
    }//GEN-LAST:event_btnMostrarCActionPerformed

    private void btnNuevoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCActionPerformed
        // TODO add your handling code here:
        limpiarTextos();
        txtCodigoCl.setEditable(true);
        btnAgregarC.setEnabled(true);
        btnCancelarC.setEnabled(true);
        btnBuscarC.setEnabled(false);
        btnNuevoC.setEnabled(false);
    }//GEN-LAST:event_btnNuevoCActionPerformed

    private void btnSalirCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirCActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirCActionPerformed

    private void rbCjuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCjuridicoActionPerformed
        // TODO add your handling code here:
        if (rbCjuridico.isSelected()) {
            txtNomDocumentoC.setText("CUIT");
        }
    }//GEN-LAST:event_rbCjuridicoActionPerformed

    private void rbCnaturalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCnaturalActionPerformed
        // TODO add your handling code here:
        if (rbCnatural.isSelected()) {
            txtNomDocumentoC.setText("DNI");
        }
    }//GEN-LAST:event_rbCnaturalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnTipoCliente;
    private javax.swing.JButton btnAgregarC;
    private javax.swing.JButton btnBuscarC;
    private javax.swing.JButton btnCancelarC;
    private javax.swing.JButton btnEditarC;
    private javax.swing.JButton btnEliminarC;
    private javax.swing.JButton btnMostrarC;
    private javax.swing.JButton btnNuevoC;
    private javax.swing.JButton btnSalirC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rbCjuridico;
    private javax.swing.JRadioButton rbCnatural;
    private javax.swing.JTextField txtCodigoCl;
    private javax.swing.JTextField txtNomDocumentoC;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNumDocumentoC;
    private javax.swing.JFormattedTextField txtTelefonoC;
    // End of variables declaration//GEN-END:variables
}
