package billapp.persistence;

import billapp.logic.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Flat file class
 * @author jf
 */
public class FlatFile {
    private File file;           /** File */
    private FileReader fr;       /** File reader */
    private BufferedReader br;   /** Buffered reader */
    private FileWriter fw;       /** File writer */
    private PrintWriter pw;      /** Print writer */

    /**
     * Default constructor
     */
    public FlatFile() {
        this.file = null;
        this.fr = null;
        this.br = null;
        this.fw = null;
        this.pw = null;
    }

    /**
     * Get File
     * @return File
     */
    public File getFile() {
        return file;
    }

    /**
     * Set File
     * @param file File
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Get File reader
     * @return File reader
     */
    public FileReader getFr() {
        return fr;
    }

    /**
     * Set File reader
     * @param fr File reader
     */
    public void setFr(FileReader fr) {
        this.fr = fr;
    }

    /**
     * Get Buffered reader
     * @return Buffered reader
     */
    public BufferedReader getBr() {
        return br;
    }

    /**
     * Set Buffered reader
     * @param br Buffered reader
     */
    public void setBr(BufferedReader br) {
        this.br = br;
    }

    /**
     * Get File writer
     * @return File writer
     */
    public FileWriter getFw() {
        return fw;
    }

    /**
     * Set File writer
     * @param fw File writer
     */
    public void setFw(FileWriter fw) {
        this.fw = fw;
    }

    /**
     * Get Print writer
     * @return Print writer
     */
    public PrintWriter getPw() {
        return pw;
    }

    /**
     * Set Print writer
     * @param pw Print writer
     */
    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }

    /**
     * Read a flat file (txt / csv) and copy data into a employee object
     * @param filename Text filename
     * @param separator Separator of the fields into file
     * @return Employee list
     */
    public List<Employee> selectEmployee(String filename, String separator) {
        List<Employee> employeeList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            this.setFile(new File(filename));
            this.setFr(new FileReader(this.getFile()));
            this.setBr(new BufferedReader(this.getFr()));
            
            String record;
            while ((record = this.getBr().readLine()) != null) {
                String fields[] = record.split(separator);
                
                Employee employee = new Employee();
                employee.setId(Long.parseLong(fields[0]));
                employee.setFirstname(fields[1]);
                employee.setLastname(fields[2]);
                employee.setPhoto(fields[3]);
                employee.setGender(Integer.parseInt(fields[4]));
                employee.setBornDate(dateFormat.parse(fields[5]));
                employee.setHiredDate(dateFormat.parse(fields[6]));
                employee.setSalary(Integer.parseInt(fields[7]));
                
                employeeList.add(employee);
            }
            this.getBr().close();
            this.getFr().close();
        } catch (FileNotFoundException ex) {

        } catch (IOException | ParseException ex) {
            Logger.getLogger(FlatFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employeeList;
    }

    /**
     * Write a flat file (txt / csv)
     * @param employeeList Employee list
     * @param filename Employee filename
     * @param separator Separator
     */
    public void writeEmployee(List<Employee> employeeList, String filename, String separator) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.setFw(new FileWriter(filename));       // Parameter true for append
            this.setPw(new PrintWriter(this.getFw()));
            
            for (Employee employee : employeeList) {
                this.getPw().print(employee.getId() + separator);
                this.getPw().print(employee.getFirstname() + separator);
                this.getPw().print(employee.getLastname() + separator);
                this.getPw().print(employee.getPhoto() + separator);
                this.getPw().print(employee.getGender() + separator);
                this.getPw().print(dateFormat.format(employee.getBornDate()) + separator);
                this.getPw().print(dateFormat.format(employee.getHiredDate()) + separator);
                this.getPw().println(employee.getSalary());
            }

            this.getPw().close();
            this.getFw().close();
        } catch (IOException | NullPointerException ex) {
            Logger.getLogger(FlatFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
