package InputOutputStream;

import Serializable.Book;
import Serializable.Publication;
import DisplayInterface.Car;
import DisplayInterface.Display;

import java.io.*;


public class Application {
    public static void main(String[] args) {

        //Erstellen der Objekte
        Display[] display = new Display[5];

        display[0] = new Book("book1", "de",
                (float) 9.95, "Henry", "234-55");
        display[1] = new Car("red", 119, (float) 1268.5);
        display[2] = new Publication("Koenigslaender",
                "en", (float) 6.96);
        display[3] = new Book("book2", "ne",
                (float) 19.99, "Thomas", "2-4-322");
        display[4] = new Car("blue", 179, (float) 2195.5);

        for(Display disp: display){
            disp.print();
        }

        //Try cath: Fehler müssen! abgefangen werden
        try {
            // "Aufgabe6/random.file"
            FileOutputStream fs = new FileOutputStream("random.file");
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(display);
            os.close();
            System.out.println("*****************************************************");
            System.out.println("File successfully written!");
            System.out.println("*****************************************************");
        }
        catch (IOException e){
            System.err.println(e.toString());
        }

        try {
            FileInputStream fs = new FileInputStream("random.file");
            ObjectInputStream os = new ObjectInputStream(fs);

            Display[] r_display = (Display[]) os.readObject();

            System.out.println("*****************************************************");
            System.out.println("Objects read");
            System.out.println("Object will be printed");
            System.out.println("*****************************************************");

            for(Display disp: r_display){
                disp.print();
            }


        }
        catch (ClassNotFoundException e){
            System.err.println(e.toString());
        }
        catch (IOException e){
            System.err.println(e.toString());
        }

    }
}
