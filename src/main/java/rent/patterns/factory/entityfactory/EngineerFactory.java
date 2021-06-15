package rent.patterns.factory.entityfactory;

import rent.patterns.factory.entity.Employee;
import rent.patterns.factory.entity.Engineer;

public class EngineerFactory implements EmployeeFactory {
    @Override
    public Employee createEmployee() {
        return new Engineer();
    }
}