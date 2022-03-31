package test;

import code.Leet;
import org.junit.jupiter.api.Test;

public class LeetTest {
    Leet leet = new Leet();

    @Test
    public void testlengthOfLongestSubstring_3(){
        int pwwkew = leet.lengthOfLongestSubstring_3("abba");
        System.out.println(pwwkew);
    }

    @Test
    public void testaddBinary67(){
        String a = "1";
        String b = "111";
        String s = leet.addBinary67(a,b);

        System.out.println(s);

    }

    @Test
    public void testisPalindrome125(){
        boolean is = leet.isPalindrome125("A man, a plan, a canal: Panama");
        System.out.println(is);

    }

}
