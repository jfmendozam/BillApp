package billapp.logic;

import java.util.Date;

/**
 * Product stock class
 * @author jf
 */
public class ProductStock {
    private long idProduct;         /** Product identification */
    private Date stockDate;         /** Date on which the product enters stock */
    private float purchasePrice;    /** Price of product purchase */
    private float salePrice;        /** Price of product sale */
    private float taxPercentage;    /** Percentage of product tax */
    private int quantity;           /** Quantity of purchased product */

    /**
     * Default constructor
     */
    public ProductStock() {
    }

    /**
     * Constructor with parameters
     * @param idProduct Product identification
     * @param stockDate Date on which the product enters stock
     * @param purchasePrice Price of product purchase
     * @param salePrice Price of product sale
     * @param taxPercentage Percentage of product tax
     * @param quantity Quantity of purchased product
     */
    public ProductStock(long idProduct, Date stockDate, float purchasePrice, float salePrice, float taxPercentage, int quantity) {
        this.idProduct = idProduct;
        this.stockDate = stockDate;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.taxPercentage = taxPercentage;
        this.quantity = quantity;
    }

    /**
     * Get Product identification
     * @return Product identification
     */
    public long getIdProduct() {
        return this.idProduct;
    }

    /**
     * Set Product identification
     * @param idProduct Product identification
     */
    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Get Stock date
     * @return Stock date
     */
    public Date getStockDate() {
        return this.stockDate;
    }

    /**
     * Set Stock date
     * @param stockDate Stock date
     */
    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
    }

    /**
     * Get Purchase price
     * @return Purchase price
     */
    public float getPurchasePrice() {
        return this.purchasePrice;
    }

    /**
     * Set Purchase price
     * @param purchasePrice Purchase price
     */
    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * Get Sale price
     * @return Sale price
     */
    public float getSalePrice() {
        return this.salePrice;
    }

    /**
     * Set Sale price
     * @param salePrice Sale price
     */
    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * Get Tax percentage
     * @return Tax percentage
     */
    public float getTaxPercentage() {
        return taxPercentage;
    }

    /**
     * Set Tax percentage
     * @param taxPercentage Tax percentage
     */
    public void setTaxPercentage(float taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    /**
     * Get Quantity
     * @return Quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set Quantity
     * @param quantity Quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
