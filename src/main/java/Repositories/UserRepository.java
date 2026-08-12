package Repositories;

import Entity.User;
import Entity.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserRepository {

    static Set<User> users = new HashSet<>();
    static List<Transaction> transactions = new ArrayList<>();

    static {
        User admin = new User("admin","admin",12345,"admin",0);
        User user1 = new User("user1","user1",12345,"user",1000);
        User user2 = new User("user2","user2",12345,"user",2000);
        User user3 = new User("user3","user3",12345,"user",3000);
        User user4 = new User("user3","user3",12345,"user",3000);
        users.add(admin);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    public boolean addUser(User user)
    {
        return users.add(user);
    }

    public void PrintUser()
    {
        System.out.println(users.toString());
    }

    public User Login(String username, String password)
    {
        List<User> finalList = users.stream()
                .filter(u -> u.getUsername().equals(username) &&  u.getPassword().equals(password))
                .toList();

        if(!finalList.isEmpty())
        {
            return finalList.get(0);
        }else{
            return null;
        }
    }

    public User findByUsername(String username)
    {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public boolean checkSufficientBalance(int amount,String username)
    {
        return users.stream().anyMatch(u -> u.getUsername().equals(username) && u.getBankBalance() >= amount);
    }

    public boolean transferMoney(String sender,String receiver,int amount)
    {
        User senderUser = users.stream().filter(u->u.getUsername().equals(sender)).findFirst().orElse(null);
        User recieverUser = users.stream().filter(u->u.getUsername().equals(receiver)).findFirst().orElse(null);

        if(senderUser==null || recieverUser==null)
        {
            System.out.println("Sender User or Receiver User is not found");
            return false;
        }

        if (senderUser.getBankBalance() < amount) {
            System.out.println("Insufficient balance");
            return false;
        }

        senderUser.setBankBalance(senderUser.getBankBalance() - amount);
        recieverUser.setBankBalance(recieverUser.getBankBalance() + amount);
        transactions.add(new Transaction(sender, receiver, amount));

        return true;
    }

    public List<Transaction> getTransactionHistory(String username)
    {
        return transactions.stream()
                .filter(transaction -> transaction.getSender().equals(username)
                        || transaction.getReceiver().equals(username))
                .toList();
    }
}
