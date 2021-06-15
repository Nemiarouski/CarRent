package rent.patterns.builder;

public abstract class EmployeeBuilder {
    Employee employee;

    void createEmployee() {
        employee = new Employee();
    }

    abstract void buildName();
    abstract void buildAge();
    abstract void buildPosition();

    Employee getEmployee() {
        return employee;
    }
}