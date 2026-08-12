package UserServices;

import Handler.DatabaseHandler.DatabaseConnection;

import java.sql.*;

public class Login {
    String sql = "select Password from users where Username = ?";

    public boolean fetchUser(String username, String password) {
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                if(rs.getString("Password").equals(password)) {
//                    System.out.println("Welcome "+username);
                    return true;
                }else  {
//                    System.out.println("Wrong Password");
                    return false;
                }
            }else  {
//                System.out.println("Invalid Password or Username");
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
