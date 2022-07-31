package Serializable;

public class Book extends Publication{
    private String author;
    private String ISBN;


    public Book(String title, String language, float price,
                String author, String ISBN) {

        super(title, language, price);
        this.author = author;
        this.ISBN = ISBN;
    }

    public void print(){
        System.out.println();
        super.print();
        System.out.print(" Book author: " + author +
                " Book ISBN: " + ISBN);
    }
}
