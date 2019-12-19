package learning;

import org.junit.Test;

public class StringTest {
    @Test
    public void testIntern() {
        String a = "chrisliu";
        String b = new String("chrisliu");
        String c = "chris" + "liu";

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.intern() == b.intern());
        System.out.println(a.intern() == c.intern());
        System.out.println(a.intern());
        System.out.println(b.intern());
    }
}
