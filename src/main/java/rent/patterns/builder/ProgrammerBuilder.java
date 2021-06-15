package rent.patterns.builder;

public class ProgrammerBuilder extends EmployeeBuilder {
    @Override
    void buildName() {
        employee.setName("Programmer.");
    }

    @Override
    void buildAge() {
        employee.setAge(30);
    }

    @Override
    void buildPosition() {
        employee.setPosition(Position.PROGRAMMER);
    }
}
