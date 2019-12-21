package learning.factory.simplefactory;

import learning.factory.simplefactory.support.ChineseBook;
import learning.factory.simplefactory.support.EnglishBook;
import learning.factory.simplefactory.support.MathBook;

/**
 * 简单工厂方法
 * 这种工厂模式看起来会很烦躁，加入要生产很多的东西，就会看起来很臃肿，同时还会修改factory类，不符合开闭原则；
 * 假如生产了集中不同概念的东西，就不符合单一原则
 * 如果要写成静态的工厂方法，那么在每个方法前添加一个static即可
 */
public class BookFactory {
    public EnglishBook createEnglishBook() {
        //do something before
        EnglishBook book = new EnglishBook();
        //do something after
        return book;
    }

    public ChineseBook createChineseBook() {
        //do something before
        ChineseBook book = new ChineseBook();
        //do something after
        return book;
    }

    public MathBook createMathBook() {
        //do something before
        MathBook book = new MathBook();
        //do something after
        return book;
    }
}
