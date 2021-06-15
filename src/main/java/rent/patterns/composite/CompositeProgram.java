package rent.patterns.composite;

public class CompositeProgram {
    public static void main(String[] args) {
        City city = new City();

        Worker teacher = new Teacher();
        Worker engineer = new Engineer();
        Worker mathTeacher = new Teacher();

        city.addWorker(teacher);
        city.addWorker(engineer);
        city.addWorker(mathTeacher);

        city.createWork();
    }
}