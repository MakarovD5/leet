package com.hsp.testpackge.encapsulation;

/**
 * @author MakarovD
 * @date 2022/5/23
 */
public class Computer {
    String cpu;
    String memroy;
    String harddisk;

    int a = 30;

    public String getDetails() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memroy='" + memroy + '\'' +
                ", harddisk='" + harddisk + '\'' +
                '}';
    }

    public int getA() {
        return a;
    }
}

class PC extends Computer{
    String brand;

    @Override
    public String getDetails() {
        return super.getDetails()+" color="+brand;

    }
}

class NotePad extends Computer{
    String color;
    int a = 10;

    @Override
    public String getDetails() {
        return super.getDetails()+" color="+color;

    }


    @Override
    public int getA() {
        return a;
    }
}

class Test{
    public static void main(String[] args) {
        PC pc = new PC();
        pc.brand = "inter";
        pc.cpu = "10400";
        pc.memroy = "ddr4";
        pc.harddisk = "500g";
        System.out.println(pc.getDetails());

        Computer computer = new NotePad();

        NotePad notePad = (NotePad) computer;
        System.out.println(computer);


        //a 的编译类型 A, 运行类型 B
        A a = new B();//向上转型
        System.out.println(a.sum());//?40 -> 30
        System.out.println(a.sum1());//?30-> 20
    }


}

class A {//父类
    public int i = 10;
    //动态绑定机制:
    public int sum() {//父类 sum()
        return getI() + 10;//20 + 10
    }
    public int sum1() {//父类 sum1()
        return i + 10;//10 + 10
    }
    public int getI() {//父类 getI
        return i;
    }
}
class B extends A {//子类
    public int i = 20;
    // public int sum() {
// return i + 20;
// }
    @Override
    public int getI() {//子类 getI()
        return i;
    }
// public int sum1() {
// return i + 10;
// }
}
