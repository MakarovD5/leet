package com.hsp.ploy;

/**
 * @author MakarovD
 * @date 2022/5/25
 */
public class Worker extends Employee{

    public void work() {
        System.out.println("员工work");
    }

    public Worker() {
    }

    public Worker(String name, double monthSal) {
        super(name, monthSal);
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
