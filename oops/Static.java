class Student{
    String name;
    static String school;  //static variable

    //static method
    static void intro(){
        System.out.println("this is my detail introduction");
    }

    //static block
    static {
        System.out.println("Static block runs once");
    }

    public Student() {
        System.out.println("Constructor runs every time");
    }

    //static class
    static class Inner {
        void show() {
            System.out.println("Inside static inner class");
        }
    }
}


public class Static {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Bhaumik";
        Student.school = "Parth School";
        System.out.println(Student.school);
        Student.intro();
        new Student();
        Student.Inner obj = new Student.Inner();
        obj.show();
    }
}

//Static methods cannot use this or super