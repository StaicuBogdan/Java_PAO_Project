import model.*;
import service.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Please type one of the following commands: create, get, get total amount, exit");
            String line = scanner.nextLine();
            switch(line) {
                case "create" : {
                    addStudent(studentService, scanner);
                    break;
                }
                case "get" : {
                    Optional<Student> student =
                            studentService.getStudentId(Integer.valueOf(scanner.nextLine()));
                    if(student.isPresent()) {
                        System.out.println(student.get());
                    }
                    break;
                }
                case "exit" : {
                    System.out.println("Bye...");
                    System.exit(0);
                }
                default : System.out.println("This command doesn't exist.");
            }
        }
    }

    private static void addStudent(StudentService studentService, Scanner scanner) {

        System.out.println("Please specify the student details: nume/age/medie");
        try {
            Student student = studentService.build(scanner.nextLine());
            studentService.addStudent(student);
        } catch (NumberFormatException e) {
            System.out.println("Invalid inputs for student creation. The student was not saved in the db.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough inputs for student creation. The student was not saved in the db.");
        }
    }
}
