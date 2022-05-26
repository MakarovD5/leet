package com.hsp.testpackge.b;

import com.hsp.testpackge.a.A;

/**
 * @author MakarovD
 * @date 2022/5/22
 */
public class B extends A {

    void test(){

    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        System.out.println("n1 = "+ b.n1 + ",n2 = " + b.n2);
    }
}
