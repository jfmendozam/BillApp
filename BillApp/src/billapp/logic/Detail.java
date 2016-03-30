package billapp.logic;

/**
 * Detail class
 * @author jf
 */
public class Detail {
    private long idBill;        /** Bill identification */
    private String idProduct;   /** Product identification */
    private int productAmount;  /** Product amount */
    private float discount;     /** Discount */

    /**
     * Default constructor
     */
    public Detail() {
    }

    /**
     * Constructor with parameters
     * @param idBill Bill identification
     * @param idProduct Product identification
     * @param productAmount Product amount
     * @param discount Discount
     */
    public Detail(long idBill, String idProduct, int productAmount, float discount) {
        this.idBill = idBill;
        this.idProduct = idProduct;
        this.productAmount = productAmount;
        this.discount = discount;
    }

    /**
     * Get Bill identification
     * @return 
     */
    public long getIdBill() {
        return this.idBill;
    }

    /**
     * Set Bill identification
     * @param idBill 
     */
    public void setIdBill(long idBill) {
        this.idBill = idBill;
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
     * @param idProduct 
     */
    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Get Product amount
     * @return Product amount
     */
    public int getProductAmount() {
        return this.productAmount;
    }

    /**
     * Set Product amount
     * @param productAmount Product amount
     */
    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    /**
     * Set Discount
     * @return Discount
     */
    public float getDiscount() {
        return this.discount;
    }

    /**
     * Get Discount
     * @param discount 
     */
    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
