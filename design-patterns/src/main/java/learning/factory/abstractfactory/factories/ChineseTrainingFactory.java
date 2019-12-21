package learning.factory.abstractfactory.factories;

import learning.factory.abstractfactory.AbstractTrainingFactory;
import learning.factory.abstractfactory.Book;
import learning.factory.abstractfactory.Company;
import learning.factory.abstractfactory.Course;
import learning.factory.abstractfactory.support.book.ChineseBook;
import learning.factory.abstractfactory.support.company.ChineseCompany;
import learning.factory.abstractfactory.support.course.ChineseCourse;

public class ChineseTrainingFactory extends AbstractTrainingFactory {
    @Override
    public Book createBooK() {
        return new ChineseBook();
    }

    @Override
    public Company createCompany() {
        return new ChineseCompany();
    }

    @Override
    public Course createCourse() {
        return new ChineseCourse();
    }
}
