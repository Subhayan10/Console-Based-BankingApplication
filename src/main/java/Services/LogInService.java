package Services;

import Entity.User;
import Main.Main;

import java.util.Scanner;

public class LogInService {

    Scanner sc = ConsoleInput.SCANNER;
    UserService userService = new UserService();
    Main ob = new Main();

    public void LogIn( )
    {
        System.out.println("Enter Username");
        String username = sc.nextLine();
        System.out.println("Enter Password");
        String password = sc.nextLine();
        User user = userService.Login(username, password);
        if (user != null && username.equals("admin") && password.equals("admin")) {
            System.out.println("Admin Logged in successfully");
            ob.adminInit();
        }else if(user != null)
        {
            System.out.println("UserLogged in successfully");
            ob.userInit(username);
        }else {
            System.out.println("Invalid username or password");
        }
    }
}
