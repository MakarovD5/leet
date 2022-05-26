package com.hsp.ploy;

/**
 * @author MakarovD
 * @date 2022/5/25
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        Worker w1 = new Worker("mak",2000);
        Manager m1 = new Manager("dik",9000,100);
        System.out.println(test.showEmpAnnual(w1));
        System.out.println(test.showEmpAnnual(m1));
        test.testWork(w1);
        test.testWork(m1);

        int a = 10;
        double b = 10.0;
        if ("a==b".equals("a==b")){
            System.out.println("10==10.0");
        }



    }

    public double showEmpAnnual(Employee e){
        double annual = e.getAnnual();
        return annual;
    }

    public void testWork(Employee e){
        if (e instanceof Worker){
             ((Worker) e).work();
        }else if(e instanceof Manager){
            ((Manager) e).manage();
        }
    }
}
