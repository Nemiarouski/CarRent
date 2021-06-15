package rent.patterns.builder;

public class Director {
    EmployeeBuilder builder;

    public void setBuilder(EmployeeBuilder builder) {
        this.builder = builder;
    }

    Employee buildEmployee() {
        builder.createEmployee();
        builder.buildName();
        builder.buildAge();
        builder.buildPosition();

        Employee employee = builder.getEmployee();
        return employee;
    }
}