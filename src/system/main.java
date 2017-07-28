/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Maxwell
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    Connection conn;
    java.sql.Statement statement, statement1;
    ResultSet rs, ts;
    int id = 0, row, col;
     
    double bill;
    PreparedStatement prepared, pt;
    public main() throws SQLException{
        initComponents();
        setTitle("Vehicle Renting and Billing System");
        setSize(1201, 629);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        getContentPane().setBackground(Color.decode("#1c5d72"));
        JFormattedTextField editor = ((JSpinner.DefaultEditor)rentDuration.getEditor()).getTextField();
        editor.setEditable(false);
        Calendar aDate = Calendar.getInstance(Locale.ROOT);
        dateChooserCombo1.setMinDate(aDate);
        

       
        
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/RentingSystemDB", "username", "password");
       
       
        statement = conn.createStatement();
        pt = conn.prepareStatement("ALTER TABLE USERNAME.DB ALTER COLUMN VEHICLE SET DATA TYPE varchar(50)");
        pt.executeUpdate();
        rs = statement.executeQuery("SELECT ID FROM USERNAME.DB ORDER BY ID DESC");
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        id = jTable1.getRowCount();
        theID.setEditable(false);
        
//        theID.setText(String.valueOf(id + 1 + 1));
        
        jButton1.setVisible(false);
        
       
        while(rs.next());
        
        if(theName.getText().equals("") || theAddress.getText().equals("") || !(thePhoneNumber.getText().length() >= 11) ){
        theVehicle.setEnabled(false);
       
        }
        else
        theVehicle.setEnabled(true);
        
       
     
    }
        private JDialog showMessage(String s, String title, String type){
    
            JOptionPane jop = new JOptionPane(s, (type.equals("S")) ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
            JDialog dialog = jop.createDialog(title);
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            return dialog;
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
        dbQuery = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery.getResultList();
        dbQuery1 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery1.getResultList();
        dbQuery2 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery2.getResultList();
        dbQuery3 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList3 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery3.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        theName = new javax.swing.JTextField();
        theAddress = new javax.swing.JTextField();
        thePhoneNumber = new javax.swing.JTextField();
        rentDuration = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        theVehicle = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        receipt = new javax.swing.JTextArea();
        theID = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(730, 64, 39, 20);

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Address");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(730, 100, 51, 14);

        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Phone Number");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(730, 120, 90, 25);

        theName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                theNameKeyTyped(evt);
            }
        });
        getContentPane().add(theName);
        theName.setBounds(820, 60, 356, 25);

        theAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                theAddressKeyTyped(evt);
            }
        });
        getContentPane().add(theAddress);
        theAddress.setBounds(820, 90, 356, 25);

        thePhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                thePhoneNumberKeyTyped(evt);
            }
        });
        getContentPane().add(thePhoneNumber);
        thePhoneNumber.setBounds(820, 120, 356, 25);

        rentDuration.setModel(new javax.swing.SpinnerNumberModel(1, 1, 40, 1));
        rentDuration.setFocusable(false);
        rentDuration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rentDurationKeyTyped(evt);
            }
        });
        getContentPane().add(rentDuration);
        rentDuration.setBounds(820, 150, 356, 29);

        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Rent Duration");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(730, 160, 82, 14);

        theVehicle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MITSUBISHI ADVENTURE 2.5 GLX", "MITSUBISHI MIRAGE GLX 1.6", "TOYOTA INNOVA 2.5 E", "TOYOTA HI-ACE COMMUTER 2.8", "TOYOTA HI-ACE GRANDIA 3.0", "TOYOTA HI-ACE SUPER GRANDIA 3.0", "TOYOTA VIOS 1.3 E", "TOYOTA AVANZA 1.5 J", "HYUNDAI ACCENT 1.6", "HYUNDAI STAREX 2.4" }));
        theVehicle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                theVehicleItemStateChanged(evt);
            }
        });
        theVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                theVehicleMouseClicked(evt);
            }
        });
        theVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theVehicleActionPerformed(evt);
            }
        });
        getContentPane().add(theVehicle);
        theVehicle.setBounds(820, 190, 356, 28);

        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Pick-Up Date");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(730, 230, 83, 30);

        jButton1.setBackground(new java.awt.Color(169, 80, 21));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(750, 560, 410, 23);

        jButton3.setBackground(Color.decode("#228aad"));
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(1070, 310, 103, 23);

        receipt.setEditable(false);
        receipt.setColumns(20);
        receipt.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 13)); // NOI18N
        receipt.setRows(5);
        jScrollPane2.setViewportView(receipt);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(730, 350, 443, 240);

        theID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                theIDKeyTyped(evt);
            }
        });
        getContentPane().add(theID);
        theID.setBounds(820, 30, 356, 25);

        jButton4.setBackground(Color.decode("#228aad"));
        jButton4.setText("Admin");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(860, 280, 120, 23);

        jButton5.setBackground(Color.decode("#228aad"));
        jButton5.setText("View");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(860, 310, 120, 23);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dbList3, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(730, 30, 44, 25);

        jButton6.setBackground(Color.decode("#228aad"));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton6.setText("Confirm Rent");
        jButton6.setActionCommand("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(1070, 280, 103, 23);

        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Select Vehicle");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(730, 200, 83, 14);

        dateChooserCombo1.setCalendarPreferredSize(new java.awt.Dimension(350, 300));
        dateChooserCombo1.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserCombo1OnSelectionChange(evt);
            }
        });
        dateChooserCombo1.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserCombo1OnCommit(evt);
            }
        });
        getContentPane().add(dateChooserCombo1);
        dateChooserCombo1.setBounds(820, 230, 355, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/ezgif.com-gif-maker (1).gif"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 30, 690, 330);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/LogoWhite.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(-40, 350, 750, 220);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void theVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theVehicleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_theVehicleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {                                         
            main m = new main();
            try {
                rentDuration.setFocusable(false);
                
                String name = theName.getText();
                String address = theAddress.getText();
                String phone = (thePhoneNumber.getText());
                int rent = (int)rentDuration.getValue();
                int val = 0,valCheck = 0;
                String vehicle = theVehicle.getSelectedItem().toString();
                String id = theID.getText();
                String date = dateChooserCombo1.getText();
                if(theName.getText().equals("") || theAddress.getText().equals("") || thePhoneNumber.getText().equals("")){
                    
                    
                    showMessage("Please fill all necessary informations", "Error","E");
                    
                }
                else if(thePhoneNumber.getText().length() != 11){
                    
                JOptionPane.showMessageDialog(null, "Check Phone Number");
                }
                
                
                else
                    // TODO add your handling code here:
                    
                    
                    prepared = (PreparedStatement) conn.prepareStatement("INSERT INTO USERNAME.DB (ID, NAME, PHONE, RENT, VEHICLE, ADDRESS, STATUS, DATE, BILL) VALUES (?,?,?,?,?,?,?,?,?)");
                  
                ResultSet rset;
                java.sql.Statement s2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rset = s2.executeQuery("Select ID FROM USERNAME.DB");
                rset.afterLast();

                while(rset.previous()){
                val = rset.getInt("ID");
                valCheck = rset.getInt("ID") + 1;
                break;
                }

       
       
       
                prepared.setInt(1, (val == valCheck) ? val : valCheck);
                prepared.setString(2, name);
                prepared.setLong(3, Long.parseLong(phone));
                prepared.setInt(4, rent);
                prepared.setString(5, vehicle);
                prepared.setString(6, address);
                prepared.setString(7, "SCHEDULED");
                prepared.setString(8, date);
                prepared.setDouble(9, bill);
                
                showMessage("Saved", "Successful", "S");
                prepared.executeUpdate();
                statement.close();
                conn.close();
               
                receipt.setText("ID Number : \t" + String.valueOf(id) + "\n" + "Name: \t" + name + "\nPhone Number: \t " + String.valueOf(phone) + "\n"
                        + "Rent Duration: \t " +String.valueOf(rent) + " days" + "\n" + "Vehicle : \t" + theVehicle.getSelectedItem()+ "\nPick Up Date: \t " + date);
                
               
               
               jButton1.setVisible(false);
//               theID.setText(String.valueOf(Integer.valueOf(theID.getText())+1));
                
            } catch (SQLException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
//        update_Table();
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
//        update_Table();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void thePhoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thePhoneNumberKeyTyped
        // TODO add your handling code here:
                        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            evt.consume();
            
        }
        
        if(!(theName.getText().equals("") || theAddress.getText().equals("") || !(thePhoneNumber.getText().length() >= 10 && !(thePhoneNumber.getText().length() < 10))) ){
        theVehicle.setEnabled(true);
       
        }
                else{
        theVehicle.setEnabled(false);
        }   
        
        
        
    }//GEN-LAST:event_thePhoneNumberKeyTyped

    private void theIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_theIDKeyTyped
        // TODO add your handling code here:
                        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            evt.consume();
            
        }
    }//GEN-LAST:event_theIDKeyTyped

    private void rentDurationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rentDurationKeyTyped
        // TODO add your handling code here:
                        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            evt.consume();
            
        }
    }//GEN-LAST:event_rentDurationKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Prompt p = new Prompt();
        p.setVisible(true);
        
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        theName.setText("");
        theAddress.setText("");
        thePhoneNumber.setText("");
        rentDuration.setValue(1);
         theVehicle.setSelectedIndex(0);
        receipt.setText("");
        theVehicle.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
           ViewPrompt vp = new ViewPrompt();
           vp.setVisible(true);
           this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        //        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        theID.setText(jTable1.getModel().getValueAt(selectedRow, 0).toString());
        theName.setText(jTable1.getModel().getValueAt(selectedRow, 1).toString());
        theAddress.setText(jTable1.getModel().getValueAt(selectedRow, 2).toString());
        thePhoneNumber.setText(jTable1.getModel().getValueAt(selectedRow, 3).toString());
        rentDuration.setValue(jTable1.getModel().getValueAt(selectedRow, 4));

        
                if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("MITSUBISHI ADVENTURE 2.5 GLX")){
            theVehicle.setSelectedIndex(0);}
        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("MITSUBISHI MIRAGE GLX 1.6")){
            theVehicle.setSelectedIndex(1);}
        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA INNOVA 2.5 E")){
            theVehicle.setSelectedIndex(2);}
        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA HI-ACE COMMUTER 2.8")){
            theVehicle.setSelectedIndex(3);}
        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA HI-ACE GRANDIA 3.0")){
            theVehicle.setSelectedIndex(4);}
        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA HI-ACE SUPER GRANDIA 3.0")){
            theVehicle.setSelectedIndex(5);}
        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA VIOS 1.3 E")){
            theVehicle.setSelectedIndex(6);}
        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA AVANZA 1.5 J")){
            theVehicle.setSelectedIndex(7);}        
        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("HYUNDAI ACCENT 1.6")){
            theVehicle.setSelectedIndex(8);}
        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("HYUNDAI STAREX 2.4")){
            theVehicle.setSelectedIndex(9);}

        

        //        receipt.setText("ID Number : \t\t" + jTable1.getModel().getValueAt(selectedRow, 0).toString() + "\n" + "Name: \t\t" + jTable1.getModel().getValueAt(selectedRow, 1).toString()
            //            + "\nAddress: \t\t" + jTable1.getModel().getValueAt(selectedRow, 2).toString()
            //            + "\nPhone Number: \t " + jTable1.getModel().getValueAt(selectedRow, 3).toString()+ "\n"
            //            + "Rent Duration: \t " +jTable1.getModel().getValueAt(selectedRow, 4).toString() + " days");
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
                  
                  
                  
            String name = theName.getText();
            String address = theAddress.getText();
            String phone = (thePhoneNumber.getText());
            int rent = (int)rentDuration.getValue();
            String vehicle = theVehicle.getSelectedItem().toString();
            String id = theID.getText();
            int selectedRow = 0;
            
            
        if(theVehicle.getSelectedIndex() == 0 ){
            bill = rent * 2000;}
        else if((theVehicle.getSelectedIndex() == 1 )){
             bill = rent * 1500;}
        else if((theVehicle.getSelectedIndex() == 2 )){
             bill = rent * 2500;}
        else if((theVehicle.getSelectedIndex() == 3 )){
            bill = rent * 2500;}
        else if((theVehicle.getSelectedIndex() == 4 )){
             bill = rent * 3000;}
        else if((theVehicle.getSelectedIndex() == 5 )){
             bill = rent * 3500;}
        else if((theVehicle.getSelectedIndex() == 6 )){
             bill = rent * 1500;}
        else if((theVehicle.getSelectedIndex() == 7 )){
             bill = rent * 1500;}        
        else if((theVehicle.getSelectedIndex() == 8 )){
             bill = rent * 1500;}
        else if((theVehicle.getSelectedIndex() == 9 )){
             bill = rent * 2500;}
            
            
            String date = dateChooserCombo1.getText();
        
            
            
            
            if(theName.getText().equals("") || theAddress.getText().equals("") || thePhoneNumber.getText().equals("")){
           
            showMessage("Please fill all necessary informations", "Error","E");
            
            }
            
            else {
                jButton1.setVisible(true);
        receipt.setText("ID Number : \t" + String.valueOf(id) + "\n" + "Name: \t" + name + "\nPhone Number: \t " + String.valueOf(phone) + "\n"  
                    + "Rent Duration: \t " +String.valueOf(rent) + " days" + "\n" + "Vehicle : \t" + theVehicle.getSelectedItem()
                    + "\nPick Up Date: \t " + date+ "\nTotal Bill: \t P " + bill);
            }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void theVehicleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_theVehicleItemStateChanged
        // TODO add your handling code here:
        
               String name = theName.getText();
            String address = theAddress.getText();
            String phone = (thePhoneNumber.getText());
            int rent = (int)rentDuration.getValue();
            String vehicle = theVehicle.getSelectedItem().toString();
            String id = theID.getText();
            int selectedRow = 0;
            
            
        if(theVehicle.getSelectedIndex() == 0 ){
            bill = rent * 2000;}
        else if((theVehicle.getSelectedIndex() == 1 )){
             bill = rent * 1500;}
        else if((theVehicle.getSelectedIndex() == 2 )){
             bill = rent * 2500;}
        else if((theVehicle.getSelectedIndex() == 3 )){
            bill = rent * 2500;}
        else if((theVehicle.getSelectedIndex() == 4 )){
             bill = rent * 3000;}
        else if((theVehicle.getSelectedIndex() == 5 )){
             bill = rent * 3500;}
        else if((theVehicle.getSelectedIndex() == 6 )){
             bill = rent * 1500;}
        else if((theVehicle.getSelectedIndex() == 7 )){
             bill = rent * 1500;}        
        else if((theVehicle.getSelectedIndex() == 8 )){
             bill = rent * 1500;}
        else if((theVehicle.getSelectedIndex() == 9 )){
             bill = rent * 2500;}
            
            
            String date = dateChooserCombo1.getText();
        
            
            
            
            if(theName.getText().equals("") || theAddress.getText().equals("") || thePhoneNumber.getText().equals("")){
           
            showMessage("Please fill all necessary informations", "Error","E");
            
            }
            
            else {
                jButton1.setVisible(true);
        receipt.setText("ID Number : \t" + String.valueOf(id) + "\n" + "Name: \t" + name + "\nPhone Number: \t " + String.valueOf(phone) + "\n"  
                    + "Rent Duration: \t " +String.valueOf(rent) + " days" + "\n" + "Vehicle : \t" + theVehicle.getSelectedItem()
                    + "\nPick Up Date: \t " + date+ "\nTotal Bill: \t P " + bill);
            }
    }//GEN-LAST:event_theVehicleItemStateChanged

    private void theVehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_theVehicleMouseClicked
        // TODO add your handling code here:
        
        if(!theVehicle.isEnabled()){
            
            showMessage("One TextField was not filled or Phone Number is not Valid","Input Error","E");
        
        }
        
         
    }//GEN-LAST:event_theVehicleMouseClicked

    private void theNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_theNameKeyTyped
        // TODO add your handling code here:
        
                if(!(theName.getText().equals("") || theAddress.getText().equals("") || !(thePhoneNumber.getText().length() >= 11)) ){
        theVehicle.setEnabled(true);
       
        }
        else
        theVehicle.setEnabled(false);
    }//GEN-LAST:event_theNameKeyTyped

    private void theAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_theAddressKeyTyped
        // TODO add your handling code here:
        
        
        
                
                if(!(theName.getText().equals("") || theAddress.getText().equals("") || !(thePhoneNumber.getText().length() >= 11)) ){
        theVehicle.setEnabled(true);
       
        }
                else{
        theVehicle.setEnabled(false);
    }   
        
    }//GEN-LAST:event_theAddressKeyTyped

    private void dateChooserCombo1OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserCombo1OnSelectionChange
        // TODO add your handling code here:
        
              
    }//GEN-LAST:event_dateChooserCombo1OnSelectionChange

    private void dateChooserCombo1OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserCombo1OnCommit
        // TODO add your handling code here:
         String name = theName.getText();
            String address = theAddress.getText();
            String phone = (thePhoneNumber.getText());
            int rent = (int)rentDuration.getValue();
            String vehicle = theVehicle.getSelectedItem().toString();
            String id = theID.getText();
            int selectedRow = 0;
            
            
        if(theVehicle.getSelectedIndex() == 0 ){
            bill = rent * 2000;}
        else if((theVehicle.getSelectedIndex() == 1 )){
             bill = rent * 1500;}
        else if((theVehicle.getSelectedIndex() == 2 )){
             bill = rent * 2500;}
        else if((theVehicle.getSelectedIndex() == 3 )){
            bill = rent * 2500;}
        else if((theVehicle.getSelectedIndex() == 4 )){
             bill = rent * 3000;}
        else if((theVehicle.getSelectedIndex() == 5 )){
             bill = rent * 3500;}
        else if((theVehicle.getSelectedIndex() == 6 )){
             bill = rent * 1500;}
        else if((theVehicle.getSelectedIndex() == 7 )){
             bill = rent * 1500;}        
        else if((theVehicle.getSelectedIndex() == 8 )){
             bill = rent * 1500;}
        else if((theVehicle.getSelectedIndex() == 9 )){
             bill = rent * 2500;}
            
            
            String date = dateChooserCombo1.getText();
        
            
            
            
            if(theName.getText().equals("") || theAddress.getText().equals("") || thePhoneNumber.getText().equals("")){
           
            showMessage("Please fill all necessary informations", "Error","E");
            
            }
            
            else {
                jButton1.setVisible(true);
        receipt.setText("ID Number : \t" + String.valueOf(id) + "\n" + "Name: \t" + name + "\nPhone Number: \t " + String.valueOf(phone) + "\n"  
                    + "Rent Duration: \t " +String.valueOf(rent) + " days" + "\n" + "Vehicle : \t" + theVehicle.getSelectedItem()
                    + "\nPick Up Date: \t " + date+ "\nTotal Bill: \t P " + bill);
            }
        
    }//GEN-LAST:event_dateChooserCombo1OnCommit

    
    
    
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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new main().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager IT301_System_PUEntityManager;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private java.util.List<system.Db> dbList;
    private java.util.List<system.Db> dbList1;
    private java.util.List<system.Db> dbList2;
    private java.util.List<system.Db> dbList3;
    private javax.persistence.Query dbQuery;
    private javax.persistence.Query dbQuery1;
    private javax.persistence.Query dbQuery2;
    private javax.persistence.Query dbQuery3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea receipt;
    private javax.swing.JSpinner rentDuration;
    private javax.swing.JTextField theAddress;
    private javax.swing.JTextField theID;
    private javax.swing.JTextField theName;
    private javax.swing.JTextField thePhoneNumber;
    private javax.swing.JComboBox<String> theVehicle;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
