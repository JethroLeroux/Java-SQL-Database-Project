/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JethroLeroux;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jethro
 */
public class MainScreen extends javax.swing.JFrame {
private boolean isAdmin =false;     //admin is set to false as default. Will only become true if user is an admin, this value is passed in the parameterised constructor.
   
CustomerDBM custManager = new CustomerDBM();    //create a manager class for each table so the tables can be loaded in by pressing their respective buttons
CarDBM carManager = new CarDBM();
EmployeeDBM empManager = new EmployeeDBM();
PaymentDBM payManager = new PaymentDBM();
RepairDBM repManager = new RepairDBM();

String searchTable ="Customers"; //table which will be searched when the search button is pressed. Customers is loaded by default

boolean updatingTable = false;  //if the table is updating or not. The table can not be altered while it is updating or an error will be caused


    /**
     * Creates new form MainScreen
     */
    public MainScreen(boolean iAdmin) {         //formal parameter shows if the user who logged in is an admin or not
        initComponents();   //initiialize the JFrames components
        javax.swing.ImageIcon pic = new javax.swing.ImageIcon("background.jpg"); //load in the background image
        javax.swing.ImageIcon scaledPic = new javax.swing.ImageIcon(pic.getImage().getScaledInstance(500, 330, 0));//resize the image to the JFrames dimensions
        lblBackground.setIcon(scaledPic);//set the labels icon to the resized image
        isAdmin = iAdmin; //says if the user is an admin or not - for the AdminTools JFrame
        
        updateTableCustomers();         //Table Customers is loaded by default
        
        this.DisplayTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if(updatingTable) return;
                int changedRow = e.getFirstRow();   //finds the first row in the table and extracts this data
                CustomerObject s = new CustomerObject(0,  //creates an object to be used to insert into the table
                        DisplayTable.getValueAt(changedRow, 1).toString(),
                        DisplayTable.getValueAt(changedRow, 2).toString(),
                        DisplayTable.getValueAt(changedRow, 3).toString());
                custManager.updateCustomer(s);//updates the database through the DBM class using the object made
                updateTableCustomers();//updates the table with the Customers
            }
            
        });
    }
    
    public void updateTableCustomers()
    {
        updatingTable = true;
        
        while(((DefaultTableModel)DisplayTable.getModel()).getRowCount()>0)//Clear the JTable
        {
            ((DefaultTableModel)DisplayTable.getModel()).removeRow(0);//removes each row
        }
        
        CustomerObject[] customers = custManager.getCustomers();//Get objects of the declared object  class(in this case CustomerObject) from the manager class
        //Add them to the JTable
        for(int i = 0;customers[i] != null;i++)//loop through the array and insert the customers
        {
            this.addCustomerToTable(customers[i]);
        }
        updatingTable = false;//table has been updated and is no longer BEING updated
    }//these comments apply to all the "updateTable...()" methods
    
    public void updateTableCustomersSearch(String iSearchFor)    //for searching the table
    {
        updatingTable = true;
        
        while(((DefaultTableModel)DisplayTable.getModel()).getRowCount()>0)//Clear the JTable
        {
            ((DefaultTableModel)DisplayTable.getModel()).removeRow(0);//removes each row
        }
        
        CustomerObject[] foundCustomers = custManager.searchCustomers(iSearchFor);//Get objects of the declared object  class(in this case CustomerObject) from the manager class
        //Add them to the JTable
        for(int i = 0;foundCustomers[i] != null;i++)//loop through the array and insert the customers
        {
            this.addCustomerToTable(foundCustomers[i]);
        }
        updatingTable = false;//table has been updated and is no longer BEING updated
    }//these comments apply to all the "updateTable...()" methods
    
    public void updateTableCars()
    {
        updatingTable = true;
        
        while(((DefaultTableModel)DisplayTable.getModel()).getRowCount()>0)
        {
            ((DefaultTableModel)DisplayTable.getModel()).removeRow(0);
        }
        
        CarObject[] cars = carManager.getCars();
        
        for(int i = 0;cars[i] != null;i++)
        {
            this.addCarToTable(cars[i]);
        }
        updatingTable = false;
    }
    
    public void updateTableCarsSearch(String iSearchFor)
    {
        updatingTable = true;
        
        while(((DefaultTableModel)DisplayTable.getModel()).getRowCount()>0)
        {
            ((DefaultTableModel)DisplayTable.getModel()).removeRow(0);
        }
        
        CarObject[] cars = carManager.searchCars(iSearchFor);
        
        for(int i = 0;cars[i] != null;i++)
        {
            this.addCarToTable(cars[i]);
        }
        updatingTable = false;
    }
    
    public void updateTableEmployees()
    {
        updatingTable = true;
        //Clear the JTable
        while(((DefaultTableModel)DisplayTable.getModel()).getRowCount()>0)
        {
            ((DefaultTableModel)DisplayTable.getModel()).removeRow(0);
        }
        
        EmployeeObject[] employees = empManager.getEmployees();
        
        for(int i = 0;employees[i] != null;i++)
        {
            this.addEmployeeToTable(employees[i]);
        }
        updatingTable = false;
    }
    
    
    public void updateTableEmployeesSearch(String iSearchFor)    //for searching the table
    {
        updatingTable = true;
        
        while(((DefaultTableModel)DisplayTable.getModel()).getRowCount()>0)//Clear the JTable
        {
            ((DefaultTableModel)DisplayTable.getModel()).removeRow(0);//removes each row
        }
        
        EmployeeObject[] foundEmployees = empManager.searchEmployees(iSearchFor);//Get objects of the declared object  class(in this case CustomerObject) from the manager class
        //Add them to the JTable
        for(int i = 0;foundEmployees[i] != null;i++)//loop through the array and insert the customers
        {
            this.addEmployeeToTable(foundEmployees[i]);
        }
        updatingTable = false;//table has been updated and is no longer BEING updated
    }//these comments apply to all the "updateTable...()" methods
    
    public void updateTablePayments()
    {
        updatingTable = true;
        //Clear the JTable
        while(((DefaultTableModel)DisplayTable.getModel()).getRowCount()>0)
        {
            ((DefaultTableModel)DisplayTable.getModel()).removeRow(0);
        }
        
        PaymentObject[] payments = payManager.getPayments();
        
        for(int i = 0;payments[i] != null;i++)
        {
            this.addPaymentToTable(payments[i]);
        }
        updatingTable = false;
    }
    
    public void updateTablePaymentsSearch(String iSearchFor)    //for searching the table
    {
        updatingTable = true;
        
        while(((DefaultTableModel)DisplayTable.getModel()).getRowCount()>0)//Clear the JTable
        {
            ((DefaultTableModel)DisplayTable.getModel()).removeRow(0);//removes each row
        }
        
        PaymentObject[] foundPayments = payManager.searchPayments(iSearchFor);//Get objects of the declared object  class(in this case CustomerObject) from the manager class
        //Add them to the JTable
        for(int i = 0;foundPayments[i] != null;i++)//loop through the array and insert the customers
        {
            this.addPaymentToTable(foundPayments[i]);
        }
        updatingTable = false;//table has been updated and is no longer BEING updated
    }//these comments apply to all the "updateTable...()" methods
    
    public void updateTableRepairs()
    {
        updatingTable = true;
        
        while(((DefaultTableModel)DisplayTable.getModel()).getRowCount()>0)
        {
            ((DefaultTableModel)DisplayTable.getModel()).removeRow(0);
        }
        
        RepairObject[] repairs = repManager.getRepairs();
        
        for(int i = 0;repairs[i] != null;i++)
        {
            this.addRepairToTable(repairs[i]);
        }
        updatingTable = false;
    }
    
    
    public void updateTableRepairsSearch(String iSearchFor)    //for searching the table
    {
        updatingTable = true;
        
        while(((DefaultTableModel)DisplayTable.getModel()).getRowCount()>0)//Clear the JTable
        {
            ((DefaultTableModel)DisplayTable.getModel()).removeRow(0);//removes each row
        }
        
        RepairObject[] foundRepairs = repManager.searchRepairs(iSearchFor);//Get objects of the declared object  class(in this case CustomerObject) from the manager class
        //Add them to the JTable
        for(int i = 0;foundRepairs[i] != null;i++)//loop through the array and insert the customers
        {
            this.addRepairToTable(foundRepairs[i]);
        }
        updatingTable = false;//table has been updated and is no longer BEING updated
    }//these comments apply to all the "updateTable...()" methods
    
    public void addCustomerToTable(CustomerObject cust)//receives a customer object to be inserted
    {
        Object[] data = {cust.getCustomerID(), cust.getCustomerName(),cust.getCellNum(), cust.getEmail()};//makes a simple object with the received objects values
        ((DefaultTableModel)DisplayTable.getModel()).addRow(data);//inputs the created objects values into the table
    }//these comments apply to all "add....ToTable()" methods
    
    public void addCarToTable(CarObject car)
    {
        Object[] data = {car.getCarID(), car.getRegistration(),car.getModel(), car.getColour(), car.getCustomerID()};
        ((DefaultTableModel)DisplayTable.getModel()).addRow(data);
    }
    
    public void addEmployeeToTable(EmployeeObject emp)
    {
        Object[] data = {emp.getEmployeeID(), emp.getEmployeeName(),emp.getTradeUnion(), emp.getQualification()};
        ((DefaultTableModel)DisplayTable.getModel()).addRow(data);
    }
    
    public void addPaymentToTable(PaymentObject pay)
    {
        Object[] data = {pay.getPayID(), pay.getRepairID(),pay.getFee(), pay.isPaid()};
        ((DefaultTableModel)DisplayTable.getModel()).addRow(data);
    }
    
     public void addRepairToTable(RepairObject rep)
    {
        Object[] data = {rep.getRepairID(), rep.getCarID(),rep.getEmployeeID(), rep.getDateArrived(), rep.getProblem(), rep.isFixed()};
        ((DefaultTableModel)DisplayTable.getModel()).addRow(data);
    }
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayTable = new javax.swing.JTable();
        lblExplain1 = new javax.swing.JLabel();
        lblExpain2 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        mnbBar = new javax.swing.JMenuBar();
        mnuTables = new javax.swing.JMenu();
        itemCars = new javax.swing.JMenuItem();
        itemCustomers = new javax.swing.JMenuItem();
        itemEmployees = new javax.swing.JMenuItem();
        itemPayments = new javax.swing.JMenuItem();
        itemRepairs = new javax.swing.JMenuItem();
        mnuAdmin = new javax.swing.JMenu();
        mnuHelp = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsert.setFont(new java.awt.Font("Aharoni", 0, 18)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        btnDelete.setFont(new java.awt.Font("Aharoni", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        btnEdit.setFont(new java.awt.Font("Aharoni", 0, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        txfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfSearchActionPerformed(evt);
            }
        });
        txfSearch.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txfSearchPropertyChange(evt);
            }
        });
        getContentPane().add(txfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 30));

        btnSearch.setFont(new java.awt.Font("Aharoni", 0, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        DisplayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CustomerID", "CustomerName", "CellNum", "Email"
            }
        ));
        jScrollPane1.setViewportView(DisplayTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 480, 200));

        lblExplain1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblExplain1.setForeground(new java.awt.Color(255, 255, 255));
        lblExplain1.setText("Searches for Boolean in Table Payments ONLY");
        getContentPane().add(lblExplain1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 400, 30));

        lblExpain2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblExpain2.setForeground(new java.awt.Color(255, 255, 255));
        lblExpain2.setText("Searches through all text columns (Not ID/Number columns)");
        getContentPane().add(lblExpain2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 400, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JethroLeroux/background.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 500, 330));

        mnuTables.setText("Tables");

        itemCars.setText("Cars");
        itemCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCarsActionPerformed(evt);
            }
        });
        mnuTables.add(itemCars);

        itemCustomers.setText("Customers");
        itemCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCustomersActionPerformed(evt);
            }
        });
        mnuTables.add(itemCustomers);

        itemEmployees.setText("Employees");
        itemEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEmployeesActionPerformed(evt);
            }
        });
        mnuTables.add(itemEmployees);

        itemPayments.setText("Payments");
        itemPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPaymentsActionPerformed(evt);
            }
        });
        mnuTables.add(itemPayments);

        itemRepairs.setText("Repairs");
        itemRepairs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRepairsActionPerformed(evt);
            }
        });
        mnuTables.add(itemRepairs);

        mnbBar.add(mnuTables);

        mnuAdmin.setText("Admin Tools");
        mnuAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuAdminMouseClicked(evt);
            }
        });
        mnbBar.add(mnuAdmin);

        mnuHelp.setText("Help");
        mnuHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuHelpMouseClicked(evt);
            }
        });
        mnuHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHelpActionPerformed(evt);
            }
        });
        mnbBar.add(mnuHelp);

        setJMenuBar(mnbBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPaymentsActionPerformed
        //when button Payments is pressed under the Table drop down menu
        
        searchTable ="Payments";    //table Payments will now be searched if the search button is clicked
        
         DisplayTable.setModel(new javax.swing.table.DefaultTableModel( //sets the table to the correct headings
    new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
    },
    new String [] {
        "PaymentID", "RepairID", "Fee(Rands)", "Paid"   //column headings
    }
));
  
        updateTablePayments();         //Table Payments is updated
        this.DisplayTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if(updatingTable) return;//do not continue if the table is being updated
                int changedRow = e.getFirstRow();//finds the first row in the table and extracts this data
                PaymentObject s = new PaymentObject(//creates an object to be used to insert into the table
                        Integer.parseInt(DisplayTable.getValueAt(changedRow, 1).toString()),
                        Integer.parseInt(DisplayTable.getValueAt(changedRow, 2).toString()),
                        Integer.parseInt(DisplayTable.getValueAt(changedRow, 3).toString()),
                        Boolean.parseBoolean(DisplayTable.getValueAt(changedRow, 4).toString())
                );
                payManager.updatePayment(s);//updates the database through the DBM class using the object made
                updateTablePayments(); //Table Payments is updated
            }//these comments apply to all "tableChanged()" methods
            
        });//these comments apply to all "item....ActionPerformed()" methods which is when each button is pressed which corresponds to a table
    }//GEN-LAST:event_itemPaymentsActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
            MainInsertScreen is = new MainInsertScreen(isAdmin);
            is.setVisible(true);
    }//GEN-LAST:event_btnInsertActionPerformed

    private void txfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       String searchFor = txfSearch.getText();
       
       switch(searchTable)  //checks which table is selected to be searched
       {
           
           case "Cars"://if Cars table is selected
           {
               updateTableCarsSearch(searchFor);         //Table Cars is updated
               break;
           }
           case "Customers"://if Customers table is selected
           {
               updateTableCustomersSearch(searchFor);         //Table Customers is updated
               break;
           }
           case "Employees"://if Employees table is selected
           {
               updateTableEmployeesSearch(searchFor);         //Table Employees is updated
               break;
           }
           case "Payments"://if Payments table is selected
           {
               updateTablePaymentsSearch(searchFor);         //Table Payments is updated
               break;
           }
           case "Repairs"://if Repairs table is selected
           {
                updateTableRepairsSearch(searchFor);         //Table Repairs is updated
               break;
           }
           default:
               JOptionPane.showMessageDialog(null, "Unknown table");//error handling
               
               
           
       }
       
    }//GEN-LAST:event_btnSearchActionPerformed

    private void mnuHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHelpActionPerformed

    }//GEN-LAST:event_mnuHelpActionPerformed

    private void mnuHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuHelpMouseClicked
        HelpScreen hs = new HelpScreen();
        hs.setVisible(true);
    }//GEN-LAST:event_mnuHelpMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void mnuAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuAdminMouseClicked
        if(isAdmin == true)
        {
            AdminTools at = new AdminTools();
            at.setVisible(true);
        }else
        {
            AdminToolsError ate = new AdminToolsError();
            ate.setVisible(true);
        }
    }//GEN-LAST:event_mnuAdminMouseClicked

    private void itemCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCustomersActionPerformed
       //when button Customers is pressed under the Table drop down menu
        searchTable ="Customers";    //table Customers will now be searched if the search button is clicked
         DisplayTable.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
    },
    new String [] {
        "CustomerID", "CustomerName", "CellNum", "Email"
    }
));
  
        updateTableCustomers();         //Table Customers is updated
        this.DisplayTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if(updatingTable) return;
                int changedRow = e.getFirstRow();
                CustomerObject s = new CustomerObject(//creates an object to be used to insert into the table
                        Integer.parseInt(DisplayTable.getValueAt(changedRow, 1).toString()),
                        DisplayTable.getValueAt(changedRow, 2).toString(),
                        DisplayTable.getValueAt(changedRow, 3).toString(),
                        DisplayTable.getValueAt(changedRow, 4).toString()
                        );
                custManager.updateCustomer(s);//updates the database through the DBM class using the object made
                updateTableCars();
            }
            
        });
        
    }//GEN-LAST:event_itemCustomersActionPerformed

    private void itemCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCarsActionPerformed
        //when button Cars is pressed under the Table drop down menu
        searchTable ="Cars";    //table Cars will now be searched if the search button is clicked
         DisplayTable.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
    },
    new String [] {
        "CarID", "Registration", "Model", "Colour","CustomerID"
    }
));
  
        updateTableCars();         //Table Cars is updated
        this.DisplayTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if(updatingTable) return;
                int changedRow = e.getFirstRow();
                CarObject s = new CarObject(//creates an object to be used to insert into the table
                        0,
                        DisplayTable.getValueAt(changedRow, 1).toString(),
                        DisplayTable.getValueAt(changedRow, 2).toString(),
                        DisplayTable.getValueAt(changedRow, 3).toString(),
                        Integer.parseInt(DisplayTable.getValueAt(changedRow, 4).toString()));
                carManager.updateCar(s);
                updateTableCars();
            }
            
        });
    }//GEN-LAST:event_itemCarsActionPerformed

    private void itemEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEmployeesActionPerformed
        //when button Employees is pressed under the Table drop down menu
        searchTable ="Employees";    //table Employees will now be searched if the search button is clicked
         DisplayTable.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
    },
    new String [] {
        "EmployeeID", "EmployeeName", "TradeUnion", "Qualification"
    }
));
  
        updateTableEmployees();         //Table Employees is updated
        this.DisplayTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if(updatingTable) return;
                int changedRow = e.getFirstRow();
                EmployeeObject s = new EmployeeObject(//creates an object to be used to insert into the table
                        Integer.parseInt(DisplayTable.getValueAt(changedRow, 1).toString()),
                        DisplayTable.getValueAt(changedRow, 2).toString(),
                        DisplayTable.getValueAt(changedRow, 3).toString(),
                        DisplayTable.getValueAt(changedRow, 4).toString()
                        );
                empManager.updateEmployee(s);
                updateTableEmployees();
            }
            
        });
    }//GEN-LAST:event_itemEmployeesActionPerformed

    private void itemRepairsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRepairsActionPerformed
        //when button Repairs is pressed under the Table drop down menu
        searchTable ="Repairs";    //table Repairs will now be searched if the search button is clicked
         DisplayTable.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
    },
    new String [] {
        "RepairID", "CarID", "EmployeeID", "DateArrived","Problem","Fixed"
    }
));
  
        updateTableRepairs();         //Table Repairs is updated
        this.DisplayTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if(updatingTable) return;
                int changedRow = e.getFirstRow();
                RepairObject s = new RepairObject(//creates an object to be used to insert into the table
                        Integer.parseInt(DisplayTable.getValueAt(changedRow, 1).toString()),
                        Integer.parseInt(DisplayTable.getValueAt(changedRow, 2).toString()),
                        Integer.parseInt(DisplayTable.getValueAt(changedRow, 3).toString()),
                        DisplayTable.getValueAt(changedRow, 4).toString().substring(0,10),  //substring removes the time and only includes the date values
                        DisplayTable.getValueAt(changedRow, 5).toString(),
                        Boolean.parseBoolean(DisplayTable.getValueAt(changedRow, 6).toString())
                        );
                repManager.updateRepair(s);
                updateTableRepairs();
            }
            
        });
    }//GEN-LAST:event_itemRepairsActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DeleteScreen ds = new DeleteScreen(isAdmin);//loads the delete JFrame
        ds.setVisible(true);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        EditScreen es = new EditScreen(isAdmin); //load the Edit JFrame
        es.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void txfSearchPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txfSearchPropertyChange
        
    }//GEN-LAST:event_txfSearchPropertyChange

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainScreen a = new MainScreen(false);//user is not an admin as default
                a.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DisplayTable;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearch;
    private javax.swing.JMenuItem itemCars;
    private javax.swing.JMenuItem itemCustomers;
    private javax.swing.JMenuItem itemEmployees;
    private javax.swing.JMenuItem itemPayments;
    private javax.swing.JMenuItem itemRepairs;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblExpain2;
    private javax.swing.JLabel lblExplain1;
    private javax.swing.JMenuBar mnbBar;
    private javax.swing.JMenu mnuAdmin;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuTables;
    private javax.swing.JTextField txfSearch;
    // End of variables declaration//GEN-END:variables
}
