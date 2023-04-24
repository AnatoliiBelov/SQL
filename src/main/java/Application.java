import model.City;
import model.Employee;
import service.EmployeeDAO;
import service.EmployeeDAOImpl;

import java.sql.*;

public class Application {
    public static void main(String[] args) {
        connection();
        EmployeeDAO dao = new EmployeeDAOImpl();
        Employee employee = new Employee("Ivan", "Leschenko", "male", 35, new City(1, "Москва"));
        dao.addEmployee(employee);
        dao.updateEmployee("last_name", "Levchenko", 9);
        dao.deleteEmployee(8);
        System.out.println(dao.getAllEmployees());


    }




    private static void connection()  {
        try {
            String name = "postgres";
            String password = "CRaZy1992";
            String url = "jdbc:postgresql://localhost:5432/skypro";
            final Connection connection = DriverManager.getConnection(url, name, password);
            PreparedStatement statement = connection.prepareStatement("SELECT first_name, last_name, gender, city_name FROM city " +
                    "INNER JOIN employee " +
                    "ON city.city_id=employee.city_id " +
                    "WHERE id = (?);");
            statement.setInt(1, 6);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {String first_name = "first_name " + resultSet.getString("first_name");
                String last_name = "last_name " + resultSet.getString("last_name");
                String gender = "gender " + resultSet.getString("gender");
                String city_name = "city_name " + resultSet.getString("city_name");
                System.out.println(first_name);
                System.out.println(last_name);
                System.out.println(gender);
                System.out.println(city_name);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    }
