class Student{
    String name;

    public void info(){
        System.out.println(this.name);
    }

    //s2 object constructor
    Student(Student s2){
        this.name = s2.name;
    }

    //s1 object constructor
    Student(){

    }
}

public class copyconstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Bhaumik";
        Student s2 = new Student(s1);
        s2.info();
    }
}
