//delete nth node from last
public class Que1 {
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

    public Node removeNthFromEnd(Node head,int n){
        //list with 1 node
        if(head.next == null){
            return null;
        }

        int size = 0;
        Node current = head;

        while(current != null){
            current = current.next;
            size++;
        }

        //whene given n equal to list size
        if(n == size){
            return head.next;
        }

        int indexToSearch = size - n;
        Node prev = head;
        int i = 1;
        while(i < indexToSearch){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return head;
    }
    public static void main(String[] args) {
        Que1 list = new Que1();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();

        list.head = list.removeNthFromEnd(list.head, 2);
        list.printList();
    }
}


// for search current node 
// int indexToSearch = size - n + 1;

// while(i == indexToSearch){

// }