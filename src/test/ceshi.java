package test;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ceshi {
    @Test
    public void testchar(){
        char a = '是';
        System.out.println(a);
    }

    @Test
    public void testFloat(){
        double f1 = 2.07 - 1;  //1.0699999999999998
        double f2 = 1.07;  //1.07
        //Double.toString(f1).equals(Double.toString(f2)) --> false;
        //Math.abs(f1-f2)<0.00000000000000000000000001 --> false;
        //Math.abs(f1-f2)<0.0001 --> true;
        //Double.doubleToLongBits(f1)==Double.doubleToLongBits(f2) --> false;
        //new BigDecimal(f1).equals(new BigDecimal(f2)) --> false;
        //new BigDecimal(f1).compareTo(new BigDecimal(f2))==0 --> false;
        if (new BigDecimal(f1).compareTo(new BigDecimal(f2))==0){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        Set<Double> hashset = new HashSet<>();
        hashset.add(f1);
        hashset.add(f2);
        //Set并不能认为这两个浮点数相等，无法去重
        // 输出：
        // 1.0699999999999998
        // 1.07
        for (Double f : hashset){
            System.out.println(f);
        }
    }

    @Test
    public void testchufa(){
        double i = 1.0 - 0.0 / 0.0 - 0.0;
        float x = (float) (8.0/0);
        float y = (float) (8.0/4);
        Set<float[]> ff = new HashSet<>();
        Map<Float,Float> hashmap = new HashMap<>();
        hashmap.put(x,y);
        ff.add(new float[]{x});
        System.out.println(Float.NEGATIVE_INFINITY);
        System.out.println(hashmap.get(Float.POSITIVE_INFINITY));
    }

    @Test
    public void testArrayList(){
        List<int[]> pointList = new ArrayList<>();
        pointList.add(new int[]{1,2});
        pointList.add(new int[]{2,2});
        System.out.println(pointList.get(0)[0]);
    }

    @Test
    public void testHashMap(){
        Map<Character, List<Integer>> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        hashMap.put('c',list);
        List<Integer> list1 = hashMap.get('c');
        list1.add(5);

        hashMap.get('c').add(16);

        System.out.println(hashMap.get('c'));

        Map<Character,Integer> map = new HashMap<>();
        map.put('a',6);

        System.out.println(map.get('a'));

    }

    @Test
    public void testStringBufferReverse(){
        StringBuffer sb = new StringBuffer("abcd");
        System.out.println(sb);
        StringBuffer reverse = sb.reverse();
        System.out.println(sb);
        System.out.println(reverse);
    }

    @Test
    public void fileout(){
        FileOutputStream fileout = null;
        try {
            fileout = new FileOutputStream("D:\\a.txt");
            String str = "bushide1";
            fileout.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
//        System.out.printf("ddddd");
        File file = new File("D:\\c.txt");
        FileInputStream filein = null;
        try {
            filein = new FileInputStream(file);
            byte[] buf = new byte[8];
            int readLen = 0;

            while ((readLen = filein.read(buf)) != -1){
                String s = new String(buf, 0, readLen);
                System.out.printf(s);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                filein.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
