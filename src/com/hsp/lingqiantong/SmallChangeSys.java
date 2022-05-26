package com.hsp.lingqiantong;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author MakarovD
 * @date 2022/5/26
 */
public class SmallChangeSys {
    public static void main(String[] args) {

        boolean loop = true;
        Scanner scan = new Scanner(System.in);
        String key;
        double money = 0;
        double balance = 0;
        String details= "==========mingxi============";
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        do {
            System.out.println("=======lqt=======");
            System.out.println("1 明细");
            System.out.println("2 收益");
            System.out.println("3 消费");
            System.out.println("4 退出");

            System.out.print("input(1-4)");
            key = scan.next();
            switch (key){
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("收益金额：");
                    money = scan.nextDouble();
                    balance += money;
                    date = new Date();
                    details += "\n收益\t+" +money + "\t" + sdf.format(date) + "\t余额：" + balance;
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    System.out.println("4");
                    loop = false;
                    break;
                default:
                    System.out.println("13214");
            }
        }while (loop);

        System.out.println("----tui----");
    }
}
