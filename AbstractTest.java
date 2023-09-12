abstract class Shape{

    String color;

    abstract double area();

    public abstract String toString();

    public Shape(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius, String color){
        super(color);
        this.radius = radius;
        System.out.println("Circle Constructer Called . . .");
    }

    @Override double area(){
        return Math.PI * Math.pow(radius,2);
    }

    @Override public String toString(){
        return "Circle is color "+getColor()+" & Area is: "+area();
    }

}

public class AbstractTest{
    public static void main(String args[]){
        Shape c = new Circle(3.5, "RED");

        System.out.println(c.toString());
    }
}