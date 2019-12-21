package learning.factory.simplefactory;

import learning.factory.simplefactory.support.ChineseBook;
import learning.factory.simplefactory.support.EnglishBook;
import learning.factory.simplefactory.support.MathBook;
import org.junit.Test;

public class BookFactoryTest {
    @Test
    public void testCreateFactory() {
        BookFactory factory = new BookFactory();
        ChineseBook chineseBook = factory.createChineseBook();
        chineseBook.context();
        MathBook mathBook = factory.createMathBook();
        mathBook.context();
        EnglishBook englishBook = factory.createEnglishBook();
        englishBook.context();
    }
}
