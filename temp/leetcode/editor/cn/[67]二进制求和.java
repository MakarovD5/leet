////给你两个二进制字符串，返回它们的和（用二进制表示）。 
////
//// 输入为 非空 字符串且只包含数字 1 和 0。 
////
//// 
////
//// 示例 1: 
////
//// 输入: a = "11", b = "1"
////输出: "100" 
////
//// 示例 2: 
////
//// 输入: a = "1010", b = "1011"
////输出: "10101" 
////
//// 
////
//// 提示： 
////
//// 
//// 每个字符串仅由字符 '0' 或 '1' 组成。 
//// 1 <= a.length, b.length <= 10^4 
//// 字符串如果不是 "0" ，就都不含前导零。 
//// 
//// Related Topics 位运算 数学 字符串 模拟 👍 780 👎 0
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
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
}
//leetcode submit region end(Prohibit modification and deletion)
