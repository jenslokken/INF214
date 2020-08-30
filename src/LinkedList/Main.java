package LinkedList;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private class Node {
        int value;
        Node prev;
        Node next;
        ReentrantLock lock = new ReentrantLock();

        Node() {}

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private final Node head;
    private final Node tail;

    public Main() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    public int size() {
        int count = 0;
        Node tempHead = head;
        while (tempHead.prev != null) {
            tempHead = head.prev;
            count ++;
        }
        return count;
    }
    public void insert(int value) {
        Node current = head;
        current.lock.lock();
        Node next = current.next;

        try {
            while(true) {
                next.lock.lock();
                try {
                    if (next == tail || next.value < value) {
                        Node node = new Node(value, current, next);
                        next.prev = node;
                        current.next = node;
                        return;
                    }
                }
                finally {
                    current.lock.unlock();
                }
                current = next;
                next = current.next;
            }
        }
        finally {
            next.lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
