package learning.factory.abstractfactory.support.company;

import learning.factory.abstractfactory.Company;

public class MathCompany implements Company {
    @Override
    public void produce() {
        System.out.println("我在生产数学书籍");
    }
}
