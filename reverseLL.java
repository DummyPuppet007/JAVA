public class reverseLL {
    Node head;
    private int size;

    reverseLL(){
        this.size = 0;
    }
    class Node{
        int data;
        Node next;
    
        Node(int data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    //add-first
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
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

    //delete-first
    public void deleteFirst(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        size--;
        head = head.next;
    }

    //delete-last
    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        size--;
        if(head.next == null){
            head = null;
            return;
        }

        Node lastNode = head.next;
        Node secondLastNode = head;

        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }

        secondLastNode.next = null;
    }

    //get list size
    public int getSize(){
        return size;
    }

    public void reverseIterate(){
        //linked list empty or single node list
        if(head == null || head.next == null){
            return;
        }


        Node prevNode = head;
        Node currNode = head.next;

        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public Node reverseRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
        
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        reverseLL list = new reverseLL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printList();
        
        list.reverseIterate();
        System.out.print("Iterative reversed list : ");
        list.printList();

        list.head = list.reverseRecursive(list.head);
        System.out.print("Recursive reversed list : ");
        list.printList();
    }
}
