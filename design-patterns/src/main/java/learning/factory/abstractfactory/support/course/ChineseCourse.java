package learning.factory.abstractfactory.support.course;

import learning.factory.abstractfactory.Course;

public class ChineseCourse implements Course {
    @Override
    public void teach() {
        System.out.println("我是中文课");
    }
}
