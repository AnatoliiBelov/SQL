package service;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    Employee getEmployeeForId(int id);

    List<Employee> getAllEmployees();


    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
