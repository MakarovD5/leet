package com.hsp.testpackge.encapsulation;

/**
 * @author MakarovD
 * @date 2022/5/22
 */
public class Account {
    private String name;
    private double balance;
    private String password;

    public Account() {
    }

    public Account(String name, double balance, String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()>=2 && name.length() <= 4){
            this.name = name;
        }else {
            System.out.println("none Name");
            this.name = "none";
        }

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance>=20) {
            this.balance = balance;
        }else {
            System.out.println("balacne set 0");
            this.balance = 0;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length()==6) {
            this.password = password;
        }else {
            System.out.println("set pw 123456");
            this.password = "123456";
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }
}
