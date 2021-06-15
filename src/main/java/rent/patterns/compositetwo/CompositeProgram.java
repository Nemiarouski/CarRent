package rent.patterns.compositetwo;

public class CompositeProgram {
    public static void main(String[] args) {
        Shape square = new Square();
        Shape triangle = new Triangle();
        Shape circle = new Circle();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();
        Composite composite3 = new Composite();

        composite.addComponent(square);
        composite1.addComponent(triangle);
        composite2.addComponent(circle);

        composite3.addComponent(composite);
        composite3.addComponent(composite1);
        composite3.addComponent(composite2);

        composite3.draw();
    }
}