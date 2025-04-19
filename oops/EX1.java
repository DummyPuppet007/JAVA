class Pen {
   String color;
   String type;
   
   public void Write(){
    System.out.println("writing something");
   }

   public void printColor(){
    System.out.println(this.color); //this refers context
   }
}

class Student{
    String name;
    int age;

    public void info(){
        System.out.println(this.name);
        System.out.println(this.age);
    }
}

public class EX1 {
    public static void main(String[] args) {
        Pen pen1 = new Pen();
        Pen pen2 = new Pen();
        pen1.color = "Red";
        pen1.type = "Gel";
        pen2.color = "Blue";
        pen2.type = "Ballpoint";
        pen1.Write();
        pen1.printColor();
        pen2.printColor();
        Student s1 = new Student();
        s1.name = "Bhaumik";
        s1.age = 23;
        s1.info();
    }   
}


