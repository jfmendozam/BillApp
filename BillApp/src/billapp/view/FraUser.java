package billapp.view;

import billapp.logic.User;
import billapp.persistence.DB;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Show Employee frame
 * @author jf
 */
public class FraUser extends javax.swing.JFrame {
    private DB dataFile;
    private String lastPassword;
    private long[] employeeIndexes;

    /**
     * Creates new form FraEmployee
     */
    public FraUser() {
        initComponents();

//        this.dataFile = new DB();
//        this.dataFile.connectMSAccess("/home/jf/NetBeansProjects/BillApp/src/billapp/persistence/BillDB.accdb");
//        this.loadEmployeeCombo();
//        this.selectUser();
    }

    /**
     * Creates new form FraEmployee
     * @param dataFile Database file
     */
    public FraUser(DB dataFile) {
        initComponents();
        this.setLocationRelativeTo(null);

        this.dataFile = dataFile;
        this.loadEmployeeCombo();
        this.selectUser();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panData = new javax.swing.JPanel();
        labUsername = new javax.swing.JLabel();
        labPassword = new javax.swing.JLabel();
        labEmail = new javax.swing.JLabel();
        labFirstLogin = new javax.swing.JLabel();
        labLastLogin = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        labId = new javax.swing.JLabel();
        pasPassword = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        comUserLevel = new javax.swing.JComboBox();
        labUserLevel = new javax.swing.JLabel();
        butNew = new javax.swing.JButton();
        butUpdate = new javax.swing.JButton();
        butDelete = new javax.swing.JButton();
        butReport = new javax.swing.JButton();
        comEmployee = new javax.swing.JComboBox();
        panButtons = new javax.swing.JPanel();
        butFirst = new javax.swing.JButton();
        butPrevious = new javax.swing.JButton();
        butNext = new javax.swing.JButton();
        butLast = new javax.swing.JButton();
        butSearch = new javax.swing.JButton();

        setTitle("Users");

        panData.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labUsername.setText("Username");

        labPassword.setText("Password");

        labEmail.setText("Email");

        labFirstLogin.setText("First Login: Never");

        labLastLogin.setText("Last Login: Never");

        labId.setText("Employee");

        comUserLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Employee" }));

        labUserLevel.setText("User level");

        butNew.setText("New");
        butNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNewActionPerformed(evt);
            }
        });

        butUpdate.setText("Update");
        butUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUpdateActionPerformed(evt);
            }
        });

        butDelete.setText("Delete");
        butDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDeleteActionPerformed(evt);
            }
        });

        butReport.setText("Report");
        butReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butReportActionPerformed(evt);
            }
        });

        comEmployee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panDataLayout = new javax.swing.GroupLayout(panData);
        panData.setLayout(panDataLayout);
        panDataLayout.setHorizontalGroup(
            panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDataLayout.createSequentialGroup()
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panDataLayout.createSequentialGroup()
                                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labUserLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail)
                                    .addComponent(comUserLevel, 0, 253, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panDataLayout.createSequentialGroup()
                                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panDataLayout.createSequentialGroup()
                                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(7, 7, 7)
                                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panDataLayout.createSequentialGroup()
                                        .addComponent(labPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pasPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25)))
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(butDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(butNew, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(panDataLayout.createSequentialGroup()
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labFirstLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                            .addComponent(labLastLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panDataLayout.setVerticalGroup(
            panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDataLayout.createSequentialGroup()
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pasPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labUserLevel)
                            .addComponent(comUserLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labFirstLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labLastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panDataLayout.createSequentialGroup()
                        .addComponent(butNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butDelete)
                        .addGap(40, 40, 40)
                        .addComponent(butReport)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panButtons.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        butFirst.setText("|<");
        butFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFirstActionPerformed(evt);
            }
        });

        butPrevious.setText("<");
        butPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPreviousActionPerformed(evt);
            }
        });

        butNext.setText(">");
        butNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNextActionPerformed(evt);
            }
        });

        butLast.setText(">|");
        butLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLastActionPerformed(evt);
            }
        });

        butSearch.setText("Search...");
        butSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panButtonsLayout = new javax.swing.GroupLayout(panButtons);
        panButtons.setLayout(panButtonsLayout);
        panButtonsLayout.setHorizontalGroup(
            panButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panButtonsLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(butFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butPrevious)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butLast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panButtonsLayout.setVerticalGroup(
            panButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butFirst)
                    .addComponent(butPrevious)
                    .addComponent(butNext)
                    .addComponent(butLast)
                    .addComponent(butSearch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Show first record
     * @param evt Event
     */
    private void butFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFirstActionPerformed
        try {
            this.getDataFile().getResultSet().first();
            this.updateView();
        } catch (SQLException ex) {
            Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butFirstActionPerformed

    /**
     * Show previous record
     * @param evt Event
     */
    private void butPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPreviousActionPerformed
        try {
            if (!this.getDataFile().getResultSet().isFirst()) {
                this.getDataFile().getResultSet().previous();
                this.updateView();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butPreviousActionPerformed

    /**
     * Show next record
     * @param evt Event
     */
    private void butNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNextActionPerformed
        try {
            if (!this.getDataFile().getResultSet().isLast()) {
                this.getDataFile().getResultSet().next();
                this.updateView();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butNextActionPerformed

    /**
     * Show last record
     * @param evt Event
     */
    private void butLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLastActionPerformed
        try {
            this.getDataFile().getResultSet().last();
            this.updateView();
        } catch (SQLException ex) {
            Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butLastActionPerformed

    /**
     * Search an employee
     * @param evt Event
     */
    private void butSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSearchActionPerformed
        String username = JOptionPane.showInputDialog(
                "Please, type the username", "Username");
        if (!username.equals("")) {
            this.searchUser(username);
        }
    }//GEN-LAST:event_butSearchActionPerformed

    /**
     * 
     * @param evt 
     */
    private void butReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butReportActionPerformed
        String[] fields = {"Employee Id", "Username", "Email", "User Level", "First Login", "Last Login"};
        String[] dbFields = {"IdEmployee", "username", "email", "userLevel", "firstLogin", "lastLogin"};

        PDFReport report = new PDFReport(
            "userReport.pdf",
            "JF",
            "BillApp",
            "Users Report",
            "Store XYZ",
            fields,
            dbFields,
            this.getDataFile().getResultSet());
        report.generatePDF();

        try {
            File path = new File("userReport.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butReportActionPerformed

    /**
     * Delete employee record
     * @param evt Event
     */
    private void butDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(this,
            "Are you sure to delete this record?", "Delete record",
            JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {

        this.deleteUser();
        JOptionPane.showMessageDialog(this, "Deleted record!", "Delete record",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_butDeleteActionPerformed

    /**
     * Update employee record
     * @param evt Event
     */
    private void butUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUpdateActionPerformed
        this.updateUser();
        JOptionPane.showMessageDialog(this, "Updated record!", "Update record",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_butUpdateActionPerformed

    /**
     * New or save employee record
     * @param evt Event
     */
    private void butNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNewActionPerformed
        if (butNew.getText().equals("New")) {
            this.newView();
        }
        else { 
            if (butNew.getText().equals("Save")) {
                if (this.validateView()) {
                    this.insertUser();

                    butNew.setText("New");
                    butFirst.setEnabled(true);
                    butPrevious.setEnabled(true);
                    butNext.setEnabled(true);
                    butLast.setEnabled(true);
                    butSearch.setEnabled(true);
                    butUpdate.setEnabled(true);
                    butDelete.setEnabled(true);
                    butReport.setEnabled(true);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Please, fill the requeried fields",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_butNewActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FraUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FraUser().setVisible(true);
        });
    }

    /**
     * Get data file
     * @return data file
     */
    public DB getDataFile() {
        return this.dataFile;
    }

    /**
     * Set data file
     * @param dataFile data file
     */
    public void setDataFile(DB dataFile) {
        this.dataFile = dataFile;
    }

    /**
     * Get Last password
     * @return Last password
     */
    public String getLastPassword() {
        return this.lastPassword;
    }

    /**
     * Set Last password
     * @param lastPassword Last password
     */
    public void setLastPassword(String lastPassword) {
        this.lastPassword = lastPassword;
    }

    /**
     * Get Employee indexes
     * @return Employee indexes
     */
    public long[] getEmployeeIndexes() {
        return this.employeeIndexes;
    }

    /**
     * Get Employee indexes
     * @param index Array index
     * @return Employee identification
     */
    public long getEmployeeIndexes(int index) {
        return this.employeeIndexes[index];
    }

    /**
     * Set Employee indexes
     * @param employeeIndexes Employee indexes
     */
    public void setEmployeeIndexes(long[] employeeIndexes) {
        this.employeeIndexes = employeeIndexes;
    }

    /**
     * Set Employee indexes
     * @param index Array index
     * @param value Array value
     */
    public void setEmployeeIndexes(int index, long value) {
        this.employeeIndexes[index] = value;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butDelete;
    private javax.swing.JButton butFirst;
    private javax.swing.JButton butLast;
    private javax.swing.JButton butNew;
    private javax.swing.JButton butNext;
    private javax.swing.JButton butPrevious;
    private javax.swing.JButton butReport;
    private javax.swing.JButton butSearch;
    private javax.swing.JButton butUpdate;
    private javax.swing.JComboBox comEmployee;
    private javax.swing.JComboBox comUserLevel;
    private javax.swing.JLabel labEmail;
    private javax.swing.JLabel labFirstLogin;
    private javax.swing.JLabel labId;
    private javax.swing.JLabel labLastLogin;
    private javax.swing.JLabel labPassword;
    private javax.swing.JLabel labUserLevel;
    private javax.swing.JLabel labUsername;
    private javax.swing.JPanel panButtons;
    private javax.swing.JPanel panData;
    private javax.swing.JPasswordField pasPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    /**
     * Validate the view for save
     * @return True is ok
     */
    private boolean validateView() {
        boolean validate = !(txtUsername.getText().equals("") 
                || (pasPassword.getPassword() == null)
                || txtEmail.getText().equals("")
                || !txtEmail.getText().contains("@")
                || !txtEmail.getText().contains("."));
        return validate;
    }

    /**
     * Obtain the view data and tranfer it to the object
     */
    private User view2Object() {
        User user = new User();

        user.setIdEmployee(this.getEmployeeIndexes(comEmployee.getSelectedIndex()));
        user.setUsername(txtUsername.getText());
        user.setPassword(new String(pasPassword.getPassword()));
        user.setEmail(txtEmail.getText());
        user.setUserLevel(comUserLevel.getSelectedIndex());
        
        return user;
    }

    /**
     * You obtain data from an object and pass it to the view
     */
    private void updateView() {
        if ((this.getDataFile().getResultSet() == null)
                || (this.selectCountUser() <= 0)) {
            this.newView();
        }
        else {
            this.object2View();
        }
    }

    /**
     * You prepare the view to enter a new employee data
     */
    private void newView() {
        txtUsername.setText("");
        pasPassword.setText("");
        txtEmail.setText("");
        labFirstLogin.setText("First Login: ");
        labLastLogin.setText("Last Login: ");
        this.setLastPassword("");
                
        butNew.setText("Save");
        butFirst.setEnabled(false);
        butPrevious.setEnabled(false);
        butNext.setEnabled(false);
        butLast.setEnabled(false);
        butSearch.setEnabled(false);
        butUpdate.setEnabled(false);
        butDelete.setEnabled(false);
        butReport.setEnabled(false);
    }

    /**
     * Result set -> object
     */
    private void object2View() {
        User user = new User();
        try {
            user.setIdEmployee(this.getDataFile().getResultSet().getLong("idEmployee"));
            user.setUsername(this.getDataFile().getResultSet().getString("username"));
            user.setPassword(this.getDataFile().getResultSet().getString("password"));
            user.setEmail(this.getDataFile().getResultSet().getString("email"));
            user.setUserLevel(this.getDataFile().getResultSet().getInt("userLevel"));
            user.setFirstLogin(this.getDataFile().getResultSet().getDate("firstLogin"));
            user.setLastLogin(this.getDataFile().getResultSet().getDate("lastLogin"));

            this.object2View(user);
        } catch (SQLException ex) {
            Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Show the object data into view
     * @param employee Employee to show
     */
    private void object2View(User user) {
        comEmployee.setSelectedIndex(this.searchEmployeeIndex(user.getIdEmployee()));
        txtUsername.setText(user.getUsername());
        pasPassword.setText(user.getPassword());
        this.setLastPassword(user.getPassword());
        txtEmail.setText(user.getEmail());
        comUserLevel.setSelectedIndex(user.getUserLevel());
        labFirstLogin.setText("First Login: " 
                + ((user.getFirstLogin() == null) ? "Never" : "" + user.getFirstLogin()));
        labLastLogin.setText("Last Login: " 
                + ((user.getFirstLogin() == null) ? "Never" : "" + user.getLastLogin()));
    }

    /**
     * Select employees from DB
     */
    private void selectUser() {
        String query = "SELECT * FROM User";
        if (this.getDataFile().execute(query)) {
            try {
                this.getDataFile().getResultSet().next();
                this.updateView();
            } catch (SQLException ex) {
                Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Select number of records in the user table
     * @return Number of records in the user table
     */
    private int selectCountUser() {
        int count = 0;
        ResultSet lastResultSet = this.getDataFile().getResultSet();
        String query = "SELECT count(*) FROM User";
        if (this.getDataFile().execute(query)) {
            try {
                this.getDataFile().getResultSet().next();
                count = this.getDataFile().getResultSet().getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.getDataFile().setResultSet(lastResultSet);
        return count;
    }

    /**
     * Insert new user
     */
    private void insertUser() {
        User user = this.view2Object();
        String query = "INSERT INTO User "
                + "(idEmployee, username, password, email, userLevel) "
                + "VALUES ("
                + user.getIdEmployee() + ", '"
                + user.getUsername() + "', '"
                + user.getPassword() + "', '"
                + user.getEmail() + "', "
                + user.getUserLevel() + ")";
        if (this.getDataFile().execute(query)) {
            this.selectUser();
            this.searchUser(user.getUsername());
        }
    }

    /**
     * Update user
     */
    private void updateUser() {
        User user = this.view2Object();
        String query;

        if (this.getLastPassword().equals(new String(pasPassword.getPassword()))) {
            query = "UPDATE User SET "
                + "idEmployee = " + user.getIdEmployee() + ", "
                + "email = '" + user.getEmail() + "', "
                + "userLevel = " + user.getUserLevel() + " "
                + "WHERE username = '" + user.getUsername() + "'";
        }
        else {
            query = "UPDATE User SET "
                + "idEmployee = " + user.getIdEmployee() + ", "
                + "password = '" + user.getPassword() + "', "
                + "email = '" + user.getEmail() + "', "
                + "userLevel = " + user.getUserLevel() + " "
                + "WHERE username = '" + user.getUsername() + "'";
        }

        if (this.getDataFile().execute(query)) {
            this.selectUser();
            this.searchUser(user.getUsername());
        }
    }

    /**
     * Delete user
     */
    private void deleteUser() {
        User user = this.view2Object();
        String query = "DELETE * FROM User WHERE idEmployee = " 
                + user.getIdEmployee();
        if (this.getDataFile().execute(query)) {
            this.selectUser();
        }        
    }

    /**
     * Search user by username
     * @param username Username
     */
    private void searchUser(String username) {
        boolean find = false;
        try {
            if (this.getDataFile().getResultSet() != null) {
                String lastUsername = 
                        this.getDataFile().getResultSet().getString("username");
                this.getDataFile().getResultSet().beforeFirst();
                while (this.getDataFile().getResultSet().next()) {
                    if (this.getDataFile().getResultSet().getString("username")
                            .equals(username)) {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    this.updateView();
                }
                else {
                    this.getDataFile().getResultSet().first();
                    this.searchUser(lastUsername);
                    JOptionPane.showMessageDialog(this, 
                            "The user " + username + " was not found!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Load the employee combo
     */
    private void loadEmployeeCombo() {
        comEmployee.removeAllItems();
        this.setEmployeeIndexes(new long[this.selectCountEmployee()]);

        String query = "SELECT id, firstname, lastname FROM Employee ORDER BY firstname";
        if (this.getDataFile().execute(query)) {
            try {
                int index = 0;
                while (this.getDataFile().getResultSet().next()) {
                    this.setEmployeeIndexes(index++, this.getDataFile().getResultSet().getLong("id"));
                    comEmployee.addItem(
                            this.getDataFile().getResultSet().getString("firstname")
                            + " "
                            + this.getDataFile().getResultSet().getString("lastname"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }

    /**
     * Search employee identification into indexes array 
     * @param idEmployee Employee identification to search
     * @return Array index
     */
    private int searchEmployeeIndex(Long idEmployee) {
        int index = 0;
        for (int i = 0; i < this.getEmployeeIndexes().length; i++) {
            if (idEmployee == this.getEmployeeIndexes(i)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Select number of records in the user table
     * @return Number of records in the user table
     */
    private int selectCountEmployee() {
        int count = 0;
        String query = "SELECT count(*) FROM Employee";
        if (this.getDataFile().execute(query)) {
            try {
                this.getDataFile().getResultSet().next();
                count = this.getDataFile().getResultSet().getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return count;
    }
}