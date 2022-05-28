package com.hsp.lingqiantong.homework05;

import java.util.Objects;

/**
 * @author MakarovD
 * @date 2022/5/27
 */
public class Homework05 {
    public static void main(String[] args) {
        Employee e1 = new Teacher("teacher1",1000,5,50);
        e1.printSal();
        Employee e2 = new Scientist("sci1",1000,80);
        e2.printSal();

        System.out.println("=======================");

        SavingsAccount savingsAccount = new SavingsAccount(5000);
        savingsAccount.deposit(230);
        savingsAccount.withdraw(120);
        savingsAccount.deposit(666);
        savingsAccount.withdraw(333);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.earnMonthlyInterest();
        System.out.println(savingsAccount.getBalance() + "," + savingsAccount.getTime());

        System.out.println("-----------------------");

        Doctor d1 = new Doctor("dwa", 21, "dd", "nv", 333);
        Doctor d2 = new Doctor("dwa", 21, "dd", "nv", 333);
        System.out.println(d1.equals(d2));
    }
}

class Employee {
    private String name;
    private double sal;

    public Employee() {
    }

    public Employee(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double annual() {
        return sal * 12;
    }

    public void printSal() {
        System.out.println(name + "的全年工资为：" + this.annual());
    }
}

class Worker extends Employee {

}

class Peasant extends Employee {

}

class Teacher extends Employee {
    private int classDay;
    private double classSal;

    public Teacher() {
    }

    public Teacher(String name, double sal, int classDay, double classSal) {
        super(name, sal);
        this.classDay = classDay;
        this.classSal = classSal;
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public double annual() {
        return super.annual() + (classDay * classSal);
    }
}

class Scientist extends Employee {
    private double bonus;

    public Scientist(String name, double sal, double bonus) {
        super(name, sal);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double annual() {
        return super.annual()+bonus;
    }
}

class Waiter extends Employee {

}

class BankAccount {
    private double balance;

    public BankAccount() {
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

class CheckingAccount extends BankAccount {
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        setBalance(getBalance()-1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        setBalance(getBalance()-1);
    }
}

class SavingsAccount extends BankAccount {
    private int time;
    private double rate = 0.04;

    public SavingsAccount(int balance) {
        super(balance);
        this.time = 3;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        if (time>0){
            time--;
            return;
        }
        setBalance(getBalance()-1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if (time>0){
            time--;
            return;
        }
        setBalance(getBalance()-1);
    }

    public void earnMonthlyInterest(){
        time = 3;
        double balance = getBalance();
        balance = balance + (balance*rate);
        setBalance(balance);
    }
}

class Doctor {
    private String name;
    private int age;
    private String job;
    private String gender;
    private double sal;

    public Doctor() {
    }

    public Doctor(String name, int age, String job, String gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Doctor doctor = (Doctor) o;
        return age == doctor.age && Double.compare(doctor.sal, sal) == 0 && Objects.equals(name, doctor.name) && Objects.equals(job, doctor.job) && Objects.equals(gender, doctor.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, job, gender, sal);
    }
}