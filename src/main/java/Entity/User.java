package Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class User {
    public String username;
    public String password;
    public int contactNumber;
    public String role;
    public int bankBalance;

    public User() {}

    public User(String username, String password, int contactNumber, String role, int bankBalance) {
        this.username = username;
        this.password = password;
        this.contactNumber = contactNumber;
        this.role = role;
        this.bankBalance = bankBalance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contactNumber=" + contactNumber +
                ", role='" + role + '\'' +
                ", bankBalance=" + bankBalance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return contactNumber == user.contactNumber && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, contactNumber);
    }
}
