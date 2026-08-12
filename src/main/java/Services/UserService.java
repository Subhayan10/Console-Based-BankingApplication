package Services;

import Entity.Transaction;
import Entity.User;
import Repositories.UserRepository;

import java.util.List;
import java.util.Scanner;

public class UserService {

    UserRepository userRepository = new UserRepository();
    Scanner sc = ConsoleInput.SCANNER;
    MoneyTransferService  moneyTransferService = new MoneyTransferService();
    User user ;

    public void printUser()
    {
        userRepository.PrintUser();
    }

    public User Login(String username, String password)
    {
        return  userRepository.Login(username, password);
    }

    public boolean addUser(String username, String password,int contactNumber, String role, int bankBalance)
    {
        User user = new User(username, password, contactNumber, role, bankBalance);
        return userRepository.addUser(user);
    }

    public void UserHelp(String username)
    {
        user = userRepository.findByUsername(username);
        boolean flag = true;
        while (flag) {
            printMenu();
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    flag = false;
                    break;
                case 2:
                    System.out.println(user.getBankBalance());
                    break;
                case 3:
                    moneyTransferService.TransferMoney(username);
                    break;
                case 4:
                    printTransactionHistory(username);
                    break;
                case 5:
                    user = new User(setUserName(), setPassword(), setContactNumber(), setRole(), setBankBalance());
                    userRepository.addUser(user);
                    break;
                case 6:
                    flag = false;
                    new LogInService().LogIn();
                    break;
                default:
                    System.out.println("Invalid option, please try again");

                    break;
            }
        }
    }

    private void printMenu()
    {
        System.out.println("Welcome User");
        System.out.println("Select an option");
        System.out.println("1. Exit");
        System.out.println("2. Check Balance");
        System.out.println("3. Transfer Money");
        System.out.println("4. Transaction History");
        System.out.println("5. Create Account");
        System.out.println("6. ReLogin");
    }

    private void printTransactionHistory(String username)
    {
        List<Transaction> transactionHistory = userRepository.getTransactionHistory(username);

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found");
            return;
        }

        transactionHistory.forEach(System.out::println);
    }

    public String setUserName()
    {
        System.out.println("Enter userName");
        return sc.nextLine();
    }

    public String setPassword()
    {
        System.out.println("Enter password");
        return sc.nextLine();
    }

    public int setContactNumber()
    {
        System.out.println("Enter contactNumber");
        return Integer.parseInt(sc.nextLine());
    }

    public String setRole()
    {
        System.out.println("Enter role");
        return sc.nextLine();
    }

    public int setBankBalance()
    {
        System.out.println("Enter bankBalance");
        return Integer.parseInt(sc.nextLine());
    }
}
