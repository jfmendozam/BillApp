package billapp.logic;

/**
 * Product class
 * @author jf
 */
public class Product {
    private String idProduct;       /** Product identification */
    private String productName;     /** Product name */
    private int quantity;           /** Product quantity in stock */

    /**
     * Default constructor
     */
    public Product() {
    }

    /**
     * Constructor with parameters
     * @param idProduct Product identification
     * @param productName Product name
     * @param quantity Product quantity
     */
    public Product(String idProduct, String productName, int quantity) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.quantity = quantity;
    }

    /**
     * Get Product identification
     * @return Product identification
     */
    public String getIdProduct() {
        return this.idProduct;
    }

    /**
     * Set Product identification
     * @param idProduct Product identification
     */
    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Get Product name
     * @return Product name
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * Set Product name
     * @param productName Product name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Get Product quantity
     * @return Product quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Set Product quantity
     * @param quantity Product quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }    
}
