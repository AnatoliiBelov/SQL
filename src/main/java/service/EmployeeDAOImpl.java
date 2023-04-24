package service;

import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private String command;

    private Connection getConnection() throws SQLException {
        String name = "postgres";
        String password = "CRaZy1992";
        String url = "jdbc:postgresql://localhost:5432/skypro";
        final Connection connection = DriverManager.getConnection(url, name, password);
        return connection;
    }

    @Override
    public void addEmployee(Employee employee) {
        command = "INSERT INTO employee ( first_name, last_name, gender, age, city_id) " +
                "VALUES ((?),(?), (?), (?), (?));";
        try {
            PreparedStatement statement = getConnection().prepareStatement(command);
            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getCity_id());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employee getEmployeeForId(int id) {
        command = "SELECT * FROM employee " +
                "INNER JOIN city " +
                "ON city.city_id=employee.city_id " +
                " WHERE id = (?);";
        Employee employee1 = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(command);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        new City(resultSet.getInt("city_id"), resultSet.getString("city_name")),
                        resultSet.getInt("id"));
                employee1 = employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee1;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        command = "SELECT* FROM city " +
                "INNER JOIN employee " +
                "ON city.city_id=employee.city_id ";
        try {
            PreparedStatement statement = getConnection().prepareStatement(command);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        new City(resultSet.getInt("city_id"), resultSet.getString("city_name")),
                        resultSet.getInt("id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(String columnName, int values, int id) {
        command = "UPDATE employee SET (?)=(?) WHERE id=(?)";
        try {
            PreparedStatement statement = getConnection().prepareStatement(command);
            statement.setString(1, columnName);
            statement.setInt(2, values);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateEmployee(String columnName, String values, int id) {
        command = "UPDATE employee SET "+columnName+"=(?) WHERE id=(?)";
        try {
            PreparedStatement statement = getConnection().prepareStatement(command);
            statement.setString(1, values);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteEmployee(int id) {
        command = "DELETE FROM employee WHERE id=(?)";
        try {
            PreparedStatement statement = getConnection().prepareStatement(command);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
