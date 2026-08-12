package Handler.DatabaseHandler;

import org.jspecify.annotations.NonNull;

import java.sql.*;

public class DatabaseConnection {

//    public static void test() {
//
//        String url = envOrDefault("DB_URL", "jdbc:mysql://localhost:3306/bank");
//        String user = envOrDefault("DB_USER", "root");
//        String password = envOrDefault("DB_PASSWORD", "Inc@rrect12");
//
//        try (Connection connection = DriverManager.getConnection(url, user, password)) {
//            System.out.println("Connected to MySQL successfully.");
//            System.out.println("Database product: " + connection.getMetaData().getDatabaseProductName());
//            System.out.println("Database version: " + connection.getMetaData().getDatabaseProductVersion());
//        } catch (SQLException exception) {
//            System.err.println("Could not connect to MySQL.");
//            System.err.println(exception.getMessage());
//        }
//    }
//
//    private static String envOrDefault(String name, String defaultValue) {
//        String value = System.getenv(name);
//        return value == null || value.isBlank() ? defaultValue : value;
//    }


    static String url = "jdbc:mysql://localhost:3306/bank";
    static String user = "root";
    static String password = "Inc@rrect12";

    public static void test()
    {
        try(Connection conn = DriverManager.getConnection(url,user,password)){
            System.out.println("Connected to database successfully");
        }catch (SQLException e){
            System.err.println("Error connecting to database.");
        }
    }

    public static Connection getConnection(){
        try(Connection conn = DriverManager.getConnection(url,user,password)){
            return DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            return  null;
        }
    }
}
