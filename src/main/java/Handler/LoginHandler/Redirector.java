package Handler.LoginHandler;

import Services.ConsoleInput;
import UserServices.Login;
import UserServices.Register;
import UserServices.UserServicesPage;
import java.util.Scanner;

public class Redirector {

    Scanner sc = new Scanner(System.in);
    UserServicesPage us = new UserServicesPage();
    Register reg = new Register();
    Login lg = new Login();

    public void method()
    {
        while (true){
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Quit");
            int res = Integer.parseInt(sc.nextLine());
            if(res == 1)
            {
                System.out.println("Admin or User");
                {
                    String res2 = sc.nextLine();
                    if(res2.equalsIgnoreCase("Admin"))
                    {

                    } else if (res2.equalsIgnoreCase("User")) {
                        System.out.println("Please Enter Your Username");
                        String username = sc.nextLine();
                        System.out.println("Please Enter Your Password");
                        String password = sc.nextLine();
                        boolean value = lg.fetchUser(username,password);
                        if(value)
                        {
                            us.services(username,password);
                        }else{
                            System.out.println("Invalid Username or Password");
                        }
                    }else
                    {
                        System.out.println("Invalid input");
                    }
                }
            } else if (res == 2) {
                System.out.println("Create your username");
                String username = sc.nextLine();
                System.out.println("Create your password");
                String password = sc.nextLine();
                System.out.println("Confirm your password");
                String confirm = sc.nextLine();
                if(!confirm.equals(password))
                {
                    System.out.println("Passwords do not match");
                    return;
                }
                System.out.println("Enter your Name");
                String name = sc.nextLine();
                System.out.println("Enter your Age");
                int age = Integer.parseInt(sc.nextLine());
                reg.CreateUser(username,password,name,age);
            } else if (res == 3) {
                System.exit(0);
                break;
            }else{
                System.out.println("Invalid choice");
            }
        }

    }
}
