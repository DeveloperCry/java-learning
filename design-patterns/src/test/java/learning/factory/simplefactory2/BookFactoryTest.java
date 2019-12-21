package learning.factory.simplefactory2;

import learning.factory.simplefactory2.support.ChineseBook;
import learning.factory.simplefactory2.support.EnglishBook;
import learning.factory.simplefactory2.support.MathBook;
import org.junit.Test;

public class BookFactoryTest {
    @Test
    public void testCreateFactory() {
        BookFactory factory = new BookFactory();

        Book chineseBook = factory.createBook(ChineseBook.class);
        chineseBook.context();
        chineseBook.read();

        Book mathBook = factory.createBook(MathBook.class);
        mathBook.context();
        mathBook.read();

        Book englishBook = factory.createBook(EnglishBook.class);
        englishBook.context();
        englishBook.read();
    }
}
