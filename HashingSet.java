import java.util.HashSet;
import java.util.Iterator;

public class HashingSet {
    public static void main(String[] args) {
        //create a hash set
        HashSet<Integer> set = new HashSet<>();

        //add elements to the set
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        //search for an element
        if(set.contains(2)){
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }

        //remove an element
        set.remove(2);
        if(set.contains(2)){
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }

        //size
        System.out.println("Size of the set: " + set.size());

        //print all elements
        System.out.println("Elements in the set: " + set);

        //Iterator
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println("Element: " + iterator.next());
        }

        /*
        //iterate through the set
        for(int element : set){
            System.out.println("Element: " + element);
        }
        */
    }
}
