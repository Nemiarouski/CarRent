package rent.patterns.factory.entity;

public class Engineer implements Employee {
    @Override
    public void work() {
        System.out.println("I am an Engineer.");
    }
}