class Gp
{
    String bg ="A+";
    int age=50;

    public Gp()
    {
        System.out.println("GrandParent Constructor");
    }

    public Gp(String bg, int age)
    {
        this();
        this.bg = bg;
        this.age = age;

    }

    void walk()
    {

        System.out.println("walk");
    }

    void display(String bg)
    {
        System.out.println("Blood group"+ bg);
        System.out.println("Age"+age);
        //System.out.println("Donate blood group"+dg);
    }

}

class Parent extends Gp
{
    String name="Harsh";
    int age=45;

    public Parent()
    {
        super("A+",50);
        System.out.println("PArent Constructor");
    }

    public Parent(String name, int age)
    {
        this();
        this.name = name;
        this.age=age;

    }

    void display()
    {
        super.walk();
        super.display(super.bg);
        ParentDetails();
        System.out.println("GrandParent details:");
    }

    void ParentDetails()
    {
        System.out.println("Name is"+name);
        System.out.println("Age"+age);
    }


}

class Child extends Parent {

    String name="jai";
    int age=8;



    public Child()
    {
        super("Surbhi",35);
        System.out.println("Child Parent");
    }

    public Child(String name,int age)
    {
        this();
        this.age=age;
        this.name=name;
        this.childDisplay();
    }

    void childDisplay()
    {
        super.display();
        System.out.println("Child name"+name);
        result();
    }

    void result()
    {
        System.out.println("Result for donation");
    }

}



public class Multilevel{
public static void main(String [] args){
    Child c= new Child("Jai",8);
}
}
