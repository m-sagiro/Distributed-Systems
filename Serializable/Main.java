package Serializable; /* Importiert die Klassen mit*/

public class Main {
    public static void main(String[] args) {

        Publication publication[] = new Publication[3];

        publication[0] = new Publication(
                "book1",
                "DE",
                (float) 5.99);
        publication[1] = new Book(
                "book2",
                "EN",
                (float) 6.95,
                "thomas",
                "234-523232"
        );
        publication[2] = new Publication(
                "book3",
                "FR",
                (float) 12.99
        );

        for(Publication publication1: publication){
            publication1.print();
        }
    }
}
