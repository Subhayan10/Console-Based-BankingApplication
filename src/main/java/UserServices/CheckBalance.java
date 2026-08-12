package UserServices;

import Handler.DatabaseHandler.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckBalance {
    String sql = "Select Amount from users where Username=?";

    public void check(String username) {
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Available Balance : Rs. " + rs.getString("Amount"));
                } else {
                    System.out.println("User not found");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
