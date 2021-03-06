/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Maxwell
 */
public class Admin extends javax.swing.JFrame {
        Connection conn;
        java.sql.Statement statement, statementResult;
        ResultSet rs,returnDate, pickupDate, vehicle;
        PreparedStatement prepared,pt;
        int selectedRow;
        DateFormat dateFormat = new SimpleDateFormat("M/d/yy");
        DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
    /**
     * Creates new form 
     */
    public Admin() throws SQLException{
        initComponents();
        setTitle("Admin");
        setSize(1285, 752);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        getContentPane().setBackground(Color.decode("#1C1B1B"));
        jPanel1.setBackground(Color.decode("#282525"));
        jPanel2.setBackground(Color.decode("#282525"));
        jPanel3.setBackground(Color.decode("#3B3434"));
        jPanel4.setBackground(Color.decode("#282525"));
        jPanel5.setBackground(Color.decode("#3B3434"));
        employeeBar.setBackground(Color.decode("#3B3434"));
        clientBar.setBackground(Color.decode("#3B3434"));
        clientTableBar.setBackground(Color.decode("#282525"));
        employeeTableBar.setBackground(Color.decode("#282525"));
        jScrollPane1.getViewport().setBackground(Color.decode("#221D1D"));
        jScrollPane2.getViewport().setBackground(Color.decode("#221D1D"));
        jScrollPane3.getViewport().setBackground(Color.decode("#221D1D"));
        jScrollPane4.getViewport().setBackground(Color.decode("#221D1D"));
        jScrollPane6.getViewport().setBackground(Color.decode("#221D1D"));
        JFormattedTextField editor = ((JSpinner.DefaultEditor)rentDuration.getEditor()).getTextField();
        editor.setEditable(false);
        
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/RentingSystemDB", "username", "password");
        statement = conn.createStatement();
        pt = conn.prepareStatement("ALTER TABLE USERNAME.DB ALTER COLUMN VEHICLE SET DATA TYPE varchar(50)");
        pt.executeUpdate();
        rs = statement.executeQuery("Select * from USERNAME.DB ORDER BY ID ASC");
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        Date date = new Date();
   
        
        while(rs.next());
        
        vehicle = statement.executeQuery("SELECT * FROM USERNAME.VEHICLES");
        vehicleTable.setModel(DbUtils.resultSetToTableModel(vehicle));
        while(vehicle.next());
        statementResult = conn.createStatement();
//        String theDate = dateFormat.format(date).substring();
//JOptionPane.showMessageDialog(null, dateFormat.format(date));
        jLabel17.setText("On Pick-Up : (Date Today) :" + dateFormat1.format(date));
        pickupDate = statementResult.executeQuery("Select NAME, VEHICLE FROM USERNAME.DB WHERE DATE = '"+dateFormat.format(date)+"' AND STATUS != 'RETURNED' ORDER BY DATE DESC ");
        pickTable.setModel(DbUtils.resultSetToTableModel(pickupDate));
        
        
           while(pickupDate.next());
           
           
           
        String query = "SELECT * FROM USERNAME.VEHICLES";
        ResultSet v = statement.executeQuery(query);
        while(v.next()){
        String vehicle = v.getString("VEHICLE_NAME");
        theVehicle.addItem(vehicle);
        }
        
         
//        DefaultTableModel tReturn = new DefaultTableModel();
//        ResultSet rset;
//        tReturn.addColumn("Name");
//        tReturn.addColumn("Vehicle");
//        String name, vehicle;
//        try{
//                java.sql.Statement s2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//                rset = s2.executeQuery("Select NAME, VEHICLE FROM USERNAME.DB");
//                rset.next();
//
//                while(rset.next()){
//                name = rset.getString("NAME");
//                vehicle = rset.getString("VEHICLE");
//                returnTable.setModel(tReturn);
//                tReturn.addRow(new Object[]{name,vehicle});
//                
//                break;}
//        }
//                catch(Exception e){printStackTrace();}
        

        
        
       
        
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
        dbQuery4 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList4 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery4.getResultList();
        dbQuery5 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList5 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery5.getResultList();
        dbQuery6 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList6 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery6.getResultList();
        dbQuery7 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList7 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery7.getResultList();
        dbQuery8 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList8 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery8.getResultList();
        dbQuery9 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList9 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery9.getResultList();
        dbQuery10 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList10 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery10.getResultList();
        managementQuery = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT m FROM Management m");
        managementList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : managementQuery.getResultList();
        managementQuery1 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT m FROM Management m");
        managementList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : managementQuery1.getResultList();
        dbQuery11 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList11 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery11.getResultList();
        dbQuery12 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList12 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery12.getResultList();
        vehicles_1Query = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT v FROM Vehicles_1 v");
        vehicles_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : vehicles_1Query.getResultList();
        dbQuery13 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList13 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery13.getResultList();
        dbQuery14 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList14 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery14.getResultList();
        dbQuery15 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList15 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery15.getResultList();
        vehicles_1Query1 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT v FROM Vehicles_1 v");
        vehicles_1List1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : vehicles_1Query1.getResultList();
        dbQuery16 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT d FROM Db d");
        dbList16 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : dbQuery16.getResultList();
        managementQuery2 = java.beans.Beans.isDesignTime() ? null : IT301_System_PUEntityManager.createQuery("SELECT m FROM Management m");
        managementList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : managementQuery2.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        filter1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        search1 = new javax.swing.JTextField();
        search = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        filter = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        thePosition = new javax.swing.JComboBox<>();
        thePassword = new javax.swing.JTextField();
        theUsername = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        theName = new javax.swing.JTextField();
        theID = new javax.swing.JTextField();
        rentDuration = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        theVehicle = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel8 = new javax.swing.JLabel();
        thePhoneNumber = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        theAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        clientReturnDate = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        employeeBar = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        clientBar = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pickTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        clientTableBar = new javax.swing.JPanel();
        employeeTableBar = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        vehicleTable = new javax.swing.JTable();
        jB = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(19, 18, 18));
        jScrollPane1.setForeground(new java.awt.Color(240, 240, 240));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setBackground(new java.awt.Color(32, 29, 29));
        jTable1.setForeground(new java.awt.Color(240, 240, 240));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dbList13, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${phone}"));
        columnBinding.setColumnName("Phone");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rent}"));
        columnBinding.setColumnName("Rent");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vehicle}"));
        columnBinding.setColumnName("Vehicle");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${status}"));
        columnBinding.setColumnName("Status");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bill}"));
        columnBinding.setColumnName("Bill");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(390, 50, 590, 380);

        jScrollPane2.setBackground(new java.awt.Color(19, 18, 18));
        jScrollPane2.setForeground(new java.awt.Color(240, 240, 240));

        jTable2.setBackground(new java.awt.Color(32, 29, 29));
        jTable2.setForeground(new java.awt.Color(240, 240, 240));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, managementList2, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${username}"));
        columnBinding.setColumnName("Username");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${password}"));
        columnBinding.setColumnName("Password");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${position}"));
        columnBinding.setColumnName("Position");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(390, 490, 590, 220);

        jButton10.setBackground(new java.awt.Color(51, 51, 51));
        jButton10.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jButton10.setForeground(new java.awt.Color(240, 240, 240));
        jButton10.setText("Search");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(920, 460, 63, 20);

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setForeground(new java.awt.Color(240, 240, 240));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(20, 685, 340, 30);

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Search by :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(390, 20, 51, 13);

        filter1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        filter1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Username", "Position" }));
        filter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter1ActionPerformed(evt);
            }
        });
        getContentPane().add(filter1);
        filter1.setBounds(450, 460, 110, 16);

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(240, 240, 240));
        jLabel15.setText("Search by :");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(390, 460, 51, 13);

        search1.setBackground(new java.awt.Color(51, 51, 51));
        search1.setForeground(new java.awt.Color(240, 240, 240));
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search1KeyTyped(evt);
            }
        });
        getContentPane().add(search1);
        search1.setBounds(570, 460, 340, 20);

        search.setBackground(new java.awt.Color(51, 51, 51));
        search.setForeground(new java.awt.Color(240, 240, 240));
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(520, 20, 382, 20);

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(240, 240, 240));
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(910, 20, 63, 20);

        filter.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAME", "ADDRESS", "PHONE", "VEHICLE", "STATUS" }));
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });
        getContentPane().add(filter);
        filter.setBounds(450, 20, 67, 16);

        jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        jLabel18.setText("Return Date for Clients ");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(1020, 270, 220, 20);

        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText("On Pick Up Date");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(1020, 80, 240, 20);

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton8.setForeground(new java.awt.Color(240, 240, 240));
        jButton8.setText("Reset");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(240, 650, 110, 20);

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton7.setForeground(new java.awt.Color(240, 240, 240));
        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(240, 620, 110, 20);

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton6.setForeground(new java.awt.Color(240, 240, 240));
        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(110, 620, 110, 20);

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton9.setForeground(new java.awt.Color(240, 240, 240));
        jButton9.setText("Change");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(110, 650, 110, 20);

        thePosition.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        thePosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee", "Admin" }));
        getContentPane().add(thePosition);
        thePosition.setBounds(110, 580, 240, 30);

        thePassword.setBackground(new java.awt.Color(51, 51, 51));
        thePassword.setForeground(new java.awt.Color(240, 240, 240));
        getContentPane().add(thePassword);
        thePassword.setBounds(110, 540, 240, 30);

        theUsername.setBackground(new java.awt.Color(51, 51, 51));
        theUsername.setForeground(new java.awt.Color(240, 240, 240));
        theUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                theUsernameKeyTyped(evt);
            }
        });
        getContentPane().add(theUsername);
        theUsername.setBounds(110, 500, 240, 30);

        id.setBackground(new java.awt.Color(51, 51, 51));
        id.setForeground(new java.awt.Color(240, 240, 240));
        id.setEnabled(false);
        getContentPane().add(id);
        id.setBounds(110, 460, 240, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Modifying..");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(20, 460, 83, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("Username");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 500, 83, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("Password");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 540, 83, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("State");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 580, 83, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(240, 240, 240));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Employee & Admin");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 420, 330, 17);

        status.setBackground(new java.awt.Color(240, 240, 240));
        status.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ON USE", "SCHEDULED", "ONHOLD", "NOT RETURNED", "RETURNED" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        getContentPane().add(status);
        status.setBounds(100, 270, 259, 28);

        theName.setBackground(new java.awt.Color(51, 51, 51));
        theName.setForeground(new java.awt.Color(240, 240, 240));
        theName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                theNameKeyTyped(evt);
            }
        });
        getContentPane().add(theName);
        theName.setBounds(100, 100, 259, 25);

        theID.setBackground(new java.awt.Color(51, 51, 51));
        theID.setForeground(new java.awt.Color(240, 240, 240));
        theID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                theIDKeyTyped(evt);
            }
        });
        getContentPane().add(theID);
        theID.setBounds(100, 70, 259, 25);

        rentDuration.setModel(new javax.swing.SpinnerNumberModel(1, 1, 40, 1));
        rentDuration.setFocusable(false);
        rentDuration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rentDurationKeyTyped(evt);
            }
        });
        getContentPane().add(rentDuration);
        rentDuration.setBounds(100, 190, 259, 29);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Address");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 140, 86, 13);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Vehicle");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 240, 83, 13);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 355, 110, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Clients");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 30, 340, 17);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Rent Duration");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 200, 80, 13);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Mobile");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 160, 80, 25);

        theVehicle.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        theVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theVehicleActionPerformed(evt);
            }
        });
        getContentPane().add(theVehicle);
        theVehicle.setBounds(100, 230, 259, 28);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Pick-Up Date");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 310, 90, 30);

        dateChooserCombo1.setCalendarBackground(new java.awt.Color(51, 255, 51));
        dateChooserCombo1.setCalendarPreferredSize(new java.awt.Dimension(350, 300));
        getContentPane().add(dateChooserCombo1);
        dateChooserCombo1.setBounds(100, 310, 260, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Vehicle Status");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 280, 83, 13);

        thePhoneNumber.setBackground(new java.awt.Color(51, 51, 51));
        thePhoneNumber.setForeground(new java.awt.Color(240, 240, 240));
        thePhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                thePhoneNumberKeyTyped(evt);
            }
        });
        getContentPane().add(thePhoneNumber);
        thePhoneNumber.setBounds(100, 160, 259, 25);

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(240, 355, 110, 20);

        theAddress.setBackground(new java.awt.Color(51, 51, 51));
        theAddress.setForeground(new java.awt.Color(240, 240, 240));
        theAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theAddressActionPerformed(evt);
            }
        });
        getContentPane().add(theAddress);
        theAddress.setBounds(100, 130, 259, 25);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Client Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 110, 86, 13);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Client ID");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 70, 83, 20);

        clientReturnDate.setEditable(false);
        clientReturnDate.setColumns(20);
        clientReturnDate.setRows(5);
        jScrollPane6.setViewportView(clientReturnDate);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(1016, 300, 240, 120);

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton3.setForeground(new java.awt.Color(240, 240, 240));
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(110, 380, 240, 21);
        getContentPane().add(employeeBar);
        employeeBar.setBounds(20, 410, 340, 40);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(240, 240, 240));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Update");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(1020, 30, 240, 30);
        getContentPane().add(jPanel3);
        jPanel3.setBounds(1020, 30, 230, 30);
        getContentPane().add(clientBar);
        clientBar.setBounds(20, 20, 340, 40);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dbList14, pickTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${name}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vehicle}"));
        columnBinding.setColumnName("Vehicle");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        pickTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pickTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(pickTable);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(1020, 110, 240, 150);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(1010, 20, 260, 410);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 10, 360, 710);
        getContentPane().add(clientTableBar);
        clientTableBar.setBounds(380, 10, 610, 430);
        getContentPane().add(employeeTableBar);
        employeeTableBar.setBounds(380, 450, 610, 270);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, vehicles_1List1, vehicleTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vehicleName}"));
        columnBinding.setColumnName("Vehicle Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${plateNumber}"));
        columnBinding.setColumnName("Plate Number");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vehicleType}"));
        columnBinding.setColumnName("Vehicle Type");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(vehicleTable);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(1020, 490, 230, 180);

        jB.setBackground(new java.awt.Color(51, 51, 51));
        jB.setForeground(new java.awt.Color(240, 240, 240));
        jB.setText("Vehicles");
        jB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActionPerformed(evt);
            }
        });
        getContentPane().add(jB);
        jB.setBounds(1020, 680, 230, 23);

        jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Vehicles");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(1020, 460, 230, 20);
        getContentPane().add(jPanel5);
        jPanel5.setBounds(1020, 460, 230, 20);
        getContentPane().add(jPanel4);
        jPanel4.setBounds(1010, 450, 250, 260);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        selectedRow = jTable1.getSelectedRow();
        
        //        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        theID.setText(jTable1.getModel().getValueAt(selectedRow, 0).toString());
        theName.setText(jTable1.getModel().getValueAt(selectedRow, 1).toString());
        thePhoneNumber.setText(jTable1.getModel().getValueAt(selectedRow, 2).toString());
        rentDuration.setValue(jTable1.getModel().getValueAt(selectedRow, 3));
        theAddress.setText(jTable1.getModel().getValueAt(selectedRow, 5).toString());
        Calendar aDate = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, Integer.valueOf(jTable1.getModel().getValueAt(selectedRow, 3).toString()));
        String output = dateFormat.format(c.getTime());    
        

        
        
        
    
        
