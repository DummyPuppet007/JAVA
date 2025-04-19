abstract class Animal {
  
    abstract void makeSound();

    Animal(){
        System.out.println("you are creating a new animal.");
    }

    void breathe() {
        System.out.println("Breathing...");
    }
}

class Dog extends Animal {
    Dog(){
        System.out.println("This is dog.");
    }
    void makeSound() {
        System.out.println("Bark!");
    }
}

public class abstraction1{
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.breathe();
        dog.makeSound();
    }
}

// first base class constructor call then child class constructor call it's called
// constuctor chaining