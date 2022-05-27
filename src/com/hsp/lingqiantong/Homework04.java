package com.hsp.lingqiantong;

public class Homework04 {
    public static void main(String[] args) {
        Employee wa = new Manager("wa", 2000, 5, 1.3, 123);
        Employee manager = new Manager();
        Manager a = new Manager();
        System.out.println(wa.getGrade());
        System.out.println(manager.getGrade());
        System.out.println(a.getGrade());
        wa.printSalary();
    }
}

class Employee {
    private String name;
    private double salary;
    private int day;
    private double grade = 1;

    public Employee() {
    }

    public Employee(String name, double salary, int day, double grade) {
        this.name = name;
        this.salary = salary;
        this.day = day;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void printSalary(){
        System.out.println("员工："+ name + "的工资为：" + salary*day*grade);
    }
}

class Manager extends Employee {
    private double bonus = 1000;
//    private double grade = 1.2;

    public Manager() {
        setGrade(1.4);
    }

    public Manager(String name, double salary, int day, double grade, double bonus) {
        super(name, salary, day, grade);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSalary() {
        System.out.println("员工："+ getName()+ "的工资为：" + (getSalary()*getDay()*getGrade() + bonus));
    }
}