interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

class MultiFunctionPrinter implements Printable, Scannable {
    public void print() {
        System.out.println("Printing...");
    }

    public void scan() {
        System.out.println("Scanning...");
    }
}

public class mulinheritance {
    public static void main(String[] args) {
        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print();
        mfp.scan();
    }
}


//what if interface have same method

// interface A {
//     void show();
// }

// interface B {
//     void show();
// }

// class C implements A, B {
//     public void show() {
//         System.out.println("Same method from both interfaces");
//     }
// }

// --> class just implements the method once.