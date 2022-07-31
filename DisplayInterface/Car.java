package DisplayInterface;

public class Car implements Display{
    private String colour;
    private int horsepower;
    private float weight;

    public Car(String colour, int horsepower, float weight){
        this.colour = colour;
        this.horsepower = horsepower;
        this.weight = weight;
    }

    public void print(){
        System.out.println();
        System.out.print("Colour: " + colour + "\n" +
                            "Horsepower: " + horsepower + "\n" +
                            "Weight: " + weight + "\n");
    }

    public static void main(String[] args) {

    }
}
