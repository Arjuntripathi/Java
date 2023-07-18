/*
    Important key-words in java with information

    1. this - this keyword is used to refer current object in method or constructor. The most common word of this keyword is to eliminate the confusion of
              class atribute and parameter at same name.
    
    2. static - static keyword mainly used for memory management. It is used to share same variable and method to given class

 */

class thisExample{
    int num = 1;
    public thisExample(){
        System.out.println("inside constructer");
    }

    public thisExample(int num){
        this();
        this.num = num;
    }
    
    void display(){
        System.out.println("num: "+num);
    }
    
    void show(){
        this.display();
    }
}


public class Keywords{
    
}