package UserServices;

import Handler.DatabaseHandler.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordUpdater {
    String sql = "update users set password = ? where username = ?";
    public void changePassword(String Username, String newPassword)  {
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1,newPassword);
            ps.setString(2,Username);
            int res = ps.executeUpdate();
            if(res==1)
            {
                System.out.println("Password changed successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
