// find linked list is palindrome or not
public class Que2{
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

    public Node reverse(Node head){
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public Node findMiddle(Node head){
        Node hare = head;
        Node turtle = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle;
    }

    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }

        Node middle = findMiddle(head); //1st half end
        Node secondHalfStart = reverse(middle.next);

        Node firstHalfStart = head;
        while(secondHalfStart != null){
            if(firstHalfStart.data != secondHalfStart.data){
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Que2 list = new Que2();
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(1);
        list.printList();

        System.out.println(list.isPalindrome(list.head));
    }
}