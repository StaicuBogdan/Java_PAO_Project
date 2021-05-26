package service;

import model.*;
import repository.*;

import java.util.*;

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService() {
        this.studentRepository = new StudentRepository();
    }

    public Student build(String studentDetails) {
        String[] attributes = studentDetails.split("/");
        String nume = attributes[0];
        int age = Integer.valueOf(attributes[1]);
        double medie = Double.valueOf(attributes[2]);
        return new Student(nume, age, medie);
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public Optional<Student> getStudentId(int id) {
        return studentRepository.getStudentById(id);
    }

}