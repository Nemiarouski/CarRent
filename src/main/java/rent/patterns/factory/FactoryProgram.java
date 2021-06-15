package rent.patterns.factory;

import rent.patterns.factory.entity.Employee;
import rent.patterns.factory.entityfactory.DoctorFactory;
import rent.patterns.factory.entityfactory.EmployeeFactory;
import rent.patterns.factory.entityfactory.EngineerFactory;
import rent.patterns.factory.entityfactory.TeacherFactory;

public class FactoryProgram {
    public static void main(String[] args) {
        EmployeeFactory employeeFactory = createEmployee("doctor");
        Employee employee = employeeFactory.createEmployee();

        employee.work();
    }

    static EmployeeFactory createEmployee(String profession){
        if (profession.equals("teacher")) {
            return new TeacherFactory();
        } else if (profession.equals("engineer")) {
            return new EngineerFactory();
        } else if (profession.equals("doctor")) {
            return new DoctorFactory();
        }else {
            throw new RuntimeException(profession + " is unknown profession.");
        }
    }
}