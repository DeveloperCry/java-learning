package learning.factory.methodfactory.factories;

import learning.factory.methodfactory.AbstractBookFactory;
import learning.factory.methodfactory.Book;
import learning.factory.methodfactory.support.EnglishBook;

public class EnglishBookFactory extends AbstractBookFactory {
    @Override
    public Book createBooK() {
        return new EnglishBook();
    }
}
