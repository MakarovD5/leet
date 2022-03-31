//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7247 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
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
}
//leetcode submit region end(Prohibit modification and deletion)
