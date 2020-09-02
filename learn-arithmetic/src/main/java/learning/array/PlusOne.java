package learning.array;

import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
//        int[] digits = {9,8,7,6,5,4,3,2,1,0};
//        int[] digits = {9,9,9,9,9,9};
        int[] ints = plusOne2(digits);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }


    public static int[] plusOne(int[] digits) {
        StringBuilder builder = new StringBuilder();
        int result = digits[digits.length - 1] + 1;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (result > 9) {
                result = digits[i] + 1;
                builder.append("0");
            } else {
                builder.append(result);
                result = digits[i];
            }
        }
        if (result > 9) {
            builder.append("01");
        } else {
            builder.append(result);
        }
        String[] str2 = builder.reverse().toString().split("");
        int[] r = new int[str2.length];
        for (int i = 0; i < str2.length; i++) {
            r[i] = Integer.valueOf(str2[i]);
        }
        return r;
    }

    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (++digits[i]) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
