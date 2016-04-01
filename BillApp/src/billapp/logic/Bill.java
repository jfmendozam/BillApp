package billapp.logic;

import java.util.Date;

/**
 * Bill class
 * @author jf
 */
public class Bill {
    private long idBill;        /** Bill identification */
    private long idClient;      /** Client identification */
    private long idSeller;      /** Employee identification */
    private Date saleDate;      /** Sale date */
    private float billDiscount; /** Bill discount */
    private float billTax;      /** Bill tax */
    private float billValue;    /** Bill value */

    /**
     * Default constructor
     */
    public Bill() {
        this.idBill = 0;
        this.idClient = 0;
        this.idSeller = 0;
        this.saleDate = new Date();
        this.billDiscount = 0;
        this.billTax = 0;
        this.billValue = 0;
    }

    /**
     * Constructor with parameters
     * @param idBill Bill identification
     * @param idClient Client identification
     * @param idSeller Employee identification
     * @param saleDate Sale date
     * @param billDiscount Bill discount
     * @param billTax Bill tax
     * @param billValue Bill value
     */
    public Bill(long idBill, long idClient, long idSeller, Date saleDate, float billDiscount, float billTax, float billValue) {
        this.idBill = idBill;
        this.idClient = idClient;
        this.idSeller = idSeller;
        this.saleDate = saleDate;
        this.billDiscount = billDiscount;
        this.billTax = billTax;
        this.billValue = billValue;
    }

    /**
     * Get Bill identification
     * @return Bill identification
     */
    public long getIdBill() {
        return this.idBill;
    }

    /**
     * Set Bill identification
     * @param idBill Bill identification
     */
    public void setIdBill(long idBill) {
        this.idBill = idBill;
    }

    /**
     * Get Client identification
     * @return Client identification
     */
    public long getIdClient() {
        return this.idClient;
    }

    /**
     * Set Client identification
     * @param idClient Client identification
     */
    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    /**
     * Get Employee identification
     * @return Employee identification
     */
    public long getIdSeller() {
        return this.idSeller;
    }

    /**
     * Set Employee identification
     * @param idSeller Employee identification
     */
    public void setIdSeller(long idSeller) {
        this.idSeller = idSeller;
    }

    /**
     * Get Sale date
     * @return Sale date
     */
    public Date getSaleDate() {
        return this.saleDate;
    }

    /**
     * Set Sale date
     * @param saleDate Sale date
     */
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    /**
     * Get Bill discount
     * @return Bill discount
     */
    public float getBillDiscount() {
        return this.billDiscount;
    }

    /**
     * Set Bill discount
     * @param billDiscount Bill discount
     */
    public void setBillDiscount(float billDiscount) {
        this.billDiscount = billDiscount;
    }

    /**
     * Get Bill tax
     * @return Bill tax
     */
    public float getBillTax() {
        return this.billTax;
    }

    /**
     * Set Bill tax
     * @param billTax Bill tax
     */
    public void setBillTax(float billTax) {
        this.billTax = billTax;
    }

    /**
     * Get Bill value
     * @return Bill value
     */
    public float getBillValue() {
        return this.billValue;
    }

    /**
     * Set Bill value
     * @param billValue Bill value
     */
    public void setBillValue(float billValue) {
        this.billValue = billValue;
    }
}
