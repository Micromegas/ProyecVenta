/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmBuscarProductoVN.java
 *
 * Created on 29/08/2010, 11:30:16 PM
 */
package ComponentePresentacion;

import ComponenteClase.Producto;
import ComponenteDatos.BDProducto;
import java.awt.event.*;
import java.net.*;
import java.sql.SQLException;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guillermo
 */
public class FrmBuscarProductoVN extends javax.swing.JFrame {

    DefaultTableModel LProductosNV = new DefaultTableModel();
    private FrmNotaVenta frmtnov;

    /** Creates new form FrmBuscarProductoVN */
    public FrmBuscarProductoVN(final FrmNotaVenta frmtnov) {
        /*
         *
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        this.frmtnov = frmtnov;
        /*
         */
        String titulos[] = {"IdPROD.", "NOMBRE", "PRECIO UND.", "STOCK", "UNID.MED"};
        LProductosNV.setColumnIdentifiers(titulos);
        try {
            for (Producto p : BDProducto.mostrarProducto()) {
                /* String.valueOf(p.getSexo())*/
                String Datos[] = {String.valueOf(p.getIdProducto()), p.getNombre(), String.valueOf(p.getPreciounidad()), String.valueOf(p.getStock()), p.getUnidadMed()};
                LProductosNV.addRow(Datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
        /*
         */
        /*
         * Metodo que me permitira poder obtener los elementos de una fila, cuando es seleccionada de un JTABLE
         */
        jtproductosNV.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = jtproductosNV.rowAtPoint(e.getPoint());
                int columna = jtproductosNV.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    try {
                        //System.out.println(LProductos.getValueAt(fila, 0));
                        Producto u = BDProducto.buscarProducto(Integer.parseInt(String.valueOf(LProductosNV.getValueAt(fila, 0))));
                        frmtnov.txtNombrePNV.setText(u.getNombre());
                        frmtnov.txtIdProdNV.setText(String.valueOf(u.getIdProducto()));
                        frmtnov.txtPrecioUndNV.setText(String.valueOf(u.getPreciounidad()));
                        frmtnov.txtStockNV.setText(String.valueOf(u.getStock()));
                        frmtnov.txtUnidadMedNV.setText(u.getUnidadMed());
                        frmtnov.jpImageProdNV.removeAll();
                        try {
                            URL url = new URL(u.getImagen());
                            frmtnov.m.setObtener(url);
                            frmtnov.m.Mostrar(frmtnov.jpImageProdNV);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(JDListaProductos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(JDListaProductos.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproductosNV = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(81, 105, 138));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTA DE PRODUCTOS");

        jtproductosNV.setBackground(new java.awt.Color(247, 254, 255));
        jtproductosNV.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jtproductosNV.setModel(LProductosNV);
        jScrollPane1.setViewportView(jtproductosNV);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(176, 176, 176))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmBuscarProductoVN(null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtproductosNV;
    // End of variables declaration//GEN-END:variables
}
