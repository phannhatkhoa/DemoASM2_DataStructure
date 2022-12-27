import java.util.EmptyStackException;
import java.util.Scanner;

public class Stack {
    private Node head;
    private static class Node {
        private String data;
        private Node next;

        private Node(String data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(String data) {
        Node newNode = new Node(data);
       if (head == null) {
           head = newNode;
       }else{
           newNode.next=head;
           head=newNode;
       }
    }

    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        String data = head.data;
        head = head.next;
        return data;
    }

    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.data;
    }
    public void print(){
        if(head == null) throw new Error("Stack is empty! Please check again!");
        int count = 1;
        while (head != null){
            System.out.println("Element " +(count++) + ":" + head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
//        Queue queue = new Queue();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a string: ");
//        String str = sc.nextLine();
//        String[] arr= str.split("\\.");
//        for (int i = 0; i < arr.length; i++) {
//            queue.add(arr[i]);
//        }
//        Stack stack = new Stack();
//        for (int i = 0; i < arr.length; i++) {
//            stack.push(arr[i]);
//        }
//        System.out.println("Stack: ");
        st.push("MM");
        st.push("Ffrg");
        st.push("rnff");
        st.pop();
        st.peek();
        st.print();
    }
}