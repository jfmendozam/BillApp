package billapp.view;

import billapp.logic.Employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee CLI (Command Line Interface)
 * @author jf
 */
public class EmployeeCLI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date bornDate = null;
        Date hiredDate = null;
        
        String dateString;
        try {
            dateString = "1/1/1990";
            bornDate = dateFormat.parse(dateString);
            dateString = "15/7/2006";
            hiredDate = dateFormat.parse(dateString);
            
            Employee employee = new Employee(123, "Pepito", "Pérez", 1, "", bornDate, hiredDate, 2000000);
            System.out.println("Age: " + employee.getAge() + " years");
            System.out.println("Old: " + employee.getOld() + " years");
            System.out.println("Benefits: " + employee.getBenefits());
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeCLI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
