package learning.composite;

import org.junit.Test;

public class CompositeTest {
    @Test
    public void testComposite() {
        Category order = new Category();

        Category appliances = new Category();
        Leaf washingMachine = new Leaf(4000f);
        Leaf tv = new Leaf(3000f);

        appliances.add(washingMachine);
        appliances.add(tv);
        order.add(appliances);

        Category snacks = new Category();
        Category sugar = new Category();
        Category biscuits = new Category();

        Leaf chocolate = new Leaf(4.5f);
        sugar.add(chocolate);

        Leaf cookies = new Leaf(6.0f);
        biscuits.add(cookies);

        snacks.add(sugar);
        snacks.add(biscuits);

        order.add(snacks);

        appliances.remove(tv);

        System.out.println("总金额：" + order.getPrice());
    }
}
