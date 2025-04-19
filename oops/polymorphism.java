class Student{
    String name;
    int age;

    public void info(String name){
        System.out.println(name);
    }

    public void info(int age){
        System.out.println(age);
    }

    public void info(String name, int age){
        System.out.println(name + " " + age);
    }

}

public class polymorphism {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.info("Bhaumik");
        s1.info(24);
        s1.info("Bhaumik", 24);
    }
}
