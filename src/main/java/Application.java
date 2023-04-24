import model.Employee;
import service.EmployeeDAO;
import service.EmployeeDAOImpl;

import java.util.List;

public class Application {
    public static void main(String[] args)  {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    Employee employee1 = new Employee("Roman", "Vasiljev", "male", 25, 1);

    employeeDAO.addEmployee(employee1);
        employeeDAO.getEmployeeForId(5);
        List<Employee> employeeList = employeeDAO.getAllEmployees();
        for (Employee employee :
                employeeList) {
            System.out.println(employee);
        }
        Employee employee2 = new Employee("Olga", "Frolova", "female", 24, 2, 5);
        employeeDAO.updateEmployee(employee2);
        employeeDAO.deleteEmployee(employee2);
}}
