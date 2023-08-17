class Multithread1 extends Thread{
    private int threadNumber;
    public Multithread1(int threadNumber){
        this.threadNumber = threadNumber;
    }

    @Override
    public void run(){
        for(int i = 0 ; i < 5 ; i++){
            System.out.println(i + " From Thread threadNumber: " + threadNumber);
            try{
                Thread.sleep(1000);
            } catch(Exception e){
                System.out.print(e);
            }
        }
    }
}

class Multithread2 implements Runnable{
    private int threadNumber;
    public Multithread2(int threadNumber){
        this.threadNumber = threadNumber;
    }

    @Override
    public void run(){
        for(int i = 0 ; i < 5 ; i ++){
            System.out.println(i + " From thread threadNumber: " + threadNumber);
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.print(e);
            }
        }
    }
}

public class Multithreading{
    public static void main(String []args){

        System.out.println("\nExample of Extending thread\n");

        for(int i = 0 ; i < 5 ; i ++)
            (new Multithread1(i)).start();

        System.out.println("\nExample of Implemanting Runnnable\n");
        for(int i = 0 ; i < 5 ; i ++)
            (new Thread(new Multithread2(i))).start();
    }
}