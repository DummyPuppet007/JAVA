import java.util.*;
public class reverseLLCF {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Collections.reverse(list);

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println("NULL");
    }
}
