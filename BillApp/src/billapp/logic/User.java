package billapp.logic;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jf
 */
public class User {
    private Long idEmployee;        /** Employee identification */
    private String username;        /** Username */
    private String password;        /** Password */
    private Integer userLevel;      /** User level (0 Administrator, 1 Employee) */
    private String email;           /** email */
    private Date firstLogin;        /** First login */
    private Date lastLogin;         /** Last login */

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * Constructor with parameters
     * @param idEmployee Employee identification 
     * @param username Username
     * @param password Unencrypted password
     * @param userLevel User level (0 Administrator, 1 Employee)
     * @param email Email
     * @param firstLogin First Login
     * @param lastLogin Last login
     */
    public User(Long idEmployee, String username, String password, Integer userLevel, String email, Date firstLogin, Date lastLogin) {
        this.idEmployee = idEmployee;
        this.username = username;
        this.setPassword(password);
        this.userLevel = userLevel;
        this.email = email;
        this.firstLogin = firstLogin;
        this.lastLogin = lastLogin;
    }

    /**
     * Get Employee identification
     * @return Employee identification
     */
    public Long getIdEmployee() {
        return this.idEmployee;
    }

    /**
     * Set Employee identification
     * @param idEmployee Employee identification
     */
    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    /**
     * Get username
     * @return Username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Set username
     * @param username Username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get password
     * @return Password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Set unencrypted password
     * @param password unencrypted password
     */
    public void setPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes(), 0, password.length());
            this.password = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get User level
     * @return User level
     */
    public Integer getUserLevel() {
        return this.userLevel;
    }

    /**
     * Set User level
     * @param userLevel User level
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * Get email
     * @return Email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Set email
     * @param email Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get First login
     * @return First login
     */
    public Date getFirstLogin() {
        return this.firstLogin;
    }

    /**
     * Set First login
     * @param firstLogin First login
     */
    public void setFirstLogin(Date firstLogin) {
        this.firstLogin = firstLogin;
    }

    /**
     * Get Last login
     * @return Last login
     */
    public Date getLastLogin() {
        return this.lastLogin;
    }

    /**
     * Set Last login
     * @param lastLogin Last login
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
