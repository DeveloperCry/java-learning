package learning.factory.abstractfactory.support.company;

import learning.factory.abstractfactory.Company;

public class EnglishCompany implements Company {
    @Override
    public void produce() {
        System.out.println("我在生产英语书籍");
    }
}
