package JavaThreads;

public class MyThread extends Thread{
    private int number;

    MyThread(int number){
        this.number = number;
    }

    public void run(){
        try {
            System.out.print(number + " ");
            sleep(3000);
            System.out.print(number + " ");
            sleep(3000);
            System.out.print(number + " ");
            sleep(3000);
            System.out.print(number + " ");
            sleep(3000);
            System.out.print(number + " ");
        }catch (Exception e) {
            System.out.println(e);
        }
    }

}
