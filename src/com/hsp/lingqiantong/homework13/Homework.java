package com.hsp.lingqiantong.homework13;

/**
 * @author MakarovD
 * @date 2022/5/28
 */
public class Homework {
    public static void main(String[] args) {
        Person[] people = {new Student("xu1","nan",13,110)
                ,new Student("xue2","nv",11,330)
                ,new Teacher("shi1","a",44,22)
                ,new Teacher("shi2","nv", 43,12)};

        for (int i = 0; i<people.length-1; i++){
            for (int j = 0; j< people.length-1-i; j++){
                if (people[j].getAge() > people[j+1].getAge()){
                    Person person = people[j];
                    people[j] = people[j+1];
                    people[j+1] = person;
                }
            }
        }

        Homework homework = new Homework();
        for (Person p :
                people) {
            homework.ff(p);
            System.out.println("-------------------");
        }

    }

    public void ff(Person p) {
        if (!(p instanceof Person)){
            return;
        }
        if (p instanceof Student){
            String study = ((Student) p).study();
            System.out.println(study);
        }
        if (p instanceof Teacher){
            String study = ((Teacher) p).teach();
            System.out.println(study);
        }
    }
}

class Person {
    private String name;
    private String sex;
    private int age;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String play() {
        return name;
    }

    public String printInfo() {
        String s = "姓名：" + name + "\n年龄：" + age + "\n性别：" + sex;
        return s;
    }
}

class Student extends Person {

    private int stu_id;

    public Student(String name, String sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String play() {
        return super.play() + "爱玩足球";
    }

    public String study() {
        return "I am studying";
    }

    @Override
    public String printInfo() {
        String s = "学生的信息：\n" + super.printInfo() + "\n学号：" +stu_id+play();
        return s;
    }
}

class Teacher extends Person {
    private int work_age;

    public Teacher(String name, String sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    @Override
    public String play() {
        return super.play() + "爱玩象棋";
    }

    public String teach() {
        return "I am teaching";
    }

    @Override
    public String printInfo() {
        String s = "老师的信息：\n" + super.printInfo() + "\n工龄：" +work_age+play();
        return s;
    }
}