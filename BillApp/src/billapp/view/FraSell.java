package billapp.view;

import billapp.logic.Bill;
import billapp.persistence.DB;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jf
 */
public class FraSell extends javax.swing.JFrame {
    private DB dataFile;
    private int userLevel;
    private Bill bill;
    private String productIndexes[];
    private int productQuantities[];

    /**
     * Creates new form FraSell
     */
    public FraSell() {
        initComponents();
    }

    /**
     * Sell form
     * @param dataFile Database file
     * @param userLevel Userlevel
     */
    public FraSell(DB dataFile, int userLevel) {
        initComponents();
        this.setLocationRelativeTo(null);

        this.dataFile = dataFile;
        this.userLevel = userLevel;
        this.initView();
    }

    /**
     * Get Data file
     * @return Data file
     */
    public DB getDataFile() {
        return this.dataFile;
    }

    /**
     * Set Data file
     * @param dataFile Data file
     */
    public void setDataFile(DB dataFile) {
        this.dataFile = dataFile;
    }

    /**
     * Get User level
     * @return User level
     */
    public int getUserLevel() {
        return this.userLevel;
    }

    /**
     * Set User level
     * @param userLevel User level
     */
    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * Get Product Indexes
     * @return Array of product indexes
     */
    public String[] getProductIndexes() {
        return this.productIndexes;
    }

    /**
     * Set Product Indexes
     * @param productIndexes Product indexes
     */
    public void setProductIndexes(String[] productIndexes) {
        this.productIndexes = productIndexes;
    }

    /**
     * Set Product Indexes
     * @param index Array index
     * @param value Value to asign
     */
    public void setProductIndexes(int index, String value) {
        this.productIndexes[index] = value;
    }

    /**
     * Get Product quantities
     * @return Product quantities
     */
    public int[] getProductQuantities() {
        return productQuantities;
    }

    /**
     * Set Product quantities
     * @param productQuantities Product quantities
     */
    public void setProductQuantities(int[] productQuantities) {
        this.productQuantities = productQuantities;
    }

    /**
     * Set Product quantities
     * @param index Array index
     * @param quantity Quantity to asign
     */
    public void setProductQuantities(int index, int quantity) {
        this.productQuantities[index] = quantity;
    }
    /**
     * Init View
     */
    private void initView() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        bill = new Bill();
        bill.setIdBill(this.getBillNumber());
        bill.setSaleDate(new Date());

        labIdBill.setText("Bill number: " + bill.getIdBill());
        labTime.setText("Time: " + dateFormat.format(bill.getSaleDate()));
        labTotalDiscount.setText("Discount: " + bill.getBillDiscount());
        labTax.setText("Tax: " + bill.getBillTax());
        labValue.setText("Value: " + bill.getBillValue());
        
