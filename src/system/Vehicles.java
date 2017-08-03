/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Maxwell
 */
public class Vehicles extends javax.swing.JFrame {

    /**
     * Creates new form Vehicles
     */
        Connection conn;
        java.sql.Statement statement, statementResult;
        ResultSet rs,returnDate, pickupDate, vehicle;
        PreparedStatement prepared,pt;
        int selectedRow;
    public Vehicles() throws SQLException {
        initComponents();
        setTitle("Vehicle");
        setSize(850, 400);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        getContentPane().setBackground(Color.decode("#55baaf"));
        jPanel1.setBackground(Color.decode("#7fe2d8"));
        jPanel2.setBackground(Color.decode("#59c1b7"));
        jPanel3.setBackground(Color.decode("#68d8cc"));
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/RentingSystemDB", "username", "password");
        statement = conn.createStatement();
        rs = statement.executeQuery("SELECT * FROM USERNAME.VEHICLES");
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        while(rs.next());
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        IT301_System_PUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("IT301_System_PU").createEntityManager();
        vehicles_1Query = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT v FROM Vehicles_1 v");
        vehicles_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : vehicles_1Query.getResultList();
        vehicles_1Query1 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT v FROM Vehicles_1 v");
        vehicles_1List1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : vehicles_1Query1.getResultList();
        vehicles_1Query2 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT v FROM Vehicles_1 v");
        vehicles_1List2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : vehicles_1Query2.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        plate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        modify = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vehicles");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 31, 260, 30);

        jLabel2.setText("Vehicle Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 101, 80, 25);
        getContentPane().add(name);
        name.setBounds(111, 103, 166, 23);

        jLabel3.setText("Vehicle Type");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 135, 80, 23);
        getContentPane().add(type);
        type.setBounds(111, 132, 166, 26);

        jLabel4.setText("Plate Number");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 164, 80, 27);
        getContentPane().add(plate);
        plate.setBounds(112, 164, 165, 27);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 240, 80, 23);

        jLabel5.setText("Modifying ...");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 73, 80, 20);

        modify.setEditable(false);
        getContentPane().add(modify);
        modify.setBounds(109, 72, 168, 23);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 240, 79, 23);

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(110, 270, 80, 23);

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(200, 270, 79, 23);

        jLabel6.setText("Renting Price");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 200, 80, 27);
        getContentPane().add(price);
        price.setBounds(110, 200, 165, 27);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, vehicles_1List2, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vehicleName}"));
        columnBinding.setColumnName("Vehicle Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${plateNumber}"));
        columnBinding.setColumnName("Plate Number");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vehicleType}"));
        columnBinding.setColumnName("Vehicle Type");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${price}"));
        columnBinding.setColumnName("Price");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(330, 29, 492, 320);

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(30, 330, 266, 23);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 30, 260, 30);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 20, 300, 340);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(320, 20, 510, 340);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
         if(name.getText().equalsIgnoreCase("")){
        
        showMessage("Can't Perform Deletion" ,"Deletion Error","E");
        }
        else{
            try {
                prepared = (PreparedStatement) conn.prepareStatement("DELETE FROM USERNAME.VEHICLES WHERE VEHICLE_NAME = ?");
                prepared.setString(1, modify.getText());
                
                showMessage("Client [ " + name.getText() + " ] Deleted","Successful Delete","S");
                prepared.executeUpdate();
     
                update_Table();
                        modify.setText("");
                        name.setText("");
                        type.setText("");
                        plate.setText("");
                        price.setText("");
       
       
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(name.getText().equals("") || type.getText().equals("") || plate.getText().equals("")){
           showMessage("Incomplete Information","Incomplete Error","E");}
            
                
        else{
        
            try {
                prepared = (PreparedStatement) conn.prepareStatement("INSERT INTO USERNAME.VEHICLES (VEHICLE_NAME, VEHICLE_TYPE, PLATE_NUMBER, PRICE) VALUES (?,?,?,?)");
                prepared.setString(1, name.getText());
                prepared.setString(2, type.getText());
                prepared.setString(3, plate.getText());
                prepared.setString(4, price.getText());
                prepared.executeUpdate();
                update_Table();
     
                
                showMessage("[ " + type.getText() + " ] Has been added","VEHICLE ADDED","S");
            } catch (SQLException ex) {
                Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane jop = new JOptionPane(name.getText() + " " + "[ " + plate.getText() +" ]" + " already exist", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = jop.createDialog("Duplication Error");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            }
        
        
        
        }            
                
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
       
        modify.setText(jTable1.getModel().getValueAt(selectedRow, 0).toString());
        name.setText(jTable1.getModel().getValueAt(selectedRow, 0).toString());
        plate.setText(jTable1.getModel().getValueAt(selectedRow, 2).toString());
        type.setText(jTable1.getModel().getValueAt(selectedRow, 1).toString());
        price.setText(jTable1.getModel().getValueAt(selectedRow, 3).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            try {
                // TODO add your handling code her
               Admin m = new Admin();
                m.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
            }
                
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         if(name.getText().equals("") || type.getText().equals("") || plate.getText().equals("")){
           showMessage("Incomplete Information","Incomplete Error","E");}
            
                
        else{
        
            try {
                prepared = (PreparedStatement) conn.prepareStatement("UPDATE USERNAME.VEHICLES SET VEHICLE_NAME = ?, VEHICLE_TYPE = ?, PLATE_NUMBER = ?, PRICE = ? WHERE VEHICLE_NAME = ?");
                prepared.setString(1, name.getText());
                prepared.setString(2, type.getText());
                prepared.setString(3, plate.getText());
                prepared.setString(4, price.getText());
                prepared.setString(5, modify.getText());
                prepared.executeUpdate();
                update_Table();
      
                
              showMessage("[ " + modify.getText() + " ] Has been added","VEHICLE UPDATED","S");
                        modify.setText("");
                        name.setText("");
                        type.setText("");
                        plate.setText("");
                        price.setText("");
        
                
                
            } catch (SQLException ex) {
                Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        modify.setText("");
        name.setText("");
        type.setText("");
        plate.setText("");
        price.setText("");
        update_Table();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    
    
    
      private void update_Table(){
    try{

    String sql = "Select * from USERNAME.VEHICLES";
    conn = DriverManager.getConnection("jdbc:derby://localhost:1527/RentingSystemDB", "username", "password");
    prepared = conn.prepareStatement(sql);
    rs = prepared.executeQuery();
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    
    }
    finally{
    try{
    
    rs.close();
    prepared.close();
    
    }
    catch (Exception e){}
    }
    
    
    try{prepared.close();}
    catch(Exception e){}
    }
     
      
    private JDialog showMessage(String s, String title, String type){
    
            JOptionPane jop = new JOptionPane(s, (type.equals("S")) ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
            JDialog dialog = jop.createDialog(title);
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            return dialog;
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
//            java.util.logging.Logger.getLogger(Vehicles.class.getName()).log(java.util.modifyel.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Vehicles().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Vehicles.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager IT301_System_PUEntityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField modify;
    private javax.swing.JTextField name;
    private javax.swing.JTextField plate;
    private javax.swing.JTextField price;
    private javax.swing.JTextField type;
    private java.util.List<system.Vehicles_1> vehicles_1List;
    private java.util.List<system.Vehicles_1> vehicles_1List1;
    private java.util.List<system.Vehicles_1> vehicles_1List2;
    private javax.persistence.Query vehicles_1Query;
    private javax.persistence.Query vehicles_1Query1;
    private javax.persistence.Query vehicles_1Query2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
