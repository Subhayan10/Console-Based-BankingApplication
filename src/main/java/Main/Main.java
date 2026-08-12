package Main;

import Handler.DatabaseHandler.DatabaseConnection;
import Handler.LoginHandler.Redirector;
import Services.AdminService;
import Services.UserService;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static DatabaseConnection dbc = new DatabaseConnection();

    public static void main(String[] args) {
        main();
    }

    public static void main() {
//        LogInService ls = new LogInService();
//        ls.LogIn();

        DatabaseConnection.test();
        Redirector redirector = new Redirector();
        redirector.method();
    }

    public void adminInit()
    {
        AdminService  adminService = new AdminService();
        adminService.AdminPanel();
    }

    public void userInit(String username)
    {
        UserService userService = new UserService();
        userService.UserHelp(username);
    }
}
