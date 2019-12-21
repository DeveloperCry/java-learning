package learning.factory.abstractfactory.support.book;

import learning.factory.abstractfactory.Book;

public class MathBook implements Book {
    @Override
    public void context() {
        System.out.println("这是数学书");
    }

    @Override
    public void read() {
        System.out.println("开始阅读数学书");
    }
}
