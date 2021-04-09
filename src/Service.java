import catalog.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Service {
    private List<Catalog> catalogs = new ArrayList<>();
    private List<Profesor> profesori = new ArrayList<>();
    private List<Materie> materii = new ArrayList<>();
    private List<Student> studenti = new ArrayList<>();
    private final StudentFactory studentFactory = new StudentFactory();


    public List<Catalog> getCatalogs(){
        return catalogs;
    }

    public void new_catalog(Scanner in){
        System.out.println("Dati numele grupei: ");
        var grupa = in.nextLine();
        Catalog catalog = new Catalog(grupa);
        this.catalogs.add(catalog);
    }

    public void new_profesor(Scanner in){
        System.out.println("Dati numele profesorului: ");
        var nume = in.nextLine();
        Profesor p = new Profesor(nume);
        profesori.add(p);
    }

    public void new_materie(Scanner in){
        System.out.println("Dati numele materiei: ");
        var materie= in.nextLine();
        System.out.println("Dati numele profesorului care preda materia: ");
        var prof = in.nextLine();
        int sem = 0;
        for(int i =0; i <= profesori.size()-1;i++){
            if(profesori.get(i).getName().equals(prof)){
                sem = 1;
                Materie m = new Materie(materie, profesori.get(i));
                materii.add(m);
            }
        }
    }

    public void new_student(Scanner in){
        System.out.println("Numele studentului: ");
        var nume = in.nextLine();
        System.out.println("Varsta: ");
        var varsta = in.nextInt();
        Student  s = new StudentFactory().createStudent(nume, varsta);
        studenti.add(s);
    }

    public void adauga_student_in_clasa(Scanner in){
        System.out.println("Grupa in care sa fie adaugat:");
        var grupa = in.nextLine();
        System.out.println("Numele studentului:");
        var nume= in.nextLine();

        for(Catalog c : catalogs){
            if(c.getGrupa().equals(grupa)){
                for(Student s: studenti){
                    if(s.getName().equals(nume)){
                        if(s.getGrupa().equals("faraGrupa")) {
                            c.adauga_student(s);
                            s.setGrupa(grupa);
                            break;
                        }
                        else {
                            System.out.println("Studentul se afla deja intr-o grupa, mai exact " + s.getGrupa());
                            break;
                        }
                    }
                }
            }
        }
    }

    public void adauga_materie_in_clasa(Scanner in){
        System.out.println("Grupa in care sa fie adaugat:");
        var grupa = in.nextLine();
        System.out.println("Numele materiei:");
        var nume= in.nextLine();

        for(Catalog c: catalogs){
            if(c.getGrupa().equals(grupa)){
                for(Materie m: materii){
                    if(m.getNumeMaterie().equals(nume)){
                        c.adauga_materie(m);
                        break;
                    }
                }
            }
        }
    }

    public void note_student(Scanner in){
        System.out.println("Numele studentului: ");
        var nume = in.nextLine();
        for(Catalog c : catalogs){
            for(Student s: c.getStudenti()){
                if(s.getName().equals(nume)){
                    s.afiseazaNote();
                    break;
                }
            }
        }
    }

    public void note_student_materie(Scanner in){
        System.out.println("Numele studentului: ");
        var nume = in.nextLine();
        System.out.println("Materia: ");
        var materie = in.nextLine();

        for(Catalog c : catalogs){
            for(Student s: c.getStudenti()){
                if(s.getName().equals(nume)){
                    int sem=0;
                    for(Map.Entry<String , List<Integer>> entry : s.getNote().entrySet()){
                        if(entry.getKey().equals(materie)){
                            System.out.println(entry.getValue());
                            sem=1;
                            break;
                        }
                    }
                    if(sem==0){
                        System.out.println("Studentul nu are note la materia "+materie);
                    }
                    break;
                }
            }
        }
    }

    public void adauga_nota_student(Scanner in){
        System.out.println("Numele studentului: ");
        var nume = in.nextLine();
        System.out.println("Materia: ");
        var materie = in.nextLine();
        System.out.println("Nota: ");
        var nota = in.nextInt();

        for(Catalog c: catalogs){
            for(Student s: c.getStudenti()){
                s.adauga_nota(nota, materie);
            }
        }
    }

    public void afisare_studenti_grupa(Scanner in){
        System.out.print("Grupa: ");
        var grupa = in.nextLine();
        for(Catalog c : catalogs){
            if(c.getGrupa().equals(grupa)){
                for(Student s : c.getStudenti()){
                    System.out.println(s.toString());
                }
            }
        }
    }

    public void nr_studenti(Scanner in){
        int suma =0;
        for(Catalog c : catalogs){
            suma += c.getStudenti_size();
        }
        System.out.println(suma);
    }

    public void medie_student(Scanner in){
        System.out.println("Dati numele studentului:");
        var nume = in.nextLine();
        for(Catalog c: catalogs){
            for(Student s: c.getStudenti()){
                if(s.getName().equals(nume)){
                    System.out.println(s.getMedie());
                    break;
                }
            }
        }
    }


}
