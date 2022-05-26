package com.hsp.lingqiantong;

import java.util.Arrays;

/**
 * @author MakarovD
 * @date 2022/5/26
 */
public class Person {
    private String name;
    private int age;
    private String job;

    public Person() {
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person[] pArr = new Person[3];
        pArr[0] = new Person("maka",44,"pro");
        pArr[1] = new Person("smith",22,"www");
        pArr[2] = new Person("wa",32,"php");

        for (int i = 0; i < pArr.length-1; i++){
            for (int j = 0; j < pArr.length-1-i; j++){
                if (pArr[j].age>pArr[j+1].age){
                    Person temp = pArr[j];
                    pArr[j] = pArr[j+1];
                    pArr[j+1] = temp;
                }
            }
        }

        for (Person p:pArr) {
            System.out.println(p);
        }
    }
}
