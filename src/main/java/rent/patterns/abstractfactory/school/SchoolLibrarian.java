package rent.patterns.abstractfactory.school;

import rent.patterns.abstractfactory.entity.Librarian;

public class SchoolLibrarian implements Librarian {
    @Override
    public void work() {
        System.out.println("School librarian.");
    }
}