import model.City;
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
        //        cityDAO.addCity(new City("Ярославль"));
        City city = cityDAO.getCityForId(0);

//        Employee employee = new Employee("Ольга", "Романовская", "female", 29, city);
//        employeeDAO.addEmployee(employee);
        cityDAO.deleteCity(city);

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
