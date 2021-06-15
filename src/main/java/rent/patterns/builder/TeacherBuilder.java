package rent.patterns.builder;

public class TeacherBuilder extends EmployeeBuilder{

    @Override
    void buildName() {
        employee.setName("Teacher.");
    }

    @Override
    void buildAge() {
        employee.setAge(25);
    }

    @Override
    void buildPosition() {
        employee.setPosition(Position.TEACHER);
    }
}