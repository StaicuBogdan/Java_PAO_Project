package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String grupa;
    private List<Student> studenti = new ArrayList<>();
    private List<Materie> materii = new ArrayList<>();

    public Catalog(String grupa) {
        this.grupa = grupa;
    }

    public void adauga_student(Student student){
        studenti.add(student);
    }

    public void adauga_materie(Materie materie){
        materii.add(materie);
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public int getStudenti_size(){
        return studenti.size();
    }

    public String getGrupa() {
        return grupa;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "studenti=" + studenti +
                ", materii=" + materii +
                '}';
    }
}