        this.loadProductCombo();
    }

    /**
     * Obtain a new bill number
     * @return New bill number
     */
    private long getBillNumber() {
        long number = -1;
        try {
            String query = "SELECT max(idBill) FROM bill";
            if (this.getDataFile().execute(query)) {
                this.getDataFile().getResultSet().next();
                number = (this.getDataFile().getResultSet() != null)
                        ? this.getDataFile().getResultSet().getLong(1) : -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FraSell.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++number;
    }

    /**
     * Load product combo
     */
    private void loadProductCombo() {
        comProduct.removeAllItems();
        int productsCount = this.selectProductCount();
        this.setProductIndexes(new String[productsCount]);
        this.setProductQuantities(new int[productsCount]);

        String query = "SELECT idProduct, productName, quantity FROM Product ORDER BY productName";
        if (this.getDataFile().execute(query)) {
            try {
                int index = 0;
                while (this.getDataFile().getResultSet().next()) {
                    this.setProductIndexes(index, this.getDataFile()
                            .getResultSet().getString("idProduct"));
                    this.setProductQuantities(index++, this.getDataFile()
                            .getResultSet().getInt("quantity"));
                    comProduct.addItem(
                            this.getDataFile().getResultSet().getString("productName"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FraUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Calculate the product count
     * @return Product count
     */
    private int selectProductCount() {
        int count = 0;
        String query = "SELECT count(*) FROM Product";
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panBillHeader = new javax.swing.JPanel();
        labIdBill = new javax.swing.JLabel();
        labTotalDiscount = new javax.swing.JLabel();
        labTax = new javax.swing.JLabel();
        labValue = new javax.swing.JLabel();
        butPrint = new javax.swing.JButton();
        labTime = new javax.swing.JLabel();
        butSave = new javax.swing.JButton();
        panClient = new javax.swing.JPanel();
        labIdClient = new javax.swing.JLabel();
        txtIdClient = new javax.swing.JTextField();
        butClient = new javax.swing.JButton();
        labClientName = new javax.swing.JLabel();
        labEmployeeName = new javax.swing.JLabel();
        panDetail = new javax.swing.JPanel();
        scrDetail = new javax.swing.JScrollPane();
        tabDetail = new javax.swing.JTable();
        butPlus = new javax.swing.JButton();
        butMinus = new javax.swing.JButton();
        comProduct = new javax.swing.JComboBox();
        labQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        labDiscount = new javax.swing.JLabel();
        comDiscount = new javax.swing.JComboBox();

        setTitle("Sell");
        setName("fraSell"); // NOI18N

        panBillHeader.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labIdBill.setText("Bill number:");

        labTotalDiscount.setText("Discount:");

        labTax.setText("Tax:");

        labValue.setText("Value: ");

        butPrint.setText("Print bill...");

        labTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labTime.setText("Time:");

        butSave.setText("Save");

        javax.swing.GroupLayout panBillHeaderLayout = new javax.swing.GroupLayout(panBillHeader);
        panBillHeader.setLayout(panBillHeaderLayout);
        panBillHeaderLayout.setHorizontalGroup(
            panBillHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBillHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBillHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBillHeaderLayout.createSequentialGroup()
                        .addComponent(labTotalDiscount)
                        .addGap(103, 103, 103)
                        .addComponent(labTax))
                    .addComponent(labIdBill, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panBillHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBillHeaderLayout.createSequentialGroup()
                        .addComponent(labValue)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panBillHeaderLayout.createSequentialGroup()
                        .addComponent(labTime, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panBillHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(butPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panBillHeaderLayout.setVerticalGroup(
            panBillHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBillHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBillHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labIdBill)
                    .addComponent(labTime)
                    .addComponent(butSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panBillHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTotalDiscount)
                    .addComponent(labTax)
                    .addComponent(labValue)
                    .addComponent(butPrint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panClient.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labIdClient.setText("Client id:");

        butClient.setText("Clients...");

        labClientName.setText("Client name: ");

        labEmployeeName.setText("Seller: ");

        javax.swing.GroupLayout panClientLayout = new javax.swing.GroupLayout(panClient);
        panClient.setLayout(panClientLayout);
        panClientLayout.setHorizontalGroup(
            panClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labEmployeeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labClientName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panClientLayout.createSequentialGroup()
                        .addComponent(labIdClient)
                        .addGap(29, 29, 29)
                        .addComponent(txtIdClient, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(butClient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panClientLayout.setVerticalGroup(
            panClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(butClient))
                    .addComponent(labIdClient))
                .addGap(18, 18, 18)
                .addComponent(labClientName)
                .addGap(18, 18, 18)
                .addComponent(labEmployeeName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panDetail.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tabDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product", "Price", "Quantity", "Discount", "Tax", "Value"
            }
        ));
        scrDetail.setViewportView(tabDetail);

        butPlus.setText("+");

        butMinus.setText("-");

        comProduct.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labQuantity.setText("Quantity");

        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtQuantity.setText("1");

        labDiscount.setText("Discount");

        comDiscount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Without discount", "Preferred customer", "Product quantity", "Offer" }));

        javax.swing.GroupLayout panDetailLayout = new javax.swing.GroupLayout(panDetail);
        panDetail.setLayout(panDetailLayout);
        panDetailLayout.setHorizontalGroup(
            panDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDetailLayout.createSequentialGroup()
                        .addComponent(comProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labQuantity)
                        .addGap(4, 4, 4)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labDiscount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butPlus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butMinus, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                    .addComponent(scrDetail))
                .addContainerGap())
        );
        panDetailLayout.setVerticalGroup(
            panDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetailLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labDiscount)
                    .addComponent(comDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butPlus)
                    .addComponent(butMinus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panBillHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panBillHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FraSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FraSell().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butClient;
    private javax.swing.JButton butMinus;
    private javax.swing.JButton butPlus;
    private javax.swing.JButton butPrint;
    private javax.swing.JButton butSave;
    private javax.swing.JComboBox comDiscount;
    private javax.swing.JComboBox comProduct;
    private javax.swing.JLabel labClientName;
    private javax.swing.JLabel labDiscount;
    private javax.swing.JLabel labEmployeeName;
    private javax.swing.JLabel labIdBill;
    private javax.swing.JLabel labIdClient;
    private javax.swing.JLabel labQuantity;
    private javax.swing.JLabel labTax;
    private javax.swing.JLabel labTime;
    private javax.swing.JLabel labTotalDiscount;
    private javax.swing.JLabel labValue;
    private javax.swing.JPanel panBillHeader;
    private javax.swing.JPanel panClient;
    private javax.swing.JPanel panDetail;
    private javax.swing.JScrollPane scrDetail;
    private javax.swing.JTable tabDetail;
    private javax.swing.JTextField txtIdClient;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
