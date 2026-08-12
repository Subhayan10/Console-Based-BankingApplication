package Services;

import java.util.Scanner;

public class AdminService {
    UserService userService =  new UserService();
    Scanner sc = ConsoleInput.SCANNER;
    public void AdminPanel()
    {
        boolean flag = true;
        while (flag) {
            printAdminMenu();
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    flag = false;
                    break;
                case 2:
                    boolean result = userService.addUser(setUserName(), setPassword(), setContactNumber(), setRole(), setBankBalance());
                    if (result) {
                        System.out.println("User added successfully");
                    } else {
                        System.out.println("User not added successfully");
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                case 4:
                    userService.printUser();
                    break;
                default:
                    System.out.println("Invalid option, please try again");
                    break;
            }
        }
    }

    private void printAdminMenu()
    {
        System.out.println("Welcome Admin");
        System.out.println("Select an option");
        System.out.println("1. Exit");
        System.out.println("2. Add User");
        System.out.println("3 Delete User");
        System.out.println("4. Print Users");
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
