import java.util.*;

public class LListCF {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("a");
        list.addFirst("is");
        
        list.addFirst("this");
        list.addLast("list");
        System.out.println(list);
        System.out.println(list.size());

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println("NULL");

        // list.removeFirst();
        // list.removeLast();
        list.remove(3);
        System.out.println(list);
    }
}

//if we use only add then by default data add at last