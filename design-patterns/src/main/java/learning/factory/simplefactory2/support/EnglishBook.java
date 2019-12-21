package learning.factory.simplefactory2.support;

import learning.factory.simplefactory2.Book;

public class EnglishBook implements Book {
    @Override
    public void context() {
        System.out.println("这是英语书");
    }

    @Override
    public void read() {
        System.out.println("开始阅读英语书");
    }
}
