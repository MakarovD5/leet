package com.hsp.ploy;

/**
 * @author MakarovD
 * @date 2022/5/25
 */
public class Manager extends Employee{
    private double bonus;

    public Manager() {
    }

    public Manager(String name, double monthSal, double bonus) {
        super(name, monthSal);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void manage(){
        System.out.println("经理管理");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual()+bonus;
    }
}
