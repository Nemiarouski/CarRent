package rent.patterns.composite;

public class Teacher implements Worker {
    @Override
    public void work() {
        System.out.println("Teacher");
    }
}