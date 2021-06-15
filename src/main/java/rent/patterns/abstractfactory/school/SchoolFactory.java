package rent.patterns.abstractfactory.school;

import rent.patterns.abstractfactory.entity.AbstractFactory;
import rent.patterns.abstractfactory.entity.Librarian;
import rent.patterns.abstractfactory.entity.Manager;
import rent.patterns.abstractfactory.entity.Teacher;

public class SchoolFactory implements AbstractFactory {
    @Override
    public Librarian getLibrarian() {
        return new SchoolLibrarian();
    }

    @Override
    public Teacher getTeacher() {
        return new SchoolTeacher();
    }

    @Override
    public Manager getManager() {
        return new SchoolManager();
    }
}