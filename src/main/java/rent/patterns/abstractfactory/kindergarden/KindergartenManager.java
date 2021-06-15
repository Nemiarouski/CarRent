package rent.patterns.abstractfactory.kindergarden;

import rent.patterns.abstractfactory.entity.Manager;

public class KindergartenManager implements Manager {
    @Override
    public void work() {
        System.out.println("Kindergarten manager.");
    }
}