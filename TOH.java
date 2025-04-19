import java.util.*;

public class TOH{
    public static void towerOfHanoi(int disc, String src, String helper, String dest){
        if(disc == 1){
            System.out.println("Disc "+disc+" move from "+src+" to "+dest);
            return;
        }

        towerOfHanoi(disc-1, src, dest, helper);
        System.out.println("Disc "+disc+" move from "+src+" to "+dest);
        towerOfHanoi(disc-1, helper, src, dest);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter one number :");
            int n = sc.nextInt();
            towerOfHanoi(n,"S","H","D");
        }
    }
}