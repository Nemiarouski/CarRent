package rent.patterns.abstractfactory.school;

import rent.patterns.abstractfactory.entity.Teacher;

public class SchoolTeacher implements Teacher {
    @Override
    public void work() {
        System.out.println("School teacher.");
    }
}