//        dateChooserCombo1.setText(jTable1.getModel().getValueAt(selectedRow, 7).toString());
//        dateChooserCombo1.setCurrent((Calendar) jTable1.getModel().getValueAt(selectedRow, 7));
        dateChooserCombo1.setCurrent(aDate);
//        dateChooserCombo1.set
//        Integer.valueOf(jTable1.getModel().getValueAt(selectedRow, 4).toString())
//        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("MITSUBISHI ADVENTURE 2.5 GLX")){
//            theVehicle.setSelectedIndex(0);}
//        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("MITSUBISHI MIRAGE GLX 1.6")){
//            theVehicle.setSelectedIndex(1);}
//        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA INNOVA 2.5 E")){
//            theVehicle.setSelectedIndex(2);}
//        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA HI-ACE COMMUTER 2.8")){
//            theVehicle.setSelectedIndex(3);}
//        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA HI-ACE GRANDIA 3.0")){
//            theVehicle.setSelectedIndex(4);}
//        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA HI-ACE SUPER GRANDIA 3.0")){
//            theVehicle.setSelectedIndex(5);}
//        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA VIOS 1.3 E")){
//            theVehicle.setSelectedIndex(6);}
//        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("TOYOTA AVANZA 1.5 J")){
//            theVehicle.setSelectedIndex(7);}        
//        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("HYUNDAI ACCENT 1.6")){
//            theVehicle.setSelectedIndex(8);}
//        if((jTable1.getModel().getValueAt(selectedRow, 4).toString()).equals("HYUNDAI STAREX 2.4")){
//            theVehicle.setSelectedIndex(9);}

            theVehicle.setSelectedItem(jTable1.getModel().getValueAt(selectedRow, 4).toString());
        
         if((jTable1.getModel().getValueAt(selectedRow, 6).toString()).equals("ON USE")){
             status.setSelectedIndex(0);}
        if((jTable1.getModel().getValueAt(selectedRow, 6).toString()).equals("SCHEDULED")){
            status.setSelectedIndex(1);}
        if((jTable1.getModel().getValueAt(selectedRow, 6).toString()).equals("ONHOLD")){
            status.setSelectedIndex(2);}
        if((jTable1.getModel().getValueAt(selectedRow, 6).toString()).equals("NOT RETURNED")){
            status.setSelectedIndex(3);}
        if((jTable1.getModel().getValueAt(selectedRow, 6).toString()).equals("RETURNED")){
            status.setSelectedIndex(4);}

               clientReturnDate.setText("Name : \t" + jTable1.getModel().getValueAt(selectedRow, 1).toString() + "\n"
                                        +"Vehicle: \t" + theVehicle.getSelectedItem().toString() + "\n"
                                        +"Return Date: \t" + output);  
        
