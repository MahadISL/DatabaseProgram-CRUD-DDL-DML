import java.sql.SQLException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Database application with CRUD operations (DDL & DML)");
        System.out.println("Employee Data");

        Scanner in = new Scanner(System.in);
        EmployeeDTO empdto = new EmployeeDTO();

        // Input variables
        int optionInput;
        int employeeId;
        String firstName;
        String lastName;
        String occupation;
        int yearOfJoining;
        do {
            System.out.println("1. Choose option 1 to Delete Employee data");
            System.out.println("2. Choose option 2 to Get Employee data ");
            System.out.println("3. Choose option 3 to Get all the Employees data ");
            System.out.println("4. Choose option 4 to Save Employee data ");
            System.out.println("5. Choose option 5 to Update Employee data");
            System.out.println("6. Choose option 6 to exit application ");
            optionInput = in.nextInt();

            switch (optionInput){

                case 1:
                    System.out.println("Deleting Employee data....");
                    System.out.println("Enter Employee ID:");
                    employeeId = in.nextInt();
                    empdto.deleteById(employeeId);
                    break;
                case 2:
                    System.out.println("Getting Employee data....");
                    System.out.println("Enter Employee ID:");
                    employeeId = in.nextInt();
                    empdto.getById(employeeId);
                    break;
                case 3:
                    System.out.println("Getting all the Employees data");
                    empdto.readAll();
                    break;
                case 4:
                    System.out.println("Saving Employee data");

                    System.out.println("Enter Employee ID:");
                    employeeId = in.nextInt();
                    System.out.println("Enter Employee first name:");
                    firstName = in.next();
                    System.out.println("Enter Employee last name:");
                    lastName = in.next();
                    System.out.println("Enter Employee occupation:");
                    occupation = in.next();
                    System.out.println("Enter Employee yearOfJoining:");
                    yearOfJoining = in.nextInt();
                    Employee emp = new Employee(employeeId,firstName, lastName, occupation,  yearOfJoining);
                    empdto.save(emp);
                    break;
                case 5:
                    System.out.println("Updating Employee data...");
                    System.out.println("Enter Employee ID:");
                    employeeId = in.nextInt();
                    System.out.println("Enter Employee first name:");
                    firstName = in.next();
                    empdto.update(employeeId, firstName);
                    break;
                case 6:
                    DBUtils db = new DBUtils();
                    db.closeConnection();
                    System.out.println("Exiting Application...");
                    System.exit(0);


                default:
                    System.out.println("Enter a valid input.");
            }

        } while (optionInput != 6);

    }
}
