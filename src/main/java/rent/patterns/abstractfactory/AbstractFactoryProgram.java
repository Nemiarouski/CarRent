package rent.patterns.abstractfactory;

import rent.patterns.abstractfactory.entity.AbstractFactory;
import rent.patterns.abstractfactory.entity.Librarian;
import rent.patterns.abstractfactory.entity.Manager;
import rent.patterns.abstractfactory.entity.Teacher;
import rent.patterns.abstractfactory.kindergarden.KindergartenFactory;

public class AbstractFactoryProgram {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new KindergartenFactory();
        Librarian librarian = abstractFactory.getLibrarian();
        Teacher teacher = abstractFactory.getTeacher();
        Manager manager = abstractFactory.getManager();

        System.out.println("School is working...");
        librarian.work();
        teacher.work();
        manager.work();
    }
}