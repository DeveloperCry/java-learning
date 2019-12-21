package learning.factory.abstractfactory.support.course;

import learning.factory.abstractfactory.Course;

public class EnglishCourse implements Course {
    @Override
    public void teach() {
        System.out.println("我是英语课");
    }
}
