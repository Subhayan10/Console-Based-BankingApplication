package UserServices;

import Handler.DatabaseHandler.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CashOperations {

    private static final String CREDIT_USER_SQL = "update users set Amount = Amount + ? where Username = ?";
    private static final String DEBIT_USER_SQL = "update users set Amount = Amount - ? where Username = ? and Amount >= ?";
    private static final String INSERT_TRANSACTION_SQL = "insert into Transactions(SenderUsername, ReceiverUsername, Amount, TransactionType, TransactionStatus) values (?, ?, ?, ?, ?)";

    public void DepositAmt(String username, int amount) {
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps1 = con.prepareStatement(CREDIT_USER_SQL);
            PreparedStatement ps2 = con.prepareStatement(INSERT_TRANSACTION_SQL);
        )
        {
            ps1.setInt(1, amount);
            ps1.setString(2, username);
            ps2.setString(1, username);
            ps2.setNull(2, java.sql.Types.VARCHAR);
            ps2.setInt(3, amount);
            ps2.setString(4, "Deposit");
            int res = ps1.executeUpdate();
            if(res>0)
            {
                System.out.println("Amount has been deposited");
                ps2.setString(5, "SUCCESS");
                ps2.executeUpdate();
            }else{
                ps2.setString(5, "FAILED");
                ps2.executeUpdate();
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void WithdrawAmt(String username, int amount)
    {
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(DEBIT_USER_SQL);
            PreparedStatement ps2 = con.prepareStatement(INSERT_TRANSACTION_SQL);
        )
        {
            ps.setInt(1, amount);
            ps.setString(2, username);
            ps.setInt(3, amount);
            ps2.setString(1, username);
            ps2.setNull(2, java.sql.Types.VARCHAR);
            ps2.setInt(3, amount);
            ps2.setString(4, "Withdraw");
            int res = ps.executeUpdate();
            if(res>0)
            {
                System.out.println("Amount has been Withdrawn");
                ps2.setString(5, "SUCCESS");
                ps2.executeUpdate();
            }else {
                ps2.setString(5, "FAILED");
                ps2.executeUpdate();
            }
        }catch (SQLException e)
        {
            e.printStackTrace();

        }
    }

    public void TransferAmt(String sender, String receiver ,int amount)
    {
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps1 = con.prepareStatement(CREDIT_USER_SQL);
            PreparedStatement ps2 = con.prepareStatement(DEBIT_USER_SQL);
            PreparedStatement ps3 = con.prepareStatement(INSERT_TRANSACTION_SQL);
        )
        {
            con.setAutoCommit(false);

            ps2.setInt(1, amount);
            ps2.setString(2, sender);
            ps2.setInt(3, amount);
            int res2 =  ps2.executeUpdate();

            int res1 = 0;
            if (res2 > 0) {
                ps1.setInt(1, amount);
                ps1.setString(2, receiver);
                res1 = ps1.executeUpdate();
            }

            ps3.setString(1, sender);
            ps3.setString(2, receiver);
            ps3.setInt(3, amount);
            ps3.setString(4, "Transfer");

            if(res1>0 && res2>0)
            {
                System.out.println("Amount has been transferred");
                ps3.setString(5, "SUCCESS");
                ps3.executeUpdate();
                con.commit();
            }else  {
                con.rollback();
                System.out.println("Amount could not be transferred");
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
