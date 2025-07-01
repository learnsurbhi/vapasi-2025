//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        String LOGO="MAC";
        Processor p1=new Processor("5gen",60);
        RAM r1=new RAM(300,"6Gen");
        HDD h1= new HDD(100,"HardDrive");

        Processor p2=new Processor("7Gen",50);
        RAM r2= new RAM(200,"5gen");
        HDD h2=new HDD(300,"SSD");

        Laptop l1=new Laptop(p1,r1,h1);
        Laptop l2=new Laptop(p2,r2,h2);

        l1.setRam(r1);
        l1.setHdd(h1);
        l1.setProc(p1);
        l2.setProc(p2);
        l2.setHdd(h2);
        l2.setRam(r2);

        System.out.println("Logo for issued laptop is"+LOGO);
        System.out.println("First issued laptop details"+l1);
        System.out.println("Second issued laptop details"+l2);



    }
}