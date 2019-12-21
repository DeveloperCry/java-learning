package learning.factory.abstractfactory;

import learning.factory.abstractfactory.factories.ChineseTrainingFactory;
import learning.factory.abstractfactory.factories.EnglishTrainingFactory;
import learning.factory.abstractfactory.factories.MathTrainingFactory;
import org.junit.Test;

public class BookFactoryTest {
    @Test
    public void testCreateFactory() {
        AbstractTrainingFactory factory = new ChineseTrainingFactory();
        Book chineseBook = factory.createBooK();
        Company chineseCompany = factory.createCompany();
        Course chineseCourse = factory.createCourse();
        chineseCompany.produce();
        chineseBook.context();
        chineseBook.read();
        chineseCourse.teach();

        factory = new MathTrainingFactory();
        Book mathBook = factory.createBooK();
        Company mathCompany = factory.createCompany();
        Course mathCourse = factory.createCourse();
        mathCompany.produce();
        mathBook.context();
        mathBook.read();
        mathCourse.teach();

        factory = new EnglishTrainingFactory();
        Book englishBook = factory.createBooK();
        Company englishCompany = factory.createCompany();
        Course englishCourse = factory.createCourse();
        englishCompany.produce();
        englishBook.context();
        englishBook.read();
        englishCourse.teach();
    }
}
