import java.util.NoSuchElementException;

public class Queue {
    private Node head;
    private Node tail;
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
    public void add(String data) {
        Node newNode = new Node(data);

        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
    }
    public String remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        String data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
    public String peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        String data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }

        return data;
    }
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Queue queue= new Queue();
        queue.print();
    }
}