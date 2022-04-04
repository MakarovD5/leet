package code;

import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LanQiao {
    @Test
    //试题 历届真题 分果果【第十二届】【省赛】【研究生组】
    public static void fenguoguo(){
        /*
        Scanner scan = new Scanner(System.in);
        int n = 0;
        int m = 0;
        int[] w = null;

        n = scan.nextInt();
        m = scan.nextInt();
        w = new int[n];
        //该行用于吸收上面结束的换行符\n
        scan.nextLine();
        String s = scan.nextLine();
        String[] s1 = s.split(" ");
        for (int i = 0; i<s1.length; i++){
            w[i] = Integer.parseInt(s1[i]);
        }

         */

        int m = 5;
        int n = 2;
        int[] w = new int[]{6,1,2,7,9};

        //把数组转为list（可以增删改查那种）
        List<Integer> wList = Ints.asList(w);
        //从大到小排列
        Collections.sort(wList,Collections.reverseOrder());

        System.out.println(wList);

        List<List<Integer>> peopleList = new ArrayList<>();
        List<Integer>[] listArr = new ArrayList[n];


    }

    public int qiucha(int[] arr){
        int length = arr.length;
        Arrays.stream(arr).toArray();

        return 0;
    }

    @Test
    public void card(){
        int x = 2021;
        int num = 1;

        Map<Integer,Integer> hashmap =new HashMap<>();

        for (int i=0; i < 10; i++){
            hashmap.put(i,x);
        }

        while (true){
//            int yu = num % 10;
            int temp = num;
            while (temp >0){
                int yu = temp % 10;
                int t = hashmap.get(yu);

                if (t<1){
                    System.out.println(num-1);
                    return;
//                    return num-1;
                }
                t--;
                hashmap.put(yu,t);
                temp = temp / 10;
            }
            num++;
        }
    }

    public static void main(String[] args) {
//        fenguoguo();
    }
}
