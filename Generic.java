/*
    In java a Generic class is introduce to type safe object it make code as stable.
    JAVA Generics method and class, enable programmer a single method decleration, aset to rated method and types.
    Generic also provide a compile time security and which tell programmer to catch invalid type at compile time.
*/

import java.util.*;

class Linklist<T> {
    //class Node
    class Node { 
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    Node head;

    public void addFirst(T data){
        Node newNode = new Node(data,head);
        head = newNode;        
    }

    public void addLast(T data){
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
}


public class Generic{
    public static void main(String[]args){
        Linklist<Integer> l = new Linklist<Integer>();

        l.addFirst(5);
        l.addFirst(4);
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);
        l.addLast(6);
        l.addLast(7);
        l.addLast(8);
        l.addLast(9);
        l.addLast(10);
        l.printlist();
        System.out.println("");
    }
}