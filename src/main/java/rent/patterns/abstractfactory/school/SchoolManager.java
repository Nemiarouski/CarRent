package rent.patterns.abstractfactory.school;

import rent.patterns.abstractfactory.entity.Manager;

public class SchoolManager implements Manager {
    @Override
    public void work() {
        System.out.println("School manager.");
    }
}