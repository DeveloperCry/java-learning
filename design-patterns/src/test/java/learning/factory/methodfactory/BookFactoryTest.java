package learning.factory.methodfactory;

import learning.factory.methodfactory.factories.ChineseBookFactory;
import learning.factory.methodfactory.factories.EnglishBookFactory;
import org.junit.Test;

public class BookFactoryTest {
    @Test
    public void testCreateFactory() {
        AbstractBookFactory factory = new ChineseBookFactory();
        Book chineseBook = factory.createBooK();
        chineseBook.context();
        chineseBook.read();

        factory = new EnglishBookFactory();
        Book mathBook = factory.createBooK();
        mathBook.context();
        mathBook.read();

        factory = new ChineseBookFactory();
        Book englishBook = factory.createBooK();
        englishBook.context();
        englishBook.read();
    }
}
