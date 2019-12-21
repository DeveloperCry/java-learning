package learning.factory.methodfactory.support;

import learning.factory.methodfactory.Book;

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
