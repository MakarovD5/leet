package code;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * @author MakarovD
 * @date
 */
public class ComputingEssence {
    Logger logger = Logger.getLogger("CElogger");

    @Test
    /**
     * 求数组中最大和区间
     */
    public void quetstion1p3(){
        double[] arr = {1.5,-12.3,3.2,-5.5,23.2,3.2,-1.4,-12.2,34.2,5.4,-7.8,1.1,-4.9};
        double max = -999;
        int q = 0;
        int p = 0;
        int maxp = 0;

        if (arr.length<=0){
            System.out.println("数组为空");
            return;
        }

        while (arr[p]<0 || Math.abs(arr[p]-0)<0.001){
            if (max<arr[p]){
                max = arr[p];
                q=p;
                maxp = p;
            }

            p++;
            if (p>=arr.length){
                System.out.println("["+p+","+q+"]");
//                logger.info("["+q+","+"q"+"]");
                return;
            }
        }


        double sum = 0;
        for (int i = p; i<arr.length; i++){

            sum = sum + arr[i];
            if (sum<0){
                //这里没必要重新从后往前在搜一遍了
//                double tmax=0;
//                int tempq = i;
//                while (arr[tempq]<0 || Math.abs(arr[tempq]-0)<0.001){
//                    tempq--;
//                }
//                for (int j = p; j>=p; j--){
//                    tmax = tmax + arr[j];
//                    if (tmax>max){
//                        max = tmax;
//                        q = j;
//                    }
//                }
                p=i+1;
                sum = 0;
                continue;
            }else if (max<sum){
                max = sum;
                q = i;
                maxp = p;
            }
        }

        System.out.println("["+maxp+","+q+"]");

    }
}
