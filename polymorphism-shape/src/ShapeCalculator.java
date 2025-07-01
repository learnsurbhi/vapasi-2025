import java.util.ArrayList;

abstract class Shape {


    public abstract double calArea();
    public abstract double calPeri();

}
 class Circle extends Shape
 {
     double radius;
     //double area;
     //double per;

     public Circle(double radius) {
         this.radius = radius;

     }


     public double calArea() {
         //area= 3.14 *radius*radius;
         //System.out.println("Area of circle is: "+area);
         return Math.PI*radius*radius;
     }

     @Override
     public double calPeri() {
         return 2*Math.PI*radius;
     }
 }


class Rectangle extends Shape
 {
     double length;
     double breadth;
     double s;
     //double area;
     //double per;
     public Rectangle(){}

     public Rectangle(double length, double breadth) {
         this.length = length;
         this.breadth = breadth;
         //this.s= s;
     }

     void setDimensions(double l,double b)
     {
         length=l;
         breadth=b;
     }

     void setDimensions(double s){
         length=s;
         breadth=s;
     }

     @Override
     public double calArea()
     {
         return length*breadth;
     }

     @Override
     public double calPeri()
     {
         return 2*length*breadth;
     }
 }

 class Triangle extends Shape
 {
     double side1;
     double side2;
     double side3;

     public Triangle(double side1, double side2, double side3) {
         this.side1 = side1;
         this.side2 = side2;
         this.side3 = side3;

     }


     @Override
     public double calPeri() {
         return side1+side2+side3;
     }

     public double calArea()
     {
        double s=(side2+side1+side3)/2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
     }
 }

 public class ShapeCalculator
 {
    public static void main(String [] args)
    {
      Circle c= new Circle(3.8);
      Rectangle r= new Rectangle(3.45,5.67);
      Triangle t=new Triangle(3.21,4.56,6.78);
      Rectangle r2= new Rectangle();
      r2.setDimensions(4.59);

      ArrayList<Shape> shapes= new ArrayList<>();

      shapes.add(c);
      shapes.add(r);
      shapes.add(t);
      shapes.add(r2);

      for(Shape s : shapes){
          System.out.println("Area : " + s.calArea());
          System.out.println("Peri :"+s.calPeri());
      }

    }

 }