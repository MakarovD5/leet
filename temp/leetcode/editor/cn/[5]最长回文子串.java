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
}
//leetcode submit region end(Prohibit modification and deletion)
