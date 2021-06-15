package rent.patterns.abstractfactory.kindergarden;

import rent.patterns.abstractfactory.entity.Librarian;

public class KindergartenLibrarian implements Librarian {
    @Override
    public void work() {
        System.out.println("Kindergarten librarian.");
    }
}