package rent.clone;

public class Student implements Cloneable {
    int id;
    String name;
    Course course;

    public Student(int id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    protected Object clone() throws CloneNotSupportedException
    {
        Student student = (Student) super.clone();
        student.course = (Course) course.clone();
        return student;
    }
}