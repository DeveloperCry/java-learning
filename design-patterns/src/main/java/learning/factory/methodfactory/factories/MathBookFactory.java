package learning.factory.methodfactory.factories;

import learning.factory.methodfactory.AbstractBookFactory;
import learning.factory.methodfactory.Book;
import learning.factory.methodfactory.support.MathBook;

public class MathBookFactory extends AbstractBookFactory {
    @Override
    public Book createBooK() {
        return new MathBook();
    }
}
