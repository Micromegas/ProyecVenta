/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmPanelFondoLogin.java
 *
 * Created on 03/09/2010, 12:01:07 PM
 */

package ComponentePresentacion;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Guillermo
 */
public class FrmPanelFondoLogin extends javax.swing.JPanel {

    /** Creates new form FrmPanelFondoLogin */
    public FrmPanelFondoLogin() {
        initComponents();
        this.setSize(600, 450);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Dimension d=getSize();
        ImageIcon img=new ImageIcon(getClass().getResource("/ComponenteImagenes/Fondo-Visual.jpg"));
        g.drawImage(img.getImage(), 0, 0, d.width, d.height, this);
        setOpaque(false);
        super.paintComponent(g);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
