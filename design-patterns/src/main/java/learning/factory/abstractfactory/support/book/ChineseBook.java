package learning.factory.abstractfactory.support.book;

import learning.factory.abstractfactory.Book;

public class ChineseBook implements Book {
    @Override
    public void context() {
        System.out.println("这是语文书");
    }

    @Override
    public void read() {
        System.out.println("开始阅读语文书");
    }
}
