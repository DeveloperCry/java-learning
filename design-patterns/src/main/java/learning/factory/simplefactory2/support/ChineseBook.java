package learning.factory.simplefactory2.support;

import learning.factory.simplefactory2.Book;

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
