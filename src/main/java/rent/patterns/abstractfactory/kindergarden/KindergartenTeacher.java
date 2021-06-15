package rent.patterns.abstractfactory.kindergarden;

import rent.patterns.abstractfactory.entity.Teacher;

public class KindergartenTeacher implements Teacher {
    @Override
    public void work() {
        System.out.println("Kindergarten teacher.");
    }
}