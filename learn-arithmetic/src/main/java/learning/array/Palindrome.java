package learning.array;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 * @author liu xiong
 * @date 2022/11/18
 */
public class Palindrome {
    public static void main(String[] args) {
        int x = 1221;
        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome2(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        StringBuilder builder = new StringBuilder(str);
        StringBuilder newBuilder = builder.reverse();
        return newBuilder.toString().equals(str);
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        char temp = 0;
        int length = chars.length;
        for (int i = 0; i < length/2; i++) {
            temp = chars[length - i - 1];
            chars[length - i - 1] = chars[i];
            chars[i] = temp;
        }
        return String.valueOf(chars).equals(str);
    }

    public static boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        char temp = 0;
        int length = chars.length;
        for (int i = 0; i < length/2; i++) {
            if (chars[length - i - 1] != chars[i]) {
                return false;
            }
        }
        return true;
    }

    // 官方答案
    public static boolean isPalindrome4(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int comp = 0;
        while (x > comp){
            comp = comp * 10 + x % 10;
            x /= 10;
        }
        return x == comp || comp / 10 == x;
    }
}
