package learning.data;

public class EqTest {
    public static void main(String[] args) {
        Integer i = 7;
        Integer j = 7;
        System.out.println(i == j);

        String str = "a" + "b" + "c" + "d" + "e";
        System.out.println(str == "abcde");//true

        String str2 = "a";
        str2 = str2 + "c";
        System.out.println(str2 == "ac");//false
    }
}
