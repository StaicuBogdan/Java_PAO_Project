package model;

public class Student {
    private int id;
    private String name;
    private int age;
    private double medie;
    public Student() {
    }

    public Student(String name, int age, double medie) {
        this.name = name;
        this.age = age;
        this.medie = medie;
    }

    public Student(int id, String name, int age, double medie) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.medie = medie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        this.medie = medie;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", medie=" + medie +
                '}';
    }
}
