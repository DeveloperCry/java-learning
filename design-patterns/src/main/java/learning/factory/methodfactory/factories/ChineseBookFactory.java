package learning.factory.methodfactory.factories;

import learning.factory.methodfactory.AbstractBookFactory;
import learning.factory.methodfactory.Book;
import learning.factory.methodfactory.support.ChineseBook;

public class ChineseBookFactory extends AbstractBookFactory {
    @Override
    public Book createBooK() {
        return new ChineseBook();
    }
}
