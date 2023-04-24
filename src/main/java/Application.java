import java.sql.*;

public class Application {
    public static void main(String[] args) {

connection();
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
