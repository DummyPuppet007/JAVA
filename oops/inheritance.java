class Shape{
    public void area(){
        System.out.println("Display Area");
    }
}

class Triangle extends Shape{
    public void area(int l, int h){
        System.out.println((0.5)*l*h);
    }
}

class EquilateralTriangle extends Shape{
    public void area(int l, int h){
        System.out.println((0.5)*l*h);
    }
}

class Circle extends Shape{
    public void area(int r){
        System.out.println((3.14)*r*r);
    }
}

public class inheritance {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        EquilateralTriangle et1 = new EquilateralTriangle();
        t1.area(6,6);
        et1.area(8,6);
    }
}


//1. Shape > Triangle --> singlelevel
//2. Shape > Triangle > EquilateralTriangle --> multilevel
//3. Shape > Triangle,Circle --> hierarchical
//4. hybrid --> mox of 1,2,3
//5. multiple (classes ki form me JAVA me nhi hota C++ me hota he,JAVA me interface ka 
//use hota he)