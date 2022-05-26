package com.hsp.ploy;

/**
 * @author MakarovD
 * @date 2022/5/25
 */
public class Employee {
    private String name;
    private double monthSal;

    public Employee() {
    }

    public Employee(String name, double monthSal) {
        this.name = name;
        this.monthSal = monthSal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthSal() {
        return monthSal;
    }

    public void setMonthSal(double monthSal) {
        this.monthSal = monthSal;
    }

    public double getAnnual(){
        return 12*monthSal;
    }
}
