package learning.factory.abstractfactory.support.course;

import learning.factory.abstractfactory.Course;

public class MathCourse implements Course {
    @Override
    public void teach() {
        System.out.println("我是数学课");
    }
}
