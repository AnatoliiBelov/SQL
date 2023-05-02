import model.Employee;
import service.CityDAO;
import service.CityDAOImpl;
import service.EmployeeDAO;
import service.EmployeeDAOImpl;

import java.util.List;

public class Application {
    public static void main(String[] args)  {
        CityDAO cityDAO = new CityDAOImpl();
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

//        System.out.println(employeeDAO.getEmployeeForId(1));
//    Employee employee1 = new Employee("Roman", "Vasiljev", "male", 25, );
//    employeeDAO.deleteEmployee(employee1);

//    employeeDAO.addEmployee(employee1);
//        employeeDAO.getEmployeeForId(5);
//        List<Employee> employeeList = employeeDAO.getAllEmployees();
//        for (Employee employee :
//                employeeList) {
//            System.out.println(employee);
//        }
//        Employee employee2 = new Employee("Olga", "Frolova", "female", 24, 2, 5);
//        employeeDAO.updateEmployee(employee2);
//        employeeDAO.deleteEmployee(employee2);
}}
