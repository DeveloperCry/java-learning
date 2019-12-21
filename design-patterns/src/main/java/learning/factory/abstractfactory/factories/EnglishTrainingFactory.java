package learning.factory.abstractfactory.factories;

import learning.factory.abstractfactory.AbstractTrainingFactory;
import learning.factory.abstractfactory.Book;
import learning.factory.abstractfactory.Company;
import learning.factory.abstractfactory.Course;
import learning.factory.abstractfactory.support.book.EnglishBook;
import learning.factory.abstractfactory.support.company.EnglishCompany;
import learning.factory.abstractfactory.support.course.EnglishCourse;

public class EnglishTrainingFactory extends AbstractTrainingFactory {
    @Override
    public Book createBooK() {
        return new EnglishBook();
    }

    @Override
    public Company createCompany() {
        return new EnglishCompany();
    }

    @Override
    public Course createCourse() {
        return new EnglishCourse();
    }
}
