package learning.list;

import learning.pojo.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class ArrayListTest {
    public static void main(String[] args) {
//        testInitList();
//        testRemoveElement();
//        testForEachRemaining();
//        testSubList();
//        testSpliterator();
        testRemoveIf();

    }

    private static void testInitList() {
        List<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setName("张三");
        persons.add(person);

        List<Person> personList = new ArrayList<>(persons);
        System.out.println(persons);
        System.out.println(personList);

        person.setName("李四");
        System.out.println("修改后。。。。。。。。。。。");
        System.out.println(persons);
        System.out.println(personList);
        personList.clear();
        System.out.println(personList.size());
    }


    public static void testRemoveElement() {
        ArrayList<Integer> objects = new ArrayList<>();

        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);

        Iterator<Integer> iterator = objects.iterator();
        while (iterator.hasNext()) {
            Integer obj = iterator.next();
            if (obj.equals(2)) {
//                objects.remove(obj); //这样不行，因为它修改了modCount，但是没有修改Iterator中的exceptModCount
                iterator.remove();
            }
        }

        System.out.println(objects);
    }

    public static void testForEachRemaining() {
        ArrayList<Integer> objects = new ArrayList<>();

        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);

        Iterator<Integer> iterator = objects.iterator();
        //这个可以一定程度上取代while循环
//        iterator.forEachRemaining((e) -> System.out.println(e));
        iterator.forEachRemaining((e) -> e++);

        System.out.println(objects);
    }


    public static void testSubList() {
        ArrayList<Integer> objects = new ArrayList<>();

        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);

        List<Integer> integers = objects.subList(1, 3);
        integers.add(6);


        System.out.println(integers);
        System.out.println(objects);
    }


    public static void testRemoveIf() {
        ArrayList<Integer> objects = new ArrayList<>();

        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);

        objects.removeIf((i) -> i%2==0);
        System.out.println(objects);
    }

    public static void testSpliterator() {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            al.add(i);
        }
        Spliterator als_1 = al.spliterator();
//        System.out.print("als_1:");
//        als_1.forEachRemaining((e) -> System.out.print(e + ","));
        System.out.println("als_1:" + als_1);    // [0,11]

        System.out.println("---------split-----------");
        Spliterator als_2 = als_1.trySplit();
        System.out.println("als_1:" + als_1);    // [5,11]
        System.out.println("als_2:" + als_2);    // [0,5]

        // [0,11](als_1) ---> [0,5](als_2) + [5,11](als_1)

        System.out.println("---------split-----------");
        Spliterator als_3 = als_1.trySplit();
        Spliterator als_4 = als_2.trySplit();
        System.out.println("als_1:" + als_1);
        System.out.println("als_2:" + als_2);
        System.out.println("als_3:" + als_3);
        System.out.println("als_4:" + als_4);

        /**
         * [0,5](als_2)  --> [0,2](als_4)  + [2,5](als_2)
         * [5,11](als_1) --> [8,11](als_1) + [5,8](als_3)
         */

        System.out.println("---------test the address---------");
        System.out.println("(als_1.list == als_2.list) = " + (als_1.characteristics() == als_2.characteristics()));
        System.out.println("(als_2.list == als_3.list) = " + (als_2.characteristics() == als_3.characteristics()));
        System.out.println("(als_3.list == als_4.list) = " + (als_3.characteristics() == als_4.characteristics()));
    }
}
