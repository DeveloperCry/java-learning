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

        System.out.println("===============================");

        Integer[] integers = {15,2,3};
        int move = 4;
        int result = 0;
        if (integers != null) {
            for (int i = integers.length; i > 0; i--) {
                int value = integers[i - 1];
                int temp = value << ((integers.length - i) * move);
                result += temp;
            }
        }
        System.out.println(result);
        System.out.println(Integer.toBinaryString(result));

        String s = Integer.toBinaryString(result);
//        int len = s.length() % 4;
//        String newStr =  (len == 0 ? "" : String.format("%0" + (4 - len) + "d", 0)) + s;
//        System.out.println(newStr);

        int len = (int) Math.ceil(s.length() / 4.0);//方便后期扩展
        System.out.println(Integer.toBinaryString(result >>> ((len - 1) * 4)));
        System.out.println(Integer.toBinaryString(result >>> ((len - 2) * 4) & 7));
        System.out.println(Integer.toBinaryString(result >>> ((len - 3) * 4) & 7));
    }
}
