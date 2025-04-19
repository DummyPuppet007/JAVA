// check if linked list has cycle or not
public class Que3 {
    Node head;

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //add-last
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    //print list
    public void printList(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("NULL");
    }

    public boolean hasCycle(Node head){
        if(head == null){
            return false;
        }

        Node hare = head;
        Node turtle = head;

        while(hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(Node head){
        if(head == null){
            return;
        }
       
        Node hare = head;
        Node turtle = head;
        boolean isCycle = false;

        while(hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle){
                isCycle = true;
                break;
            }
        }

        //cycle not exist
        if(!isCycle){
            return;
        }

        //cycle exist
        turtle = head;
        Node prev = null; // prev node of meeting point
        while(turtle != hare){
            turtle = turtle.next;
            prev = hare;  //before update hare, store it's previous value
            hare = hare.next;
        }

        //if question is to find the loop start point
        //return tirtle/return hare;

        //if the cycle started at head (entire list is circular)
        if(prev == null){
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = null;
        } else {
            prev.next = null;
        }
    }
    public static void main(String[] args) {
        
        /* detect cycle
        Que3 list = new Que3();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();

        // Create cycle: 4 → 2
        Node lastNode = list.head.next.next.next; // Node with value 4
        Node middleNode = list.head.next; // Node with value 2
        lastNode.next = middleNode;

        System.out.println(list.hasCycle(list.head));
        */

        /* remove cycle
        Que3 list = new Que3();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Create a cycle: 5 → 2
        Node last = list.head.next.next.next.next; // Node with value 5
        Node cycleStart = list.head.next; // Node with value 2
        last.next = cycleStart;

        System.out.println("Before removal - has cycle: " + list.hasCycle(list.head)); // true

        list.removeCycle(list.head);

        System.out.println("After removal - has cycle: " + list.hasCycle(list.head)); // false
        list.printList(); // Now prints properly without infinite loop
        */
    }
}
