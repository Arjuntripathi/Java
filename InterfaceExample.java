interface Display{
    final int a = 5;
    static int b = 10;

    default int sayHello(String arg){
        System.out.println("Hello "+arg);
        return 1;
    }

    static void sayHi(String arg){
        System.out.println("Hi "+arg);
    }
    
}

class InterfaceExample implements Display{
    public int sayHello(String []arg){
        System.out.print("Hello "+arg);
        return 2;
    }

    public static void main(String []args){
        System.out.println(a);
        System.out.println(b);
        InterfaceExample inf = new InterfaceExample();
        System.out.println(inf.sayHello("Arjun"));
        Display.sayHi("Arjun");
    }
}