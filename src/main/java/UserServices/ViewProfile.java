package UserServices;

import Handler.DatabaseHandler.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewProfile {
    String sql = " select * from users where username = ? ";
    public void view(String username)
    {
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ){

            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                System.out.println();
                System.out.println();
                System.out.println("UniqueID = "+rs.getString("UniqueID"));
                System.out.println("Username = " + rs.getString("Username"));
                System.out.println("Password = " + rs.getString("Password"));
                System.out.println("Name = " + rs.getString("Name"));
                System.out.println("Age = " + rs.getString("Age"));
                System.out.println("Balance = " + rs.getString("Amount"));
                System.out.println("Status = " + rs.getString("Status"));
                System.out.println();
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
