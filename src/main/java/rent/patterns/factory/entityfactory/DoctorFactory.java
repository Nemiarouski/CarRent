package rent.patterns.factory.entityfactory;

import rent.patterns.factory.entity.Employee;
import rent.patterns.factory.entity.Doctor;

public class DoctorFactory implements EmployeeFactory {
    @Override
    public Employee createEmployee() {
        return new Doctor();
    }
}
