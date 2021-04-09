package catalog;

import java.util.*;

public class Student {
    private final int id;
    private String name;
    private int age;
    private String grupa;
    private Map<String , List<Integer>> note = new HashMap<>();

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grupa="faraGrupa";
    }

    public void afiseazaNote(){
        System.out.print("Studentul "+ this.name);
        for(Map.Entry<String , List<Integer>> entry: note.entrySet()){
            System.out.println(" are notele " + entry.getValue() + " la materia " + entry.getKey());
        }
    }

    public void adauga_nota(Integer i, String materie){
        if(!note.containsKey(materie)){
            List<Integer> nota = new ArrayList<>();
            nota.add(i);
            note.put(materie, nota);
        }
        else{
            note.get(materie).add(i);
        }
    }

    public double getMedie(){
        if(note.isEmpty()){
            return 0;
        }
        double suma = 0, nr = 0;

        for(Map.Entry<String , List<Integer>> entry : note.entrySet()){
            for(int i =0; i<= entry.getValue().size()-1;i++){
                suma += entry.getValue().get(i);
                nr++;
            }
        }
        return suma/nr;
    }

    public int getId() {
        return id;
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

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public Map<String, List<Integer>> getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name) && Objects.equals(grupa, student.grupa) && Objects.equals(note, student.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, grupa, note);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
