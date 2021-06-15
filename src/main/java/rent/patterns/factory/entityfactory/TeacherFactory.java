package rent.patterns.factory.entityfactory;

import rent.patterns.factory.entity.Employee;
import rent.patterns.factory.entity.Teacher;

public class TeacherFactory implements EmployeeFactory {
    @Override
    public Employee createEmployee() {
        return new Teacher();
    }
}