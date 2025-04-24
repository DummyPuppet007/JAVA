import java.util.*;


public class QueueCF {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();      
        // here Queue is interface and LinkedList is class, we can't create interface object
        // but we can create object of class which implements Queue interface

        //implement using deque
        //Deque<Integer> deque = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
       
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
