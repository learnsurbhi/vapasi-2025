


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        String logo="MAC";
        Processor p1=new Processor("5gen",60);
        RAM r1=new RAM(300,"6Gen");
        HDD h1= new HDD(100,"HardDrive");

        Processor p2=new Processor("7Gen",50);
        RAM r2= new RAM(200,"5gen");
        HDD h2=new HDD(300,"SSD");

        Laptop l1=new Laptop(p1,r1,h1);
        Laptop l2=new Laptop(p2,r2,h2);

        l1.display();
        l2.display();




    }
}