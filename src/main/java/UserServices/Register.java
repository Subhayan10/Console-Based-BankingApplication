package UserServices;

import Handler.DatabaseHandler.DatabaseConnection;
import org.jspecify.annotations.NonNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register {
    String sql = "INSERT INTO users (Username,Password,Name,Age) VALUES (?,?,?,?)";
    public void CreateUser(String username, String password, String name, int age)
    {
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,name);
            ps.setInt(4,age);
            int res = ps.executeUpdate();
            if(res>0)
            {
                System.out.println("User Created");
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
