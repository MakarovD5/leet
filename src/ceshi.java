import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ceshi {

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
