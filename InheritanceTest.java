class Car{
    public Car(){
        System.out.println("Hello from car");
    }
}

class Maruti extends Car{
    public Maruti(){
        super();
        System.out.println("Hello from maruti");
    }
}

class Swift extends Maruti{
    public Swift(){
        super();
        System.out.println("Hello from Swift");
    }
}

class InheritanceTest{
    public static void main(String []args){
        // Car c = new Car();
        // Maruti m = new Maruti();
        Car s = new Swift();
    }
}