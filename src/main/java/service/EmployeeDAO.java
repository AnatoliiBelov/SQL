package service;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    Employee getEmployeeForId(int id);

    List<Employee> getAllEmployees();


    void updateEmployee(String columnName, int values, int id);

    void updateEmployee(String columnName, String values, int id);

    void deleteEmployee(int id);
}
