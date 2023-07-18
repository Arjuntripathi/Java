import java.lang.Thread;

class Mythread1 implements Runnable {
    public void run(){
        while(true){
            System.out.println("hello");
        }
    }
}

class Mythread2 extends Thread {
    public void run(){
        while(true){
            System.out.println("world");
        }
    }
}

public class Threading{

    public static void main(String[]args){
        // using thread as a superclass
        Mythread2 mt2 = new Mythread2();
        mt2.start();

        // using runnable interface
        Mythread1 mt1 = new Mythread1();
        Thread t = new Thread(mt1);
        t.start();
    }
}