//non-parameterised constructor
class Student{
    String name;
    int age;

    public void info(){
        System.out.println(this.name);
        System.out.println(this.age);
    }

    Student(){
        System.out.println("Constructor Called.");
    }
}

//parameterised constructor
class Mark{
    String subject;
    int mark;

    Mark(String subject, int mark){
        this.subject = subject;
        this.mark = mark;
    }

    public void result(){
        System.out.println("Student get " + this.mark + " in " +this.subject);
    }
}

public class constructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Bhaumik";
        s1.age = 23;
        s1.info();
        Mark m1 = new Mark("Maths", 98);
        m1.result();
    }
}
