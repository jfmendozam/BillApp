package billapp.logic;

import java.util.Date;

/**
 * Client class
 * @author jf
 */
public class Client {
    private int idClient;       /** Client identification */
    private String firstname;   /** Client firstname */
    private String lastname;    /** Client lastname */
    private int gender;         /** Client gender: 0 - Female, 1 - Male */
    private Date bornDate;      /** Client born date */
    private long phoneNumber;   /** Client phone number */
    private String address;     /** Client home address */
    private String email;       /** Client email */

    /**
     * Default constructor
     */
    public Client() {
    }

    /**
     * Constructor with parameters
     * @param idClient Client identification
     * @param firstname Client firstname
     * @param lastname Client lastname
     * @param gender Client gender: 0 - Female, 1 - Male
     * @param bornDate Client born date
     * @param phoneNumber Client phone number
     * @param address Client home address
     * @param email Client email
     */
    public Client(int idClient, String firstname, String lastname, int gender, Date bornDate, long phoneNumber, String address, String email) {
        this.idClient = idClient;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.bornDate = bornDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    /**
     * Get Client identification
     * @return Client identification
     */
    public int getIdClient() {
        return this.idClient;
    }

    /**
     * Set Client identification
     * @param idClient Client identification
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Get Client firstname
     * @return Client firstname
     */
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * Set Client firstname
     * @param firstname Client firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Get Client lastname
     * @return Client lastname
     */
    public String getLastname() {
        return this.lastname;
    }

    /**
     * Set Client lastname
     * @param lastname Client lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Get Client gender: 0 - Female, 1 - Male
     * @return Client gender: 0 - Female, 1 - Male
     */
    public int getGender() {
        return this.gender;
    }

    /**
     * Set Client gender: 0 - Female, 1 - Male
     * @param gender Client gender: 0 - Female, 1 - Male
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * Get Client born date
     * @return Client born date
     */
    public Date getBornDate() {
        return this.bornDate;
    }

    /**
     * Set Client born date
     * @param bornDate Client born date
     */
    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    /**
     * Get Client phone number
     * @return Client phone number
     */
    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Set Client phone number
     * @param phoneNumber Client phone number
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get Client home address
     * @return Client home address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Set Client home address
     * @param address Client home address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get Client email
     * @return Client email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Get Client email
     * @param email Client email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
