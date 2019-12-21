package learning.factory.simplefactory2.support;

import learning.factory.simplefactory2.Book;

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
