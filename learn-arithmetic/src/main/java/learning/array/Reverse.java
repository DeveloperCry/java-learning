package learning.array;

public class Reverse {
    public static void main(String[] args) {
        int l = -1534236469;
        String str = String.valueOf(l);
        int negative = l < 0 ? -1 : 1;
        StringBuilder builder = new StringBuilder(negative < 0 ? str.substring(1) : str);
        StringBuilder newBuilder = builder.reverse();
        int newValue = 0;
        try {
            newValue = Integer.valueOf(newBuilder.toString()) * negative;
        } catch (NumberFormatException e) {
            newValue = 0;
        }
        System.out.println(newValue);
    }
}
