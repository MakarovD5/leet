package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet {
    public int lengthOfLongestSubstring_3(String s) {
        Map<Character,Integer> hashmap = new HashMap<>();
        int start = 0;
        int ans = 0;
        for (int end = 0; end<s.length(); end++){
            if (hashmap.containsKey(s.charAt(end))){
                //为什么要和start比较：当前遍历到的下标为end的字符不在上一步start到end的范围的字符串内，
                //但在之前出现过已经存在hashmap里，如果此时直接把start赋值为hashmap.get(s.charAt(end))，
                //即hashmap中之前出现过这个字符的位置的下一个位置，很可能这个位置在当前start位置的前面。
                //例子：abba
                start = Math.max(start,hashmap.get(s.charAt(end)));
            }
            //end+1的使用很巧妙，即方便取长度，也方便之前找start位置
            hashmap.put(s.charAt(end),end+1);
            ans = Math.max(ans,end + 1 - start);
        }

        return ans;
    }

    public String longestPalindrome_dp_5(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        //L为本次遍历的字串长度
        for (int L = 2; L <= len; L++ ){
            //左边界为i，右边界为j = i + L - 1。
            for (int i = 0; i<len; i++){
                int j = i+L-1;
                if (j >= len){
                    break;
                }

                if (charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else {
                    if (L==2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && L>maxLen){
                    maxLen = L;
                    begin = i;
                }
            }
        }



        return s.substring(begin,begin+maxLen);
    }

    public String longestPalindrome_5(String s) {
        StringBuffer sb = new StringBuffer(s);
        Map<Character, List<Integer>> hashmap = new HashMap<>();

        if (s.equals("")){
            return "";
        }

        int ans = 1;
        String ans_s = "";

        if (ishuiwenString(s)>ans){
            return s;
        }

        for (int end = 0; end <s.length(); end++){
            char c = s.charAt(end);
            if (hashmap.containsKey(c)){
                List<Integer> integerList = hashmap.get(c);
                for (int i: integerList){
                    String substring = s.substring(i, end + 1);
                    int len = ishuiwenString(substring);
                    if (len>ans){
                        ans = len;
                        ans_s =substring;
                        break;
                    }
                }
            }

            if (hashmap.get(c)==null){
                hashmap.put(c,new ArrayList<>());
            }
            //不用赋新值就能修改该值，这里涉及到深拷贝问题
            hashmap.get(c).add(end);
//            hashmap.put(c,intList);

        }

        if (ans == 1){
            return s.substring(0,1);
        }

        return ans_s;
    }

    public int ishuiwenString(String s){
        StringBuffer reverse = new StringBuffer(s).reverse();
        if (s.equals(reverse.toString())){
            return s.length();
        }else {
            return 0;
        }
    }

    public String addBinary67(String a, String b) {
        int a_len = a.length();
        int b_len = b.length();

        //把短的字符串在头部补零，使两个字符串对齐
        StringBuffer sb = new StringBuffer();
        if (a_len > b_len){
            for (int i = 0; i<a_len-b_len; i++){
                sb.append('0');
//                b = String.valueOf(sb.append(b));
            }
            b = String.valueOf(sb.append(b));
        }else if (a_len < b_len){
            for (int i = 0; i<b_len-a_len; i++){
                sb.append('0');
//                a = String.valueOf(sb.append(a));
            }
            a = String.valueOf(sb.append(a));
        }

        System.out.println(a);
        System.out.println(b);

        StringBuffer sum_sb = new StringBuffer();
        int jinwei = 0;
        for (int i = a.length()-1; i>=0; i--){
            //char转int比较复杂
            int a_num = Character.getNumericValue(a.charAt(i));
            int b_num = Character.getNumericValue(b.charAt(i));
            int plus = a_num + b_num +jinwei;
            //如果该位相加为2或三，进位就记为1，如果为0或1，进位就记为0；
            if (plus>=2){
//                sum_sb = new StringBuffer(String.valueOf(plus-2)).append(sum_sb);
                sum_sb.insert(0,String.valueOf(plus-2));
                jinwei = 1;
            }else if (plus < 2){
//                sum_sb = new StringBuffer(String.valueOf(plus)).append(sum_sb);
                sum_sb.insert(0,String.valueOf(plus));
                jinwei = 0;
            }
        }
        if (jinwei==1){
//            sum_sb = new StringBuffer(String.valueOf(1)).append(sum_sb);
            sum_sb.insert(0,String.valueOf(1));
        }

        return String.valueOf(sum_sb);
    }

    public boolean isPalindrome125(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i<s.length(); i++){
            char c = s.charAt(i);

            if ((c>='A'&&c<='Z') || (c>='a'&&c<='z') || (c>='0'&&c<='9')){
//                String s1 = new String(String.valueOf(c)).toLowerCase(Locale.ROOT);
                sb.append(String.valueOf(c).toLowerCase());
            }
        }

//        System.out.println(sb.toString());
        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
//        StringBuffer reverse = sb.reverse();
//        System.out.println(reverse.toString());
//        System.out.println(sb.toString());

        return s1.equals(s2);
    }
}
