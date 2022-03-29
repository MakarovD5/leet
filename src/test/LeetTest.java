package test;

import code.Leet;
import org.junit.jupiter.api.Test;

public class LeetTest {
    Leet leet = new Leet();

    @Test
    public void testaddBinary67(){
        String a = "1";
        String b = "111";
        String s = leet.addBinary67(a,b);

        System.out.println(s);

    }

}
