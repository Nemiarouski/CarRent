package rent.patterns.factory.entity;

public class Teacher implements Employee {
    @Override
    public void work() {
        System.out.println("I am a teacher.");
    }
}