package UserServices;

import Handler.DatabaseHandler.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CashOperations {

    String sql1 = "update users set Amount = amount+? where Username=?";
    String sql2 = "update users set Amount = amount-? where Username=?";

    public void DepositAmt(String username, int amount)
    {
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql1);
        )
        {
            ps.setInt(1, amount);
            ps.setString(2, username);
            int res = ps.executeUpdate();
            if(res>0)
            {
                System.out.println("Amount has been deposited");
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void WithdrawAmt(String username, int amount)
    {
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql2);
        )
        {
            ps.setInt(1, amount);
            ps.setString(2, username);
            int res = ps.executeUpdate();
            if(res>0)
            {
                System.out.println("Amount has been Withdrawn");
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void TransferAmt(String sender, String receiver ,int amount)
    {
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps1 = con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2);
        )
        {
            ps1.setInt(1, amount);
            ps1.setString(2, receiver);
            ps2.setInt(1, amount);
            ps2.setString(2, sender);
            int res1 =  ps1.executeUpdate();
            int res2 =  ps2.executeUpdate();

            if(res1>0 && res2>0)
            {
                System.out.println("Amount has been transferred");
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
