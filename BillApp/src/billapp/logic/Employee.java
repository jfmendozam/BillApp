package billapp.logic;

import java.util.Date;

/**
 * Employee class
 * @author jf
 */
public class Employee {
    private long id;                /** Employee id */
    private String firstname;       /** Employee firstname */
    private String lastname;        /** Employee lastname */
    private int gender;             /** Employee gender (Female = 0; Male = 1) */
    private String photo;           /** Path of Employee photo filename */
    private Date bornDate;          /** Employee born date */
    private Date hiredDate;         /** Employee hired date */
    private int salary;             /** Employee salary */

    private final long MILSEC_DAY = 1000 * 60 * 60 * 24;    // Miliseconds per day
    private final int DAY_YEAR = 365;                       // Days per year

    /**
     * Default constructor
     */
    public Employee() {
        this.id = 0;
        this.firstname = "";
        this.lastname = "";
        this.gender = 0;
        this.photo = "";
        this.bornDate = new Date();
        this.hiredDate = new Date();
        this.salary = 0;
    }

    /**
     * Constructor with parameters
     * @param id Employee id
     * @param firstname Employee firstname
     * @param lastname Employee lastname
     * @param gender Employee gender (0 = Female, 1 = Male)
     * @param photo Employee photo filename
     * @param bornDate Employee born date
     * @param hiredDate Employee hired date
     * @param salary Employee salary
     */
    public Employee(long id, String firstname, String lastname, int gender, String photo, Date bornDate, Date hiredDate, int salary) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.photo = photo;
        this.bornDate = bornDate;
        this.hiredDate = hiredDate;
        this.salary = salary;
    }

    /**
     * Get Employee id
     * @return Employee id
     */
    public long getId() {
        return id;
    }

    /**
     * Set Employee id
     * @param id Employee id
     */
    public void setId(long id) {
        this.id = id;
    }

    
    /**
     * Get Employee firstname
     * @return Employee firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set Employee firstname
     * @param firstname Employee firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Get Employee lastname
     * @return Employee lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set Employee lastname
     * @param lastname 
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Get Employee gender
     * @return Employee gender
     */
    public int getGender() {
        return gender;
    }

    /**
     * Set Employee gender
     * @param gender Employee gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * Get Employee photo filename
     * @return Employee photo filename
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Set Employee photo filename
     * @param photo Employee photo filename
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Get Employee born date
     * @return Employee born date
     */
    public Date getBornDate() {
        return bornDate;
    }

    /**
     * Set Employee born date
     * @param bornDate Employee born date
     */
    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    /**
     * Get Employee hired date
     * @return Employee hired date
     */
    public Date getHiredDate() {
        return hiredDate;
    }

    /**
     * Set Employee hired date
     * @param hiredDate Employee hired date
     */
    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    /**
     * Set Employee salary
     * @return Employee salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Get Employee salary
     * @param salary Employee salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Get Employee age (years)
     * @return Age (years)
     */
    public int getAge() {
        Date currentDate = new Date();
        int age = (int)((currentDate.getTime() - this.getBornDate().getTime()) / MILSEC_DAY);
        return age / DAY_YEAR;
    }

    /**
     * Get Employee old (years)
     * @return Old (years)
     */
    public int getOld() {
        Date currentDate = new Date();
        int age = (int)((currentDate.getTime() - this.getHiredDate().getTime()) / MILSEC_DAY);
        return age / DAY_YEAR;
    }

    /**
     * Get employee benefits (benefits = old * salary / 12)
     * @return Employee benefits (benefits = old * salary / 12)
     */
    public int getBenefits() {
        int benefits = this.getOld() * this.getSalary() / 12;
        return benefits;
    }
}
