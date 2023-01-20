import java.util.*;

class Linklist{

    class Node { 
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    Node head;

    public void addFirst(int data){
        Node newNode = new Node(data,head);
        head = newNode;        
    }

    public void addLast(int data){
        if(head == null){
            Node newNode = new Node(data,head);
            head = newNode; 
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        Node newNode = new Node(data);
        currNode.next = newNode;
    }

    public void printlist(){
        if(head == null)
            System.out.print("null");
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.print("null");
    }

    public Node reverseList(Node head){
        if(head == null || head.next == null)
            return head;

        Node newNode = reverseList(head.next);
        head = head.next.next;
        head.next = head;
        return newNode;        
    }

    public static void main(String args[]){
        Linklist l = new Linklist();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(4);
        l.addLast(5);
        l.printlist();
        l.head = l.reverseList(l.head);
        l.printlist();
    }
}