package rent.patterns.abstractfactory.kindergarden;

import rent.patterns.abstractfactory.entity.AbstractFactory;
import rent.patterns.abstractfactory.entity.Librarian;
import rent.patterns.abstractfactory.entity.Manager;
import rent.patterns.abstractfactory.entity.Teacher;

public class KindergartenFactory implements AbstractFactory {
    @Override
    public Librarian getLibrarian() {
        return new KindergartenLibrarian();
    }

    @Override
    public Teacher getTeacher() {
        return new KindergartenTeacher();
    }

    @Override
    public Manager getManager() {
        return new KindergartenManager();
    }
}
