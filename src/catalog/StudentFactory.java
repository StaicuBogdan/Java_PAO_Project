package catalog;

public class StudentFactory {
    private static int id = 0;

    public Student createStudent(String name, int age){
        return new Student(id++, name, age);
    }
}
