package learning;

import learning.factory.SortFactory;
import learning.strategy.ISort;
import learning.type.SortType;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final int BOUND = 100;
    private static final int ARRAY_SIZE = 10;

    public static void main( String[] args )
    {
        ISort sort = SortFactory.createSort(SortType.HEAP);
        int[] data = getData(ARRAY_SIZE);
        sort.sort(data);
    }

    public static int[] getData(int num) {
        int index = 0;
        int[] data = new int[num];
        while (index < num) {
            Random random = new Random();
            int item = random.nextInt(BOUND);
            data[index] = item;
            index ++;
        }
        return data;
    }
}
