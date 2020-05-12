package learning.data;

public class DataTest {
    public static void main(String[] args) {
        int i = 0, b = 0;
        System.out.println(++i);
        System.out.println(b++);

        //10  1010
        System.out.println("10:" + Integer.toBinaryString(10));
        System.out.println(10 >> 3);
        //10  1010
        System.out.println("16:" + Integer.toBinaryString(16));
        System.out.println(16 >> 3);
        //10  1010
        System.out.println("10:" + Integer.toBinaryString(10));
        System.out.println(10 >>> 3);
        //10  1010
        System.out.println("1:" + Integer.toBinaryString(1));
        System.out.println(1 << 1);
        System.out.println(1 << 2);
        System.out.println(1 << 3);
        System.out.println(2 << 1);
        System.out.println(2 << 2);
        System.out.println(2 << 3);
        System.out.println(3 << 1);
        System.out.println(3 << 2);
        System.out.println(3 << 3);
        //10  1010
        System.out.println("1:" + Integer.toBinaryString(1));
        System.out.println(1 << 3);
        System.out.println("10:" + Integer.toBinaryString(10));
        System.out.println(10 >> 1);
        System.out.println(10 >> 2);
        System.out.println("5:" + Integer.toBinaryString(5));
        System.out.println(5 >> 1);


    }
}
