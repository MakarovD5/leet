//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 4974 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
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

    public int ishuiwenString(String s){
        StringBuffer reverse = new StringBuffer(s).reverse();
        if (s.equals(reverse.toString())){
            return s.length();
        }else {
            return 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
