package UserServices;

import java.util.Scanner;

public class UserServicesPage {

    Scanner sc = new Scanner(System.in);
    Register res =  new Register();
    Login login = new Login();
    ViewProfile viewProfile = new ViewProfile();
    CashOperations cashOperations = new CashOperations();
    CheckBalance checkBalance = new CheckBalance();
    PasswordUpdater passwordUpdater = new PasswordUpdater();

    public void services(String usr, String pass)
    {
        System.out.println();
        System.out.println();
        System.out.println("Welcome "+usr);
        while(true){
            System.out.println("Enter 1,2,3.... for whatever service you need");
            System.out.println(
                    "1. View Profile\n" +
                    "2. Check Balance\n" +
                    "3. Deposit\n" +
                    "4. Withdraw\n" +
                    "5. Transfer\n" +
                    "6. Transaction History\n" +
                    "7. Change Password\n" +
                    "8. Logout\n" +
                    "9. Exit");
            int option = Integer.parseInt(sc.nextLine());
            if(option == 9)
            {
                System.out.println("Thank you for using our service");
                System.exit(0);
            }
            if(option == 8)
            {
                break;
            }
            if(option == 1)
            {
                viewProfile.view(usr);
            }
            if(option == 2)
            {
                checkBalance.check(usr);
            }
            if(option == 3)
            {
                System.out.println("Enter the Amount you want to deposit");
                int amount = Integer.parseInt(sc.nextLine());
                cashOperations.DepositAmt(usr,amount);
            }
            if(option == 4)
            {
                System.out.println("Enter the Amount you want to withdraw");
                int amount = Integer.parseInt(sc.nextLine());
                cashOperations.WithdrawAmt(usr,amount);
            }
            if(option == 5)
            {
                System.out.println("Enter Receiver's username");
                String receiver = sc.nextLine();
                System.out.println("Enter Amount you want to transfer");
                int amount = Integer.parseInt(sc.nextLine());
                cashOperations.TransferAmt(usr,receiver,amount);
            }
            if(option == 6)
            {
                continue;
            }
            if(option == 7)
            {
                System.out.println("Enter the new Password");
                String password = sc.nextLine();
                passwordUpdater.changePassword(usr,password);
            }
        }

    }
}
