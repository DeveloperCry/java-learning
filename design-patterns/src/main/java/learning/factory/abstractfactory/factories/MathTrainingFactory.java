package learning.factory.abstractfactory.factories;

import learning.factory.abstractfactory.AbstractTrainingFactory;
import learning.factory.abstractfactory.Book;
import learning.factory.abstractfactory.Company;
import learning.factory.abstractfactory.Course;
import learning.factory.abstractfactory.support.book.MathBook;
import learning.factory.abstractfactory.support.company.MathCompany;
import learning.factory.abstractfactory.support.course.MathCourse;

public class MathTrainingFactory extends AbstractTrainingFactory {
    @Override
    public Book createBooK() {
        return new MathBook();
    }

    @Override
    public Company createCompany() {
        return new MathCompany();
    }

    @Override
    public Course createCourse() {
        return new MathCourse();
    }
}
