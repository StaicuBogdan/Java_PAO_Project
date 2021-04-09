import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean end = false;
        Service service = new Service();

        while (!end){
            System.out.println("Insert command: ");
            String commanda = in.nextLine().toLowerCase(Locale.ROOT);
            try{
                switch (commanda) {
                    case "new_catalog" -> service.new_catalog(in);
                    case "new_profesor" -> service.new_profesor(in);
                    case "new_materie" -> service.new_materie(in);
                    case "new_student" -> service.new_student(in);
                    case "adauga_student_in_clasa" -> service.adauga_student_in_clasa(in);
                    case "adauga_materie_in_clasa" -> service.adauga_materie_in_clasa(in);
                    case "afisare_note_student" -> service.note_student(in);
                    case "afisare_note_student_materie" -> service.note_student_materie(in);
                    case "adauga_nota_student" -> service.adauga_nota_student(in);
                    case "afisare_studenti_grupa" -> service.afisare_studenti_grupa(in);
                    case "nr_studenti" -> service.nr_studenti(in);
                    case "mdeie_student" -> service.medie_student(in);
                    case "end" -> end = true;
                }
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }
}