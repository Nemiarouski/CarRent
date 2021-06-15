package rent.patterns.composite;

public class CompositeProgram {
    public static void main(String[] args) {
        City city = new City();
        City city1 = new City();
        City city2 = new City();

        Worker teacher = new Teacher();
        Worker engineer = new Engineer();
        Worker mathTeacher = new Teacher();

        city.addWorker(teacher);
        city1.addWorker(engineer);
        city1.addWorker(mathTeacher);

        city2.addWorker(city);
        city2.addWorker(city1);
        city2.work();
    }
}