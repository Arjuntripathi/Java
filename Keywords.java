/*
    Important key-words in java with information

    1. this - this keyword is used to refer current object in method or constructor. The most common word of this keyword is to eliminate the confusion of
              class atribute and parameter at same name.
    
    2. static - static keyword mainly used for memory management. It is used to share same variable and method to given class

 */

class ThisExample{
    int num = 1;
    public ThisExample(){
        System.out.println("inside constructer");
    }

    public ThisExample(int num){
        this();
        this.num = num;
    }
    
    public void display(){
        System.out.println("num: "+num);
    }
    
    public void show(){
        this.display();
    }
}


public class Keywords{
    public static void main(String []args){
        ThisExample t = new ThisExample();

        ThisExample t2 = new ThisExample(5);

        t.show();

        t2.display();
    }
}