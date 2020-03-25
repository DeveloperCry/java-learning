package learning.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NoRepeatStringCount {
    public static void main(String[] args) {
        String str = "abcabcbb";


        int length = str.length();
        int count = 0;
        LinkedList<Character> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.removeFirstOccurrence(2);
//        System.out.println(list.toString());
//        System.out.println(list.size());
        for (int i = 0; i < length; i++) {
            char character = str.charAt(i);

            int index = list.indexOf(character);
            if (index >= 0) {
                if (count < list.size()) {
                    count = list.size();
                }
                for (int j = 0; j <= index; j++) {
                    list.pop();
                }
            }

            list.add(character);
        }

        if (list.size() > count) {
            count = list.size();
        }
        System.out.println(count);
    }
}
