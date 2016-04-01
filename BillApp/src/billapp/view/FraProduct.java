package billapp.view;

import billapp.logic.Product;
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
 *
 * @author jf
 */
public class FraProduct extends javax.swing.JFrame {
    private DB dataFile;        /** Database file */

    /**
     * Creates new form FraProduct
     */
    public FraProduct() {
        initComponents();
    }

    /**
     * Creates new form FraProduct
     * @param dataFile Database file
     */
    public FraProduct(DB dataFile) {
        initComponents();
        this.setLocationRelativeTo(null);

        this.dataFile = dataFile;
        this.selectProduct();
    }

    /**
     * Get Database file
     * @return Database file
     */
    public DB getDataFile() {
        return this.dataFile;
    }

    /**
     * Set Database file
     * @param dataFile Database file
     */
    public void setDataFile(DB dataFile) {
        this.dataFile = dataFile;
    }

    /**
     * Select products from DB
     */
    public void selectProduct() {
        String query = "SELECT * FROM Product";
        if (this.getDataFile().execute(query)) {
            try {
                this.getDataFile().getResultSet().next();
                this.updateView();
            } catch (SQLException ex) {
                Logger.getLogger(FraProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * You obtain data from an object and pass it to the view
     */
    private void updateView() {
        if ((this.getDataFile().getResultSet() == null)
                || (this.selectProductCount() <= 0)) {
            this.newView();
        }
        else {
            this.object2View();
        }
    }

    /**
     * Select number of records in the product table
     * @return Number of records in the product table
     */
    private int selectProductCount() {
        int count = 0;
        ResultSet lastResultSet = this.getDataFile().getResultSet();
        String query = "SELECT count(*) FROM Product";
        if (this.getDataFile().execute(query)) {
            try {
                this.getDataFile().getResultSet().next();
                count = this.getDataFile().getResultSet().getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(FraProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.getDataFile().setResultSet(lastResultSet);
        return count;
    }

    /**
     * You prepare the view to enter a new product data
     */
    public void newView() {
        txtIdProduct.setText("");
        txtProductName.setText("");
        labAvailable.setText("Available quantity: 0");
                
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
     * Validate the view for save
     * @return True is ok
     */
    public boolean validateView() {
        return !(txtIdProduct.getText().equals("") 
                || txtProductName.getText().equals(""));
    }

    /**
     * Result set -> object
     */
    private void object2View() {
        Product product = new Product();
        try {
            product.setIdProduct(this.getDataFile().getResultSet().getString("idProduct"));
            product.setProductName(this.getDataFile().getResultSet().getString("productName"));
            product.setQuantity(this.getDataFile().getResultSet().getInt("quantity"));
            
            this.object2View(product);
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(FraProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Show the object data into view
     * @param product Product to show
     */
    private void object2View(Product product) {
        txtIdProduct.setText(product.getIdProduct());
        txtProductName.setText(product.getProductName());
        labAvailable.setText("Available quantity: " + product.getQuantity());
    }

    /**
     * Obtain the view data and tranfer it to the object
     */
    private Product view2Object() {
        Product product = new Product();

        product.setIdProduct(txtIdProduct.getText());
        product.setProductName(txtProductName.getText());
        
        return product;
    }

    /**
     * Search product by idProduct
     * @param idProduct Product identification
     */
    private void searchProduct(String idProduct) {
        boolean find = false;
        try {
            if (this.getDataFile().getResultSet() != null) {
                String lastIdProduct = this.getDataFile().getResultSet()
                        .getString("idProduct");
                this.getDataFile().getResultSet().beforeFirst();
                while (this.getDataFile().getResultSet().next()) {
                    if (this.getDataFile().getResultSet().getString("idProduct")
                            .equals(idProduct)) {
                        find = true;
                        break;
                    }
                }
                if (find) {
                    this.updateView();
                }
                else {
                    this.getDataFile().getResultSet().first();
                    this.searchProduct(lastIdProduct);
                    JOptionPane.showMessageDialog(this, "Product " + idProduct 
                            + " was not found!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FraProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Insert new product
     */
    private void insertProduct() {
        Product product = this.view2Object();

        String query = "INSERT INTO Product "
                + "(idProduct, productName, quantity) "
                + "VALUES ('"
                + product.getIdProduct() + "', '"
                + product.getProductName() + "', "
                + "0)";
        if (this.getDataFile().execute(query)) {
            this.selectProduct();
            this.searchProduct(product.getIdProduct());
        }
    }

    /**
     * Update product
     */
    private void updateProduct() {
        Product product = this.view2Object();

        String query = "UPDATE Product SET "
                + "productName = '" + product.getProductName() + "' "
                + "WHERE idProduct = " + product.getIdProduct();
        if (this.getDataFile().execute(query)) {
            this.selectProduct();
            this.searchProduct(product.getIdProduct());
        }
    }

    /**
     * Delete product
     */
    private void deleteProduct() {
        Product product = this.view2Object();
        String query = "DELETE * FROM Product WHERE idProduct = " + product.getIdProduct();
        if (this.getDataFile().execute(query)) {
            this.selectProduct();
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panProduct = new javax.swing.JPanel();
        labIdProduct = new javax.swing.JLabel();
        txtIdProduct = new javax.swing.JTextField();
        labProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        labAvailable = new javax.swing.JLabel();
        panButtons = new javax.swing.JPanel();
        butNew = new javax.swing.JButton();
        butFirst = new javax.swing.JButton();
        butPrevious = new javax.swing.JButton();
        butNext = new javax.swing.JButton();
        butLast = new javax.swing.JButton();
        butSearch = new javax.swing.JButton();
        butUpdate = new javax.swing.JButton();
        butDelete = new javax.swing.JButton();
        butReport = new javax.swing.JButton();

        setTitle("Product Manager");
        setName("fraProduct"); // NOI18N

        panProduct.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labIdProduct.setText("Product id");

        labProductName.setText("Product name");

        labAvailable.setText("Available quantity: ");

        javax.swing.GroupLayout panProductLayout = new javax.swing.GroupLayout(panProduct);
        panProduct.setLayout(panProductLayout);
        panProductLayout.setHorizontalGroup(
            panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panProductLayout.createSequentialGroup()
                        .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labProductName)
                            .addComponent(labIdProduct))
                        .addGap(18, 18, 18)
                        .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panProductLayout.createSequentialGroup()
                                .addComponent(txtIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtProductName)))
                    .addGroup(panProductLayout.createSequentialGroup()
                        .addComponent(labAvailable)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panProductLayout.setVerticalGroup(
            panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labIdProduct)
                    .addComponent(txtIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labProductName)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labAvailable, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        panButtons.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        butNew.setText("New");
        butNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNewActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panButtonsLayout = new javax.swing.GroupLayout(panButtons);
        panButtons.setLayout(panButtonsLayout);
        panButtonsLayout.setHorizontalGroup(
            panButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(butFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butPrevious)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butLast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butSearch)
                .addGap(69, 69, 69)
                .addComponent(butNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panButtonsLayout.setVerticalGroup(
            panButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butNew)
                    .addComponent(butFirst)
                    .addComponent(butPrevious)
                    .addComponent(butNext)
                    .addComponent(butLast)
                    .addComponent(butSearch)
                    .addComponent(butUpdate)
                    .addComponent(butDelete)
                    .addComponent(butReport))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(panButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * New product
     * @param evt Event
     */
    private void butNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNewActionPerformed
        if (butNew.getText().equals("New")) {
            this.newView();
        }
        else {
            if (butNew.getText().equals("Save")) {
                if (this.validateView()) {
                    this.insertProduct();

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
     * First record
     * @param evt Event
     */
    private void butFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFirstActionPerformed
        try {
            this.getDataFile().getResultSet().first();
            this.updateView();
        } catch (SQLException ex) {
            Logger.getLogger(FraProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butFirstActionPerformed

    /**
     * Previous record
     * @param evt Event
     */
    private void butPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPreviousActionPerformed
        try {
            if (!this.getDataFile().getResultSet().isFirst()) {
                this.getDataFile().getResultSet().previous();
                this.updateView();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FraProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butPreviousActionPerformed

    /**
     * Next record
     * @param evt Event
     */
    private void butNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNextActionPerformed
        try {
            if (!this.getDataFile().getResultSet().isLast()) {
                this.getDataFile().getResultSet().next();
                this.updateView();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FraProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butNextActionPerformed

    /**
     * Last record
     * @param evt Event
     */
    private void butLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLastActionPerformed
        try {
            this.getDataFile().getResultSet().last();
            this.updateView();
        } catch (SQLException ex) {
            Logger.getLogger(FraProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butLastActionPerformed

    /**
     * Search a product
     * @param evt Event
     */
    private void butSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSearchActionPerformed
        String idProduct = JOptionPane.showInputDialog(
            "Please, write the product id", "Product id");
        if (!idProduct.equals("")) {
            this.searchProduct(idProduct);
        }
    }//GEN-LAST:event_butSearchActionPerformed

    /**
     * Update product
     * @param evt Event
     */
    private void butUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUpdateActionPerformed
        this.updateProduct();
        JOptionPane.showMessageDialog(this, "Updated record!", "Update record",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_butUpdateActionPerformed

    /**
     * Delete product
     * @param evt Event
     */
    private void butDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(this,
            "Are you sure to delete this record?", "Delete record",
            JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {

        this.deleteProduct();
        JOptionPane.showMessageDialog(this, "Deleted record!", "Delete record",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_butDeleteActionPerformed

    /**
     * Product report
     * @param evt Event
     */
    private void butReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butReportActionPerformed
        String[] fields = {"Product Id", "Product Name", "Quantity"};
        String[] dbFields = {"IdProduct", "productName", "quantity"};

        PDFReport report = new PDFReport(
            "productReport.pdf",
            "JF",
            "BillApp",
            "Products Report",
            "Store XYZ",
            fields,
            dbFields,
            this.getDataFile().getResultSet());
        report.generatePDF();

        try {
            File path = new File("productReport.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            Logger.getLogger(FraProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_butReportActionPerformed

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
            java.util.logging.Logger.getLogger(FraProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FraProduct().setVisible(true);
        });
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
    private javax.swing.JLabel labAvailable;
    private javax.swing.JLabel labIdProduct;
    private javax.swing.JLabel labProductName;
    private javax.swing.JPanel panButtons;
    private javax.swing.JPanel panProduct;
    private javax.swing.JTextField txtIdProduct;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables
}
