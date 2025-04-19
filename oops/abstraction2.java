interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car starting...");
    }

    public void stop() {
        System.out.println("Car stopping...");
    }

    public void playMusic() {
        System.out.println("Playing music...");
    }
}

public class abstraction2 {
  public static void main(String[] args) {
    Car c1 = new Car();
    c1.start();
    c1.stop();
    c1.playMusic();

    // Vehicle v = new Car();
    // v.start();
    // v.stop();
    // v.playMusic(); // Error : because it's not in vehicle interface 
  }
}

// interface ke constructor nhi hote
// function implementation not allowed in interface
// interface me function ke age public likho ke na likho koi fark nhi padta
// but jab car ko vehicle me implement kare tab public likhna jaruri he varna default le lega