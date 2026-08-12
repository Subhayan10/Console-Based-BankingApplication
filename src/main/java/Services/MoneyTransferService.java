package Services;


import Repositories.UserRepository;

import java.util.Scanner;

public class MoneyTransferService {
    Scanner sc = ConsoleInput.SCANNER;
    UserRepository  userRepository = new UserRepository();
    boolean res = false;
    public void TransferMoney(String username) {
        System.out.println("Enter the amount you want to transfer");
        int amount = Integer.parseInt(sc.nextLine());

        if (!userRepository.checkSufficientBalance(amount, username)) {
            System.out.println("You have not enough balance");
            return;
        }

        System.out.println("Enter the username of receiver");
        String receiver = sc.nextLine();

        boolean res = userRepository.transferMoney(username, receiver, amount);

        if (res) {
            System.out.println("You have successfully transferred");
        } else {
            System.out.println("Invalid receiver username");
        }
    }
}
