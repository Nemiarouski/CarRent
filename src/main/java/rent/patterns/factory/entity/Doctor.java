package rent.patterns.factory.entity;

public class Doctor implements Employee {
    @Override
    public void work() {
        System.out.println("I am a doctor.");
    }
}
