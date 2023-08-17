// Method Overloading

class Operation{
    static int Add(int ...args){
        int sum = 0;
        for(int arg : args)
            sum += arg;
        return sum;
    }

    static double Add(double ...args){
        double sum = 0;
        for(double arg : args)
            sum += arg;
        return sum;
    }
}

// Method Overriding

class Parant{
    void print(){
        System.out.println("I'm Parant");
    }
}

class Child1 extends Parant{
    @Override void print(){
        System.out.println("I'm Child1");
    }
}

class Child2 extends Parant{
    @Override void print(){
        System.out.println("I'm Child2");
    }
}

public class PolymorphismTest{
    public static void main(String args[]){
        System.out.println("------------------------------------------------");
        System.out.println("Polymorphism testing . . . \n");

        // Method Overloading
        System.out.println("1.) Method Overloading Example . . . ");
        System.out.println("Adding 1,2,3,4,5 : " + Operation.Add(1,2,3,4,5));
        System.out.println("Adding 1.234,2.14,3,4.7,5.98 : " + Operation.Add(1.234,2.14,3,4.7,5.98));


        // Method Overriding
        System.out.println("\n2.) Method Overriding Example . . . ");
        Parant a;
        a = new Parant();
        a.print();

        a = new Child1();
        a.print();

        a = new Child2();
        a.print();
        System.out.println("------------------------------------------------");

    }
}