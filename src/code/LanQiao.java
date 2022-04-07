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

    @Test
    public void xiangcheng(){
        long x = 1000000007;
        long yu = 999999999;
        for (long i = 1; i<=x; i++){
            if ( (i*2021) % x == yu ){
                System.out.println(i);
            }
        }
    }

    @Test
    /**
     * 注意点：
     * 1、斜率和截距用浮点数
     * 2、x轴和y轴可以最后单独加上，所以只计算斜线就行
     * 3、***浮点数比较***
     */
    public void zhixian(){
        int heng = 20;
        int zhong = 21;

        //生成所有的点
        List<int[]> pointList = new ArrayList<>();
        for (int i = 0; i<heng; i++){
            for (int j = 0; j<zhong; j++){
                pointList.add(new int[]{i,j});
            }
        }

        Map<Float,List<Float>> hashmap = new HashMap<>();

        int count = 0;

        for (int i = 0; i<pointList.size(); i++){
            for (int j = i+1; j< pointList.size(); j++){
                if (i==j){
                    continue;
                }

                float x1 = pointList.get(i)[0];
                float y1 = pointList.get(i)[1];
                float x2 = pointList.get(j)[0];
                float y2 = pointList.get(j)[1];
                float k = 0;
                float b = 0;
                k = (y2 - y1) / (x2 - x1);
//                hashmap.get(k);
                if (k==Float.POSITIVE_INFINITY || k == Float.NEGATIVE_INFINITY){
//                    if (!hashmap.containsKey(k)){
//                        ArrayList<Float> flist = new ArrayList<>();
//                        flist.add(x1);
//                        hashmap.put(k,flist);
//                    }else {
//                        List<Float> flist = hashmap.get(k);
//                        boolean cunzai = true;
//                        for (Float f : flist) {
//                            if (Math.abs(f - x1) < 0.000001) {
//                                cunzai = false;
//                                break;
//                            }
//                        }
//                        if (cunzai){
//                            flist.add(x1);
//                        }
//                    }
                }else if (Math.abs(k-0)<0.000001){
//                    if (!hashmap.containsKey(k)){
//                        ArrayList<Float> flist = new ArrayList<>();
//                        flist.add(y1);
//                        hashmap.put(k,flist);
//                    }else {
//                        List<Float> flist = hashmap.get(k);
//                        boolean cunzai = true;
//                        for (Float f : flist) {
//                            if (Math.abs(f - y1) < 0.000001) {
//                                cunzai = false;
//                                break;
//                            }
//                        }
//                        if (cunzai){
//                            flist.add(y1);
//                        }
//                    }

                }else {
                    b = y1-(k*x1);

                    if (!hashmap.containsKey(k)){
                        ArrayList<Float> flist = new ArrayList<>();
                        flist.add(b);
                        hashmap.put(k,flist);
                    }else {
                        List<Float> flist = hashmap.get(k);
                        boolean cunzai = true;
                        for (Float f : flist) {
                            if (Float.toString(f).equals(Float.toString(b))){
                                cunzai = false;
                                break;
                            }
//                            if (Math.abs(f - b) < 0.01) {
//                                cunzai = false;
//                                break;
//                            }
                        }
                        if (cunzai){
                            flist.add(b);
                        }
                    }
                }

            }
        }

        for (List<Float> fl:hashmap.values()){
            for (Float f: fl){
                count++;
            }
        }
        System.out.println(count+heng+zhong);
    }

    public static void main(String[] args) {
//        fenguoguo();
    }
}
