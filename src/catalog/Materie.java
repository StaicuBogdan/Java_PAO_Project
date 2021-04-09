package catalog;

public class Materie {
    private String numeMaterie;
    private Profesor profesor;

    public Materie(String numeMaterie, Profesor profesor) {
        this.numeMaterie = numeMaterie;
        this.profesor = profesor;
    }

    public String getNumeMaterie() {
        return numeMaterie;
    }

    public Profesor getProfesor() {
        return profesor;
    }
}
