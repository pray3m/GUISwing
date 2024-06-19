import java.sql.*;

public class DbOperation {

    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc";
    private static final String USER = "postgres";
    private static final String PASSWORD = "p@ssword";


    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    public static void insertUser(String name, String email, String password, String gender, String message) throws Exception {

        Connection connection = DbOperation.getConnection();
        String INSERT_QUERY = "INSERT  INTO user_info(name,email,password,gender,message) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, message);
            preparedStatement.executeUpdate();

            boolean isResultSet = preparedStatement.execute();
            if (!isResultSet) {
                int updateCount = preparedStatement.getUpdateCount();
                System.out.println("Update Count------->" + updateCount);
                System.out.println("DATA INSERTION SUCCESSFUL! \uD83D\uDE80");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            connection.close();
        }
    }

    public static void createTableUserInfo() throws Exception {
        String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS user_info (id SERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL UNIQUE, password VARCHAR(255) NOT NULL, gender VARCHAR(255) NOT NULL, message TEXT);";

        Connection connection = DbOperation.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.execute(CREATE_QUERY);
            System.out.println("Table 'user_info' created successfully!");
        } finally {
            connection.close();
        }
    }


    public static void printTableData() throws Exception {
        Connection connection = DbOperation.getConnection();
        String SELECT_QUERY = "SELECT * FROM user_info";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

            System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", "User ID", "Name", "Email", "Password", "Gender");

            while (resultSet.next()) {
                System.out.printf("%-20d %-20s %-20s %-20s %-20s%n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
            }
        } finally {
            connection.close();
        }
    }


}