package Serializable;

import DisplayInterface.Display;

public class Publication implements Display {

    private String title;
    private String language;
    private float price;



    public Publication(String title, String language, float price){
        this.title = title;
        this.language = language;
        this.price = price;
    }

    public void print(){
        System.out.println();
        System.out.print("Book title: " + title +
                " Book language: " + language +
                " Book price: " + price);
    }

}
