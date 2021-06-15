package rent.patterns.builder;

public class BuilderProgram {
    public static void main(String[] args) {
        Director director = new Director();

        director.setBuilder(new ProgrammerBuilder());

        Employee employee = director.buildEmployee();

        System.out.println(employee);

    }
}