//        receipt.setText("ID Number : \t\t" + jTable1.getModel().getValueAt(selectedRow, 0).toString() + "\n" + "Name: \t\t" + jTable1.getModel().getValueAt(selectedRow, 1).toString()
//            + "\nAddress: \t\t" + jTable1.getModel().getValueAt(selectedRow, 2).toString()
//            + "\nPhone Number: \t " + jTable1.getModel().getValueAt(selectedRow, 3).toString()+ "\n"
//            + "Rent Duration: \t " +jTable1.getModel().getValueAt(selectedRow, 4).toString() + " days");

    }//GEN-LAST:event_jTable1MouseClicked

    private void theVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theVehicleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_theVehicleActionPerformed

    private void thePhoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thePhoneNumberKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            evt.consume();

        }
    }//GEN-LAST:event_thePhoneNumberKeyTyped

    private void rentDurationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rentDurationKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            evt.consume();

        }
    }//GEN-LAST:event_rentDurationKeyTyped

    private void theIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_theIDKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            evt.consume();

        }
    }//GEN-LAST:event_theIDKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
              try {           
            rentDuration.setFocusable(false);
                
            String name = theName.getText();
            String address = theAddress.getText();
            String phone = (thePhoneNumber.getText());
            int rent = (int)rentDuration.getValue();
            String vehicle = theVehicle.getSelectedItem().toString();
            String currentStatus = status.getSelectedItem().toString();
            String id = theID.getText();
            String date = dateChooserCombo1.getText();
            if(theName.getText().equals("") || theAddress.getText().equals("") || thePhoneNumber.getText().equals("")){
           
            
            showMessage("Incomplete Information.","Error","E");
            
            }
            
            
            else
            // TODO add your handling code here:

            
            prepared = (PreparedStatement) conn.prepareStatement("UPDATE USERNAME.DB SET ID = ?, NAME = ?, PHONE = ?, RENT = ?, VEHICLE = ?, ADDRESS = ?, STATUS = ?, DATE = ? WHERE ID = ?");
            prepared.setInt(1, Integer.valueOf(id));
            prepared.setString(2, name);
            prepared.setLong(3, Long.parseLong(phone));
            prepared.setInt(4, rent);
            prepared.setString(5, vehicle);
            prepared.setString(6, address);
            prepared.setString(7, currentStatus);
            prepared.setString(8, date);
            prepared.setString(9, jTable1.getModel().getValueAt(selectedRow, 0).toString());
            
            showMessage("CLIENT [" + name.toUpperCase() + "] SUCCESSFULLY CHANGED","Successful","S");
            prepared.executeUpdate();
            statement.close();
            conn.close();
            update_Table();
            update_Return_Table();
     
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(theName.getText().equalsIgnoreCase("")){
        
        showMessage("Can't Perform Deletion" ,"Deletion Error","E");
        }
        else{
            try {
                prepared = (PreparedStatement) conn.prepareStatement("DELETE FROM USERNAME.DB WHERE NAME = ?");
                prepared.setString(1, theName.getText());
                
                showMessage("Client [ " + theName.getText() + " ] Deleted","Successful Delete","S");
                prepared.executeUpdate();
                statement.close();
                conn.close();
                update_Table();
                update_Return_Table();
                        theID.setText("");
                        theName.setText("");
                        theAddress.setText("");
                        thePhoneNumber.setText("");
                        rentDuration.setValue(0);
                        theVehicle.setSelectedIndex(0);
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        update_Table();
        search.setText("");
        theID.setText("");
        theName.setText("");
        theAddress.setText("");
        thePhoneNumber.setText("");
        rentDuration.setValue(1);
         theVehicle.setSelectedIndex(0);
         clientReturnDate.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        HomePage m = new HomePage();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
//        
//        String s = search.getText();
//        if(search.getText().equals("")){
//        JOptionPane.showMessageDialog(null, "No Input");
//        }
//        else{
//            try {
//                prepared = (PreparedStatement) conn.prepareStatement("SELECT * FROM USERNAME.DB WHERE NAME LIKE '%?%'");
//                prepared.setString(0, s);
//              prepared.setString(1, s);
//                prepared.setString(2, s);
//                prepared.executeUpdate();
//                statement.close();
//                conn.close();
//                update_Table();
//              
//            } catch (SQLException ex) {
//                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(null, "No Information Found");
//            }
//
//        }
//        
//        
        search_Table();
        
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterActionPerformed

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        // TODO add your handling code here:
       
        
    if(filter.getSelectedIndex() == 2 ){
        
                char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            evt.consume();

        }
        
   }
    }//GEN-LAST:event_searchKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(theUsername.getText().equals("") || thePassword.getText().equals("")){
        
        JOptionPane.showMessageDialog(null, "Please Fill Necessary Information/s");
        
        }
        else
         try {
             
//             prepared = (PreparedStatement) conn.prepareStatement("SELECT USERNAME FROM USERNAME.MANAGEMENT WHERE USERNAME = ?");
//             prepared.setString(1, id.getText());
//             ResultSet resultSet = prepared.executeQuery();
//             if(rs.next()){}
//             else{}
             prepared = (PreparedStatement) conn.prepareStatement("INSERT INTO USERNAME.MANAGEMENT (USERNAME, PASSWORD, POSITION) VALUES (?,?,?)");
             prepared.setString(1, theUsername.getText());
             prepared.setString(2, thePassword.getText());
             prepared.setString(3, thePosition.getSelectedItem().toString());
             prepared.executeUpdate();
             statement.close();
             conn.close();
//             JOptionPane.showMessageDialog(null, thePosition.getSelectedItem().toString() + " Added");
             showMessage(thePosition.getSelectedItem().toString() + " [ " + theUsername.getText() +" ] Added", "Successfully Added", "S");
                     
             
             
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane jop = new JOptionPane(thePosition.getSelectedItem().toString() + " " + "[ " + ((id.equals("")) ? theUsername.getText() : id.getText()) +" ]" + " already exist", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = jop.createDialog("Duplication Error");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
//            JOptionPane.showMessageDialog(null, thePosition.getSelectedItem().toString() + " " + "[ " +id.getText() +" ]" + " already exist");
        }
        
        update_Table_MANAGEMENT();
        theUsername.setText("");
        thePassword.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
         int row = jTable2.getSelectedRow();
          id.setText(jTable2.getModel().getValueAt(row, 0).toString()); 
          theUsername.setText(jTable2.getModel().getValueAt(row, 0).toString());
          thePassword.setText(jTable2.getModel().getValueAt(row, 1).toString());



         if((jTable2.getModel().getValueAt(row, 2 ).toString()).equals("Employee")){
             thePosition.setSelectedIndex(0);
            
    }       else if((jTable2.getModel().getValueAt(row, 2).toString()).equals("Admin")){
             thePosition.setSelectedIndex(1);
    }
         
         
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
             if(theUsername.getText().equals("") || thePassword.getText().equals("")){
        
        
        showMessage("Can't Delete" ,"Deletion Error" ,"E");
        
        }
             else{
                 try {
                     prepared = (PreparedStatement) conn.prepareStatement("DELETE FROM USERNAME.MANAGEMENT WHERE USERNAME = ?");
                     prepared.setString(1, theUsername.getText());
                     prepared.executeUpdate();
                     statement.close();
                     conn.close();
                     JOptionPane.showMessageDialog(null, "Deleted");
                    
                 } catch (SQLException ex) {
                     Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                 }
             
               update_Table_MANAGEMENT();
              theUsername.setText("");
               thePassword.setText("");
                     
             
             }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        id.setText("");
        theUsername.setText("");
        thePassword.setText("");
        update_Table_MANAGEMENT();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        
                
                
        if(theUsername.getText().equals("") || thePassword.getText().equals("")){
        
        JOptionPane.showMessageDialog(null, "Incomplete Information/s");
        
        }
        else
        {
            try {
//                if(thePosition.getSelectedIndex() == 0){
//                pos = "Employee";
//                }
//                else if(thePosition.getSelectedIndex() == 1){
//                pos = "Admin";
//                }
                
                
                
                
                
                prepared = (PreparedStatement) conn.prepareStatement("UPDATE USERNAME.MANAGEMENT SET USERNAME = ?, PASSWORD = ?, POSITION = ?  WHERE USERNAME = ?");
                prepared.setString(1, theUsername.getText());
                prepared.setString(2, thePassword.getText());
                prepared.setString(3, String.valueOf(thePosition.getSelectedItem()));
                prepared.setString(4, id.getText());
                prepared.executeUpdate();
                statement.close();
                conn.close();
                update_Table_MANAGEMENT();
                showMessage("[" + id.getText() + "] has been updated.", "Update","S");
                
                id.setText("");
                theUsername.setText("");
                thePassword.setText("");
                thePosition.setSelectedIndex(0);
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        
        
        
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void filter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filter1ActionPerformed

    private void search1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_search1KeyTyped

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        search_Table_Management();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void theAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_theAddressActionPerformed

    private void pickTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pickTableMouseClicked
        // TODO add your handling code here:
//        rentDuration.setValue(jTable1.getModel().getValueAt(selectedRow, 3));
//      
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.DATE, Integer.valueOf(jTable1.getModel().getValueAt(selectedRow, 3).toString()));
//        String output = dateFormat.format(c.getTime());
//        
//        
//                       clientReturnDate.setText("Name : \t" + jTable1.getModel().getValueAt(selectedRow, 0).toString() + "\n"
//                                        +"Vehicle: \t" + theVehicle.getSelectedItem().toString() + "\n"
//                                        +"Return Date: \t" + output); 
        
    }//GEN-LAST:event_pickTableMouseClicked

    private void jBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActionPerformed
            try {
                // TODO add your handling code here:
                Vehicles v = new Vehicles();
                v.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jBActionPerformed

    private void theNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_theNameKeyTyped
        // TODO add your handling code here:
                char c = evt.getKeyChar();
        
        if(!Character.isAlphabetic(c) || (c==com.sun.glass.events.KeyEvent.VK_BACKSPACE) || c==com.sun.glass.events.KeyEvent.VK_DELETE){
//            username.setForeground(Color.RED);
            evt.consume();
        }
    }//GEN-LAST:event_theNameKeyTyped

    private void theUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_theUsernameKeyTyped
        // TODO add your handling code here:
          char c = evt.getKeyChar();
        
        if(!Character.isAlphabetic(c) && !Character.isDigit(c)|| (c==com.sun.glass.events.KeyEvent.VK_BACKSPACE) || c==com.sun.glass.events.KeyEvent.VK_DELETE){
//            username.setForeground(Color.RED);
            evt.consume();
           
        }
    }//GEN-LAST:event_theUsernameKeyTyped

    
    
    
    
    private JDialog showMessage(String s, String title, String type){
    
            JOptionPane jop = new JOptionPane(s, (type.equals("S")) ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
            JDialog dialog = jop.createDialog(title);
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            return dialog;
    }
    
     private void update_Table(){
    try{

    String sql = "Select * from USERNAME.DB ORDER BY ID ASC";
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
     
     
     
      private void update_Return_Table(){
    try{
        Date date = new Date();
    String sql = "Select NAME, VEHICLE FROM USERNAME.DB WHERE DATE = '"+dateFormat.format(date)+"' AND STATUS != 'RETURNED' ORDER BY DATE DESC ";
    conn = DriverManager.getConnection("jdbc:derby://localhost:1527/RentingSystemDB", "username", "password");
    prepared = conn.prepareStatement(sql);
    rs = prepared.executeQuery();
    pickTable.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);}
    finally{try{rs.close();prepared.close();}catch (Exception e){}}try{prepared.close();}catch(Exception e){}}
     
     
       private void update_Table_MANAGEMENT(){
    try{

    String sql = "Select * from USERNAME.MANAGEMENT ORDER BY USERNAME ASC";
    conn = DriverManager.getConnection("jdbc:derby://localhost:1527/RentingSystemDB", "username", "password");
    prepared = conn.prepareStatement(sql);
    rs = prepared.executeQuery();
    jTable2.setModel(DbUtils.resultSetToTableModel(rs));
    
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
     
     
     
    private void search_Table(){
     int theFilter = filter.getSelectedIndex();
     String sql = null;
    try{
        

        
    if(theFilter == 0){
     sql = "SELECT * FROM USERNAME.DB WHERE "
            + "UPPER(NAME) LIKE UPPER('%"+ search.getText()+ "%')";}
    
    else if(theFilter == 1){
     sql = "SELECT * FROM USERNAME.DB WHERE "
            + "UPPER(ADDRESS) LIKE UPPER('%"+ search.getText()+ "%')";} 
    
    else if(theFilter == 2){
     sql = "SELECT * FROM USERNAME.DB WHERE "
            + "PHONE LIKE '%"+ search.getText()+ "%'";} 
    

   
   
   else if(theFilter == 3){
     sql = "SELECT * FROM USERNAME.DB WHERE "
            + "UPPER(VEHICLE) LIKE UPPER('%"+ search.getText()+ "%')";} 
    
   else if(theFilter == 4){
     sql = "SELECT * FROM USERNAME.DB WHERE "
            + "UPPER(STATUS) LIKE UPPER('%"+ search.getText()+ "%')";} 
    
   
    
                
//    ID LIKE '%"+ search.getText()+ "%'  OR PHONE LIKE '%"+ search.getText()+ "%' OR RENT LIKE '%"+ search.getText()+ "%' OR VEHICLE LIKE '%"+ search.getText()+ "%' OR ADDRESSLIKE '%"+ search.getText()+ "%'
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
    
    
    
    
    
    
    
    
    
      private void search_Table_Management(){
     int theFilter = filter1.getSelectedIndex();
     String sql = null;
    try{
        

        
    if(theFilter == 0){
     sql = "SELECT * FROM USERNAME.MANAGEMENT WHERE "
            + "UPPER(USERNAME) LIKE UPPER('%"+ search1.getText()+ "%')";}
    
 
    
    else if(theFilter == 1){
        sql = "SELECT * FROM USERNAME.MANAGEMENT WHERE "
            + "UPPER(POSITION) LIKE UPPER('%"+ search1.getText()+ "%')";} 
    


   
    
                
//    ID LIKE '%"+ search.getText()+ "%'  OR PHONE LIKE '%"+ search.getText()+ "%' OR RENT LIKE '%"+ search.getText()+ "%' OR VEHICLE LIKE '%"+ search.getText()+ "%' OR ADDRESSLIKE '%"+ search.getText()+ "%'
    conn = DriverManager.getConnection("jdbc:derby://localhost:1527/RentingSystemDB", "username", "password");
    prepared = conn.prepareStatement(sql);
    rs = prepared.executeQuery();
    jTable2.setModel(DbUtils.resultSetToTableModel(rs));
    
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Admin().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager IT301_System_PUEntityManager;
    private javax.swing.JPanel clientBar;
    private javax.swing.JTextArea clientReturnDate;
    private javax.swing.JPanel clientTableBar;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private java.util.List<system.Db> dbList;
    private java.util.List<system.Db> dbList1;
    private java.util.List<system.Db> dbList10;
    private java.util.List<system.Db> dbList11;
    private java.util.List<system.Db> dbList12;
    private java.util.List<system.Db> dbList13;
    private java.util.List<system.Db> dbList14;
    private java.util.List<system.Db> dbList15;
    private java.util.List<system.Db> dbList16;
    private java.util.List<system.Db> dbList2;
    private java.util.List<system.Db> dbList3;
    private java.util.List<system.Db> dbList4;
    private java.util.List<system.Db> dbList5;
    private java.util.List<system.Db> dbList6;
    private java.util.List<system.Db> dbList7;
    private java.util.List<system.Db> dbList8;
    private java.util.List<system.Db> dbList9;
    private javax.persistence.Query dbQuery;
    private javax.persistence.Query dbQuery1;
    private javax.persistence.Query dbQuery10;
    private javax.persistence.Query dbQuery11;
    private javax.persistence.Query dbQuery12;
    private javax.persistence.Query dbQuery13;
    private javax.persistence.Query dbQuery14;
    private javax.persistence.Query dbQuery15;
    private javax.persistence.Query dbQuery16;
    private javax.persistence.Query dbQuery2;
    private javax.persistence.Query dbQuery3;
    private javax.persistence.Query dbQuery4;
    private javax.persistence.Query dbQuery5;
    private javax.persistence.Query dbQuery6;
    private javax.persistence.Query dbQuery7;
    private javax.persistence.Query dbQuery8;
    private javax.persistence.Query dbQuery9;
    private javax.swing.JPanel employeeBar;
    private javax.swing.JPanel employeeTableBar;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JComboBox<String> filter1;
    private javax.swing.JTextField id;
    private javax.swing.JButton jB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private java.util.List<system.Management> managementList;
    private java.util.List<system.Management> managementList1;
    private java.util.List<system.Management> managementList2;
    private javax.persistence.Query managementQuery;
    private javax.persistence.Query managementQuery1;
    private javax.persistence.Query managementQuery2;
    private javax.swing.JTable pickTable;
    private javax.swing.JSpinner rentDuration;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search1;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTextField theAddress;
    private javax.swing.JTextField theID;
    private javax.swing.JTextField theName;
    private javax.swing.JTextField thePassword;
    private javax.swing.JTextField thePhoneNumber;
    private javax.swing.JComboBox<String> thePosition;
    private javax.swing.JTextField theUsername;
    private javax.swing.JComboBox<String> theVehicle;
    private javax.swing.JTable vehicleTable;
    private java.util.List<system.Vehicles_1> vehicles_1List;
    private java.util.List<system.Vehicles_1> vehicles_1List1;
    private javax.persistence.Query vehicles_1Query;
    private javax.persistence.Query vehicles_1Query1